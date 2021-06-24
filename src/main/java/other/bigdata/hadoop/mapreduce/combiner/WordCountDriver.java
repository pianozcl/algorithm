package other.bigdata.hadoop.mapreduce.combiner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import other.bigdata.hadoop.mapreduce.MapReduceEnum;

/**
 * @author : chenliangzhou
 * create at:  2021/6/16  10:31 PM
 * @description:
 **/
public class WordCountDriver {
    public static void main(String[] args) throws Exception{
        // 1 获取配置信息以及获取 job 对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        // 2 关联本 Driver 程序的 jar
        job.setJarByClass(WordCountDriver.class);

        // 3 关联 Mapper 和 Reducer 的 jar
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // 4 设置 Mapper 输出的 kv 类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 5 设置最终输出 kv 类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setCombinerClass(WordCountCombiner.class);

        // 6 设置输入和输出路径
        FileInputFormat.setInputPaths(job, new Path(MapReduceEnum.path + "combiner/input"));
        FileOutputFormat.setOutputPath(job, new Path(MapReduceEnum.path + "combiner/output"));

        // 7 提交 job
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
