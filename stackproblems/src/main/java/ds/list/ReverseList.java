package ds.list;

public class ReverseList {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.next = new Node(12);
        root.next.next = new Node(13);

        display(root);

        root = reverseList(root);

        display(root);
    }

    private static Node reverseList(Node root) {

        Node current = root;
        Node previous = null;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private static void display(Node root) {

        Node current = root;
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
    }
}
