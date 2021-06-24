package other.bigdata.hadoop.mapreduce.partition;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @author : chenliangzhou
 * create at:  2021/6/17  10:24 PM
 * @description:
 **/
public class FlowDriver {
    public static void main(String[] args) throws Exception{
        //1 获取 job 对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //2 关联本 Driver 类
        job.setJarByClass(FlowDriver.class);

        //3 关联 Mapper 和 Reducer
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);

        //4 设置 Map 端输出 KV 类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(other.bigdata.hadoop.mapreduce.partition.FlowBean.class);

        //5 设置程序最终输出的 KV 类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //8 指定自定义分区器
        job.setPartitionerClass(PhonePartitioner.class);

        //9 同时指定相应数量的 ReduceTask
        job.setNumReduceTasks(1);

        //6 设置程序的输入输出路径
        FileInputFormat.setInputPaths(job, new Path("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/bigdata/hadoop/mapreduce/partition/input.txt"));
        FileOutputFormat.setOutputPath(job, new Path("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/bigdata/hadoop/mapreduce/partition/output.txt"));

        //7 提交 Job, true打印更多日志信息
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
    }
}
