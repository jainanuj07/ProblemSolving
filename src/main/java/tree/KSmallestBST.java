package tree;

public class KSmallestBST {

    public static void ksmallest(TreeNode root,int k , Count c) {

        if(root==null || c.cnt >=k)
            return ;

        ksmallest(root.left,k,c);

        c.cnt++;

        if(c.cnt==k) {
            System.out.println(root.data);
        }

        ksmallest(root.right,k,c);
    }


    public static class Count {
        int cnt=0;
    }

    private static void test1() {
        /* Let us construct the below tree
                5
              /   \
            4      5
          /  \      \
         4    4      5 */
       /* TreeNode root = new TreeNode(11);
        root.setLeftChild(new TreeNode(2));
        root.setRightChild(new TreeNode(29));

        root.left.setLeftChild(new TreeNode(1));
        root.left.setRightChild(new TreeNode(7));

        root.right.setRightChild(new TreeNode(40));
        root.right.setLeftChild(new TreeNode(15));

        root.right.right.setLeftChild(new TreeNode(35));
*/
        TreeNode root = new TreeNode(20);
        root.setLeftChild(new TreeNode(8));
        root.setRightChild(new TreeNode(22));
        root.left.setLeftChild(new TreeNode(4));
        root.left.setRightChild(new TreeNode(12));

        root.left.right.setRightChild(new TreeNode(14));
        root.left.right.setLeftChild(new TreeNode(10));


        Count c = new Count();
        ksmallest(root,5,c);

        root.print();

    }
    public static void main(String args[]) {
        test1();
    }

}
