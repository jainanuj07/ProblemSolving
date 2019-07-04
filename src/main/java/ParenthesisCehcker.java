import java.util.Stack;

public class ParenthesisCehcker {

    public static void main(String args[]) {

        String str = "[[]";
        System.out.println(ispar(str));
    }

    static boolean ispar(String st) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '{' || st.charAt(i) == '[' || st.charAt(i) == '(') {
                stack.push(st.charAt(i));
            } else {
                Character c = st.charAt(i);
                if(stack.size()<0)
                    return false;

                if ((c == ']' && stack.pop() == '[') || (c == '}' && stack.pop() == '{') || (c == ')' && stack.pop() == '(')) {
                    continue;
                } else {
                    return false;
                }

            }
        }
        if(stack.isEmpty())
        return true;
        else
            return false;

    }
}

