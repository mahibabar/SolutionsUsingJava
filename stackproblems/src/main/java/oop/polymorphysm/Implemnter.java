package oop.polymorphysm;

public class Implemnter implements A {

    @Override
    public void execute() {
        System.out.println("Implementer....");
    }

    public static void main(String[] args) {
        A a = new Implemnter();
        a.execute();
        a.display();
    }
}
