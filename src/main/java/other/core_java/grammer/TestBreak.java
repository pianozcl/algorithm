package other.core_java.grammer;

/**
 * @author : chenliangzhou
 * create at:  2021/7/4  12:19 AM
 * @description:
 **/
public class TestBreak {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    break;
                }
                System.out.println("j " + j);
            }
            System.out.println(i);
        }
    }
}
