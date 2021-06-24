package other.bigdata.hadoop.mapreduce.combiner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : chenliangzhou
 * create at:  2021/6/16  10:31 PM
 * @description:
 **/
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text outK = new Text();
    private IntWritable outV = new IntWritable(1);
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //1 获取一行
        String line = value.toString();

        //切割
        String[] words = line.split(" ");


        for (String word : words) {

            outK.set(word);

            //写出
            context.write(outK, outV);
        }
    }
}
