
package SOLID_Principle;

class Parent {
    void print(String str, int age) {
        System.out.println("Parent....");
    }
}

class Child extends Parent {
    @Override
    void print(String s, int age) {
        System.out.println("Child...");
    }
}

class Client {
    Parent p;

    Client(Parent p) {
        p.print("Rita", 34);

    }
}

public class SignatureRule {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();

        Client cl = new Client(c);
    }
}