package ds.stack;

import java.util.*;

public class MyStackUsingArrayMain {

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.size();
        MyStackUsingArray<Integer> stack = new MyStackUsingArray<>(10);

        System.out.println("Stack capacity is: " + stack.getMaxElements());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
    }
}

class MyStackUsingArray<V> {

    private V[] arr;
    private int maxElements;
    private int top;

    public MyStackUsingArray(int maxElements) {
        this.arr = (V[])new Object[maxElements];
        this.maxElements = maxElements;
        this.top = -1;
    }

    public void push(V element) {

        if(isFull()) {
            System.out.println("Stack full....");
            return;
        }
        arr[++top] = element;
    }

    public V pop() {

        if(isEmpty()) {
            System.out.println("Stack e,pty....");
            return null;
        }
        return arr[top--];
    }

    public V[] getElements() {
        return arr;
    }

    public int getMaxElements() {
        return maxElements;
    }

    public void setMaxElements(int maxElements) {
        this.maxElements = maxElements;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return top == maxElements -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        return "MyStackUsingArray{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
