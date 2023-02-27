package Graph;

public class AvlTree {
    public static class Node{
        Node left;
        Node right;
        int data;
        int height;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
            height = 1;
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
        else {
            return root;
        }
        root.height = Math.max(root.left.height, root.right.height) +1;
        int balanceFactor = getBalanceFactor(root);
        //RR
        if (balanceFactor<0 && data>root.right.data){
            leftRotate(root);
        }
        //RL
        else if (balanceFactor<-1 && data<root.right.data){
            root.right = rightRotate(root.right);
            leftRotate(root);
        }
        //LL
        else if (balanceFactor>1 && data<root.left.data) {
            rightRotate(root);
        }
        //LR
        else if (balanceFactor>1 && data>root.left.data){
            root.left = leftRotate(root.left);
            rightRotate(root);
        }
        return root;
    }
    public int getHeight(Node node){
        if (node==null){
            return 0;
        }
        return node.height;
    }
    public int getBalanceFactor(Node root){
        if (root==null){
            return 0;
        }
        return getHeight(root.left) - getHeight(root.right);
    }
    public Node leftRotate(Node x){
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        return y;
    }
    public Node rightRotate(Node y){
        Node x =y.left;
        Node t2 = x.right;
        x.right = y;
        y.left = t2;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }
}
//node delete - practice
