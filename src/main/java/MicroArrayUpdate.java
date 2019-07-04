import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MicroArrayUpdate {

    public static void main(String[] args) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {

            String[] str = br.readLine().split(" ");
            int K = Integer.parseInt(str[1]);

            String[] str1 = br.readLine().split(" ");

            int min = Integer.parseInt(str1[0]);
            for (int j = 0; j < str1.length; j++) {

                int k = Integer.parseInt(str1[j]);
                if (k < min)
                    min = k;
            }

            if (min > K)
                System.out.println(0 + "");
            else

                System.out.println(K - min);

        }
    }
}