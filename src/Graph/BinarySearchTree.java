package Graph;

public class BinarySearchTree {
    public static class Node{
        Node left;
       Node right;
        int data;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public Node createBST(Node root, int data){
        if (root == null){
            return new Node(data);
        }
        if (data< root.data){
            root.left = createBST(root.left, data);
        } else if (data> root.data) {
            root.right = createBST(root.right,data);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Node root = tree.createBST(null,20);
        root = tree.createBST(root,10);
        root = tree.createBST(root,30);
        root = tree.createBST(root,7);
    }
}
