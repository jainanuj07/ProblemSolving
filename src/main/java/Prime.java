import java.io.BufferedReader;
import java.io.InputStreamReader;

class Prime {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for (int i = 2; i <= number; i++) {
            int j = 2;
            boolean prime = true;
            while (j <= i / 2) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
                j++;
            }

            if (prime) {
                System.out.print(i + " ");
            }
        }

    }
}
