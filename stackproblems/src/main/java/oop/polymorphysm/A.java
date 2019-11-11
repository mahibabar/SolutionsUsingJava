package oop.polymorphysm;

public interface A {

    default void execute() {
        System.out.println("executing A");
    }

    default void display() {
        System.out.println("Display... A");
    }
}
