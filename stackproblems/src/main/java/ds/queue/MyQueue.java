package ds.queue;

import java.util.*;

public class MyQueue {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()) {
            //Return and remove first element
            System.out.println(q.poll());

            //Returns first element and does not removes
            //System.out.println(q.element());
        }

        //Integer element = q.element();

    }
}
