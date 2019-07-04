import java.util.Stack;

public class Palindrome {

    public static void main(String args[]) {
        String s = "abaa";

        int l = s.length();

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < l / 2) {
            stack.add(s.charAt(i));
            i++;
        }

        boolean isPalindrome = true;
        if (l % 2 != 0) {
            i++;
        }

        for (int j = i; j < l; j++) {
            if (!stack.pop().equals(s.charAt(j))) {
                isPalindrome = false;
                break;
            }
        }
            if (isPalindrome)
                System.out.printf("yes");
            else
                System.out.printf("no");

    }
}

