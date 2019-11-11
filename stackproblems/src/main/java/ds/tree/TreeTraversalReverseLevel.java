package ds.tree;

import java.util.*;

public class TreeTraversalReverseLevel {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.setLeft(new TreeNode(7));
        root.setRight(new TreeNode(1));
        root.getLeft().setLeft(new TreeNode(9));
        root.getRight().setLeft(new TreeNode(10));
        root.getRight().setRight(new TreeNode(5));

        Stack<List<Integer>> stack = levelOrderTraversal(root);

        while(!stack.empty()) {
            List<Integer> pop = stack.pop();
            System.out.println(pop);
        }
    }

    static Stack<List<Integer>> levelOrderTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<List<Integer>> stack = new Stack<>();

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

            stack.push(currentLevel);
        }

        return stack;

    }
}

