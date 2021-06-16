package other.bigdata.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author : chenliangzhou
 * create at:  2021/6/14  5:30 PM
 * @description:
 **/
public class HDFSClient {

    private FileSystem fs;

    @Before
    public void init() throws Exception {
        //连接集群namenode地址
        URI uri = new URI("hdfs://centos1:8020");

        //创建配置文件
        Configuration configuration = new Configuration();

        //获取客户端对象
        fs = FileSystem.get(uri, configuration, "root");
    }

    @After
    public void close() throws Exception {
        fs.close();
    }

    @Test
    public void testmkdir() throws Exception {


        //对hdfs进行操作
        fs.mkdirs(new Path("/xiyou/huaguoshan"));
    }

    /**
     * 配置文件优先级
     * (1)客户端代码中设置的值 >(2)ClassPath 下的用户自定义配置文件 >(3)然后是服务器的自定义配置(xxx-site.xml)>(4)服务器的默认配置(xxx-default.xml)
     *
     * @throws Exception
     */
    @Test
    public void testPut() throws Exception {
        fs.copyFromLocalFile(false, true, new Path("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/bigdata/hadoop/hdfs/HDFSClient.java"), new Path("/xiyou/huaguoshan"));
    }


    @Test
    public void testGet() throws Exception {
        fs.copyToLocalFile(false, new Path("xiyou/huaguoshan"), new Path("下载到哪个路径"), false);
    }

    @Test
    public void testListFiles() throws IOException, InterruptedException,URISyntaxException {
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://centos1:8020"), configuration, "root");
        // 2 获取文件详情
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"),true);
        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();
            System.out.println("========" + fileStatus.getPath() + "=========");
            System.out.println(fileStatus.getPermission());
            System.out.println(fileStatus.getOwner());
            System.out.println(fileStatus.getGroup());
            System.out.println(fileStatus.getLen());
            System.out.println(fileStatus.getModificationTime());
            System.out.println(fileStatus.getReplication());
            System.out.println(fileStatus.getBlockSize());
            System.out.println(fileStatus.getPath().getName());
            // 获取块信息
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            System.out.println(Arrays.toString(blockLocations));
        }
            // 3 关闭资源 fs.close();
    }

    @Test
    public void testFileOrDir() throws Exception{
        // 1 获取文件配置信息
        Configuration configuration = new Configuration();
        FileSystem.get(new URI("hdfs://centos1:8020"), configuration, "root");
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus fileStatus : fileStatuses) {
            if (fileStatus.isFile()) {
                System.out.println("f: " + fileStatus.getPath().getName());
            } else {
                System.out.println("d: " + fileStatus.getPath().getName());
            }
        }
        fs.close();

    }
}
