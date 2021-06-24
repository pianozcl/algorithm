package other.bigdata.hadoop.mapreduce.partition;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author : chenliangzhou
 * create at:  2021/6/19  2:37 PM
 * @description: 根据手机号首位进行分区
 *
 *
 * (1)如果ReduceTask的数量> getPartition的结果数，则会多产生几个空的输出文件part-r-000xx;
 * (2)如果1<ReduceTask的数量<getPartition的结果数，则有一部分分区数据无处安放，会Exception;
 * (3)如果ReduceTask的数量=1，则不管MapTask端输出多少个分区文件，最终结果都交给这一个 ReduceTask，最终也就只会产生一个结果文件 part-r-00000;
 * (4)分区号必须从零开始，逐一累加。
 **/
public class PhonePartitioner extends Partitioner<Text, FlowBean> {
    @Override
    public int getPartition(Text text, FlowBean flowBean, int numPartitions) {
        String s = text.toString();
        char c = s.charAt(0);

        int partition = 0;
        if ('1' == c) {
            partition = 0;
        } else if ('2' == c) {
            partition = 1;
        } else if ('3' == c) {
            partition = 2;
        } else if ('4' == c) {
            partition = 3;
        }
        return partition;
    }
}
