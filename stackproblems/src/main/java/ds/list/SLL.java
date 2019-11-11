package ds.list;

public class SLL<T> {

    public class Node {
        T data;
        Node next;
    }

    Node head;
    int size;

    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void display() {
        Node current = head;

        while(current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.print(current.data);
    }

    public Node reverseList() {

        SLL<T>.Node pre = null;
        SLL<T>.Node cur = head;
        SLL<T>.Node nxt = null;

        while(cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        head = pre;

        return head;
    }

    public static void main(String[] args) {

        SLL<Integer> sll = new SLL<Integer>();
        sll.insertAtHead(1);
        sll.insertAtHead(2);
        sll.insertAtHead(3);
        sll.insertAtHead(4);

        sll.display();

        sll.reverseList();

        System.out.println("\n Reversed list is: ");

        sll.display();

    }
}
