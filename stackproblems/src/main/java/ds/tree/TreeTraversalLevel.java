package ds.tree;

import java.util.*;

public class TreeTraversalLevel {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.setLeft(new TreeNode(7));
        root.setRight(new TreeNode(1));
        root.getLeft().setLeft(new TreeNode(9));
        root.getRight().setLeft(new TreeNode(10));
        root.getRight().setRight(new TreeNode(5));

        List<List<Integer>> lists = levelOrderTraversal(root);
        System.out.println(lists);

    }

    static List<List<Integer>> levelOrderTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        queue.offer(root);

        while(!queue.isEmpty()) {

            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for(int i =0; i< levelSize; i++) {
                TreeNode treeNode = queue.poll();

                currentLevel.add(treeNode.getData());

                if(treeNode.getLeft() != null) {
                    queue.offer(treeNode.getLeft());
                }

                if(treeNode.getRight() != null) {
                    queue.offer(treeNode.getRight());
                }
            }

            levels.add(currentLevel);
            System.out.println("Added level: " + currentLevel);
        }

        return levels;

    }
}

