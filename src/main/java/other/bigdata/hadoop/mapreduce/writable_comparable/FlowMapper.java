package other.bigdata.hadoop.mapreduce.writable_comparable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : chenliangzhou
 * create at:  2021/6/17  10:04 PM
 * @description:
 **/
public class FlowMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
    private FlowBean outK = new FlowBean();
    private Text outV = new Text();


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split(" ");


        outK.setUpFlow(Long.parseLong(split[1]));
        outK.setDownFlow(Long.parseLong(split[2]));
        outK.setSumFlow();
        outV.set(split[0]);

        context.write(outK, outV);
    }
}
