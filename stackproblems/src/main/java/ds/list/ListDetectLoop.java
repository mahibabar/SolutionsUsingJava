package ds.list;

public class ListDetectLoop {

    public static boolean detectLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.next = new Node(12);
        root.next.next = new Node(13);
        root.next.next.next = root;

        boolean b = detectLoop(root);
        System.out.println("Loop present in the list: " + b);

    }
}
