import java.util.ArrayList;

public class Subsets {

    public static void main(String args[]) {
        String str = "abc";
        ArrayList<ArrayList<String>> subsets;

        subsets = getSubsets(str);
        System.out.println(subsets.toString());

    }

    public static ArrayList<ArrayList<String>> getSubsets(String str) {

        if(str.length()==0) {
            ArrayList<ArrayList<String>> ss = new ArrayList<>();
           ss.add(new ArrayList<>());
           return ss;
        }

        char s = str.charAt(str.length()-1);
        String substring = str.substring(0,str.length()-1);
        ArrayList<ArrayList<String>> lists = getSubsets(substring);

        ArrayList<ArrayList<String>> t = new ArrayList<>();
        t.addAll(lists);
        for(ArrayList<String>list : lists) {
            ArrayList<String> n = new ArrayList<>();
            n.addAll(list);
            n.add(String.valueOf(s));
            t.add(n);
        }
        return t;
    }

}
