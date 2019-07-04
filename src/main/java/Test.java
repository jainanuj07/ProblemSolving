import java.util.Arrays;
import java.util.Comparator;

public class Test {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A) {

        String arr[] = new String[A.length];
        for(int i=0;i<A.length;i++)
        {
            arr[i] = String.valueOf(A[i]);
        }

        Arrays.sort(arr,new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }

        while(sb.charAt(0)=='0'&&sb.length()>1)
            sb.deleteCharAt(0);

        return sb.toString();

    }

    public static void main(String args[]) {
        int[] a = new int[] {5,60};
        Test test = new Test();
        System.out.println(test.largestNumber(a));
        String arr[] = new String[a.length];
        for(int i=0;i<a.length;i++)
        {
            arr[i] = String.valueOf(a[i]);
        }
        for(String s :arr) {
            System.out.println(s);
        }
        Arrays.sort(arr,new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });

        for(String s :arr) {
            System.out.println(s);
        }

        String s = "id";

        System.out.print(s.split(",")[0]);
    }
}
