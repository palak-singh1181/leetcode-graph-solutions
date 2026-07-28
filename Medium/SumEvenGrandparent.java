public class SumEvenGrandparent {


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;


        TreeNode(int val) {
            this.val = val;
        }
    }



    public static int sumEvenGrandparent(TreeNode root) {


        if (root == null) {
            return 0;
        }


        int sum = 0;


        if (root.val % 2 == 0) {


            if (root.left != null) {


                if (root.left.left != null)
                    sum += root.left.left.val;


                if (root.left.right != null)
                    sum += root.left.right.val;
            }



            if (root.right != null) {


                if (root.right.left != null)
                    sum += root.right.left.val;


                if (root.right.right != null)
                    sum += root.right.right.val;
            }

        }


        sum += sumEvenGrandparent(root.left);

        sum += sumEvenGrandparent(root.right);


        return sum;
    }



    public static void main(String[] args) {


        TreeNode root = new TreeNode(6);


        root.left = new TreeNode(7);
        root.right = new TreeNode(8);


        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);


        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);


        System.out.println(sumEvenGrandparent(root));

    }
}