package ds.tree;

public class BSTInsertRecursion {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        TreeNode treeNode = insertRecursive(root, 11);
        insertRecursive(root, 1);
        insertRecursive(root, 12);
        printTree(root);


    }

    static TreeNode insertRecursive(TreeNode node, int value) {

        if(node == null) {
            return new TreeNode(value);
        }

        if(value < node.getData()) {
            //InsertLeft
            node.setLeft(insertRecursive(node.getLeft(), value));
        } else if(value > node.getData()) {
            //insertRight
            node.setRight(insertRecursive(node.getRight(), value));
        } else {
            System.out.println("Duplicate entry...");
            return node;
        }

        return node;
    }

    static void printTree(TreeNode startNode) {

        if(startNode != null) {
            printTree(startNode.getLeft());
            System.out.println(startNode.getData());
            printTree(startNode.getRight());
        }
    }}
