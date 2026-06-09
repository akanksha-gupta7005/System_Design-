package SOLID_Principle;

class Animal {

}

class Dog extends Animal {

}

// covariant return types in method overriding

class Parent {
    Animal getAnimal() {
        System.out.println("Parent: Return animal instance....");
        return new Animal();
    }
}

class Child extends Parent {
    @Override
    Dog getAnimal() {
        System.out.println("Child: Return dog instance....");
        return new Dog();
    }
}

class Client {
    Parent p;

    Client(Parent p) {
        this.p = p;
    }

    void takeAnimal() {
        p.getAnimal();

    }
}

public class ReturnType {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();

        Client ct = new Client(p);
        ct.takeAnimal();
    }

}
