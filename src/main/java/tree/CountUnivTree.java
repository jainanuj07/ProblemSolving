package tree;

public class CountUnivTree {

    public static void main(String args[]) {
        test1();
        test2();
    }

    private static void test1() {
        /* Let us construct the below tree
                5
              /   \
            4      5
          /  \      \
         4    4      5 */
        TreeNode root = new TreeNode(5);
        root.setLeftChild(new TreeNode(4));
        root.setRightChild(new TreeNode(5));

        root.left.setLeftChild(new TreeNode(4));
        root.left.setRightChild(new TreeNode(4));

        root.right.setRightChild(new TreeNode(5));

        root.print();
        Count c = new Count();
        getUnivTreeCount(root, c);

        System.out.println(c.cnt);
    }


    private static void test2() {
        /* Let us construct the below tree
                5
              /   \
            5      5
          /  \    /  \
                  5   5
                       \
                        4
        */
        TreeNode root = new TreeNode(5);
        root.setLeftChild(new TreeNode(5));
        root.setRightChild(new TreeNode(5));

        root.right.setLeftChild(new TreeNode(5));
        root.right.setRightChild(new TreeNode(5));

        root.right.right.setRightChild(new TreeNode(4));

        root.print();
        Count c = new Count();
        getUnivTreeCount(root, c);

        System.out.println(c.cnt);
    }

    static class Count {
        int cnt = 0;
    }

    public static boolean getUnivTreeCount(TreeNode root, Count c) {

        if (root == null) return true;

        boolean leftS = getUnivTreeCount(root.left, c);
        boolean rightS = getUnivTreeCount(root.right, c);

        if (leftS == false || rightS == false) {
            return false;
        }

        if (root.left != null && root.data != root.left.data) return false;

        if (root.right != null && root.data != root.right.data) return false;

        c.cnt++;
        return true;

    }
}
