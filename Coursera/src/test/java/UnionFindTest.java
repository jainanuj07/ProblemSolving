import Util.StdIn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnionFindTest {
    public static void main(String args[]) throws FileNotFoundException {
        File file = new File(
                "/Users/Januj/Documents/GitHub/ProblemSolving/Coursera/src/main/resources/tinyUF" + ".txt");
        Scanner scanner = new Scanner(file);
        StdIn.setScanner(scanner);

        int N = StdIn.readInt();
        QuickFindUF quickFindUF = new QuickFindUF(N);

        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            quickFindUF.union(p, q);
        }
        System.out.println("connected components----"+quickFindUF.count);
        System.out.println(quickFindUF.connected(1, 9));
    }
}
