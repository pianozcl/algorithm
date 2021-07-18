package other.core_java.scanner;

import java.util.Scanner;

/**
 * @author : chenliangzhou
 * create at:  2021/7/16  11:35 AM
 * @description:
 **/
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String next = scanner.next();
//            System.out.println(next);
//        }

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(s);
        }


        scanner.close();
    }
}
