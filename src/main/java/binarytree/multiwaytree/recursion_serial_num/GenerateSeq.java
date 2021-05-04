package binarytree.multiwaytree.recursion_serial_num;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/4/19  11:32 PM
 * @description: 动态生成序号
 **/
public class GenerateSeq {
    public static void generateSeq(List<Organization> target, List<Organization> source, Organization root, String seq) {
        Organization organization = new Organization();
        organization.setSeq(seq);
        target.add(organization);
        for (int i = 0, n = 0; i < source.size(); i++) {
            if (source.get(i).getParentId() != null && source.get(i).getParentId().equals(root.getId())) {
                n++;
                generateSeq(target, source, source.get(i), seq.concat(".").concat(Integer.toString(n)));
            }
        }
    }


    public static void main(String[] args) {
//        Organization organization = new Organization("1", "");
//        Organization organization1 = new Organization("1_1", "1");
//        Organization organization2 = new Organization("1_2", "1");
//        Organization organization3 = new Organization("1_1_1", "1_1");
//        Organization organization4 = new Organization("1_2_1", "1_2");
//
//        List<Organization> source = new ArrayList<>();
//        source.add(organization);
//        source.add(organization1);
//        source.add(organization2);
//        source.add(organization3);
//        source.add(organization4);
//
//        List<Organization> target = new ArrayList<>();
//        generateSeq(target, source, organization, "1");
//        for (Organization org : target) {
//            System.out.println(org.getSeq());
//        }
        recur(1);

    }

    public static void recur(int i) {
        int[] arr = new int[1000];
        System.out.println(i);
        recur(i + 1);
    }
}
