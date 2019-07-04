import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class TestClass {
    public static void main(String args[]) throws Exception {
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

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap();
        String arr[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(arr[i]);
            if (map.containsKey(a)) {
                int c = map.get(a);
                map.put(a, c + 1);
            } else
                map.put(a, 1);
        }

        int q = Integer.parseInt(br.readLine());

        for (int j = 0; j < q; j++) {
            int a = Integer.parseInt(br.readLine());

            if (map.containsKey(a)) {
                System.out.println(map.get(a));
            } else {
                System.out.println("NOT PRESENT");
            }

        }
    }
}
