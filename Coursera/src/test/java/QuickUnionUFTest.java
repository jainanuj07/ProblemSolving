import Util.StdIn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickUnionUFTest {

    public static void main(String args[]) throws FileNotFoundException {
        File file = new File(
                "/Users/Januj/Documents/GitHub/ProblemSolving/Coursera/src/main/resources/tinyUF" + ".txt");
        Scanner scanner = new Scanner(file);
        StdIn.setScanner(scanner);

        int N = StdIn.readInt();
        QuickUnionUF quickUnionUF = new QuickUnionUF(N);

        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            quickUnionUF.union(p, q);
        }
        quickUnionUF.printIdArray();
        System.out.println("connected components----"+quickUnionUF.count);
        System.out.println(quickUnionUF.connected(1, 9));
    }
}
