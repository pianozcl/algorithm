package other.bigdata.hadoop.mapreduce.writable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : chenliangzhou
 * create at:  2021/6/17  10:04 PM
 * @description:
 **/
public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    private Text outK = new Text();
    private FlowBean outV = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split(" ");

        outK.set(split[0]);
        outV.setUpFlow(Long.parseLong(split[1]));
        outV.setDownFlow(Long.parseLong(split[2]));
        outV.setSumFlow();

        context.write(outK, outV);
    }
}
