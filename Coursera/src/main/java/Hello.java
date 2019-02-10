public class Hello {

    public static void main(String args[]) {
        int n = 10;
        while(n<100000000) {
            printHello();
            if(n%10==0)
            {
                printHi();
            }
            n++;
        }
    }

     public static void printHello() {
         System.out.println("Helo------");
     }
    public static void printHi() {
        System.out.println("Hi------");
    }
}
