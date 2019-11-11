package designpattern;

public enum SingleTon {

    INSTANCE;

    SingleTon() {
        System.out.println("Default constructor...");
    }
    public void display() {
        System.out.println("Test....");
    }

    public static void main(String[] args) {
        SingleTon.INSTANCE.display();
    }
}
