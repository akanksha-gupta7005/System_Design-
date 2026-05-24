package OOPS;

abstract class Mobile {

    protected String brand;
    protected String version;
    protected String RAM;

    Mobile(String b, String v, String r) {
        brand = b;
        version = v;
        RAM = r;
    }

    // Using Abstraction

    abstract void calling();

    abstract void osModel();

    abstract void task();

}

// Using Inheritance
class SimplePhone extends Mobile {

    // Using Ecapslation
    private String chargingType;

    SimplePhone(String b, String v, String r, String c) {
        super(b, v, r);
        chargingType = c;
        System.out.println("Brand" + " " + b + "|" + "Version" + " " + v + "|" + "RAM" + " " + r + "|" + "ChargingType" + " " + c);
    }


    // Using Polymorphism
    @Override
    void calling() {
        System.out.println("Simple Phone has only voice calling function!");
    }

    void osModel() {
        System.out.println("Simple phone has a simple operating system!");
    }

    void task() {
        System.out.println("It complete only one task at a time.");
    }

}

// Using Inheritance
class SmartPhone extends Mobile {
    private String charginString;

    SmartPhone(String b, String v, String r, String c) {
        super(b, v, r);
        charginString = c;
        System.out.println("Brand" + " " + b + "|" + "Version" + " " + v + "|" + "RAM" + " " + r + "|" + "ChargingType" + " " + c);
        
    }

    void calling() {
        System.out.println("Smart Phone has both voice call as well as video call function !");
    }

    void osModel() {
        System.out.println("Smart phone has either Android OS or iOS OS!");
    }

    void task() {
        System.out.println("It complete multiple task at a time.");
    }

}

public class FullExplainationOfOOPs {
    public static void main(String[] args) {
        SimplePhone si = new SimplePhone("Nokia", "105", "4 MB", "B-Type");
        si.calling();
        si.osModel();
        si.task();

        System.out.println("...........................................................");

        SmartPhone s = new SmartPhone("iPhone", "15", "8 GB", "C-Type");
        s.calling();
        s.osModel();
        s.task();
    }
}
