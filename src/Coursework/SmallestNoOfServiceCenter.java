package Coursework;

/**The binary tree is represented using a class TreeNode that has an integer value val, and left and right child nodes.**/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SmallestNoOfServiceCenter {

    /**The helper method first checks if the input TreeNode is null, in which case it returns an array of two zeros.
     * Otherwise, it recursively calls the helper method on the left and right child nodes, and stores their return values in the left and right arrays.
     **/
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int centers = left[1] + right[1];
        /**Next, the function calculates the number of service centers required for the current node by adding the second elements of the left and right arrays.
         * If the input TreeNode has no grandchildren, then only one service center is required, and the function returns an array of {1,1}.**/
        if (left[0] == 0 && right[0] == 0) {
            return new int[]{1, 1};
        }
        /**Otherwise, the function returns an array of {2, centers + 1}, where centers is the number of service centers required for the left and right subtrees,
         * and 1 is added to account for the current TreeNode**/
        return new int[]{2, centers + 1};
    }

    /**The minServiceCenters method is a wrapper function that calls the helper function on the root of the binary tree
     *  and returns the first element of the resulting array, which represents the minimum number of service centers required
     *  for the entire tree.**/
    public int minServiceCenters(TreeNode root) {
        int[] result = helper(root);
        return result[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = null;
        root.left.right = new TreeNode(0);
        root.right.left = null;
        root.right.right = null;
        root.left.right.left = new TreeNode(0);

        SmallestNoOfServiceCenter smallestNoOfServiceCenter = new SmallestNoOfServiceCenter();
        int minCenters = smallestNoOfServiceCenter.minServiceCenters(root);

        System.out.println("Minimum number of service centers required: " + minCenters);
    }
}
