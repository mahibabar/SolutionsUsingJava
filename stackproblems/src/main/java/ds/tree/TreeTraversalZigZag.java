package ds.tree;

import java.util.*;

public class TreeTraversalZigZag {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.setLeft(new TreeNode(7));
        root.setRight(new TreeNode(1));
        root.getLeft().setLeft(new TreeNode(9));
        root.getRight().setLeft(new TreeNode(10));
        root.getRight().setRight(new TreeNode(5));

        List<List<Integer>> result = zigzagTraversal(root);

        for(int i=0; i< result.size(); i++) {
            if(i%2 != 0) {
                List<Integer> oddLevel = result.get(i);
                System.out.println(oddLevel);
            } else {
                List<Integer> evenLevel = result.get(i);
                for(int j = evenLevel.size() -1; j>=0 ; j--) {
                    System.out.print(evenLevel.get(j) + " ");
                }
                System.out.println("");
            }
        }
    }

    static List<List<Integer>> zigzagTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> levels = new ArrayList<>();

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
        }

        return levels;

    }
}

