class BinaryTreeTraversal {
    private static Tree root = null;

    public static void main(String args[]) {
        System.out.println("Binary Tree Operations");
        int[] input = new int[]{4, 2, 5, 1, 3};
        // data insertion!
        for (int i : input) {
            insert(i);
        }

        System.out.println("\nInOrder Traversal : ");
        inOrder(root);
        System.out.println("\nPreOrder Traversal : ");
        preOrder(root);
        System.out.println("\nPostOrder Traversal : ");
        postOrder(root);
        System.out.println("\n");

        int target = 2;
        System.out.println("Binary Search : Target -> " + target);
        System.out.println("Search result : " + binarySerach(target, root));
    }

    // binary search
    private static boolean binarySerach(int target, Tree root) {
        if (root == null) return false;

        while (root != null) {
            if (target == root.val) return true;
            root = (target <= root.val) ? root.left : root.right;
        }
        return false;
    }

    // pre order
    private static void preOrder(Tree root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // post order
    private static void postOrder(Tree root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    // in order
    private static void inOrder(Tree root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // Tree Insertion!
    private static void insert(int val) {
        if (root == null) {
            root = new Tree(val);
            return;
        }
        Tree cur = root;
        while (cur != null) {
            if (val <= cur.val && cur.left == null) {
                cur.left = new Tree(val);
                return;
            } else if (val > cur.val && cur.right == null) {
                cur.right = new Tree(val);
                return;
            }

            cur = (val <= cur.val) ? cur.left : cur.right;
        }
    }

    // Binary Tree Defination !
    static class Tree {
        int val;
        Tree left = null, right = null;

        Tree(int val) {
            this.val = val;
        }
    }


}