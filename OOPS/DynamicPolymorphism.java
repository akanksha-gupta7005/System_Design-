package OOPS;


// Dynamic polymorphism
 class SportCar {
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;
    protected String tyre;

    SportCar(String b, String m) {
        brand = b;
        model = m;
        isEngineOn = false;
        currentSpeed = 0;
        tyre = "MRF";
    }

    void start() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " " + ": Engine start with a rear!");
    }

    void stop() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " " + ": Engine turn off ");

    }

     void accelerate(){
        System.out.println("Accelerating");
     }

     void breake(){
        System.out.println("Breaking");
     }
}

class ManualCar extends SportCar {
    private int currentGear;

    ManualCar(String b, String m) {
        super(b, m);
        currentGear = 0;
    }

    void gearShift(int g) {
        currentGear = g;
        System.out.println("Shift to gear :" + currentGear);
    }


    // Override the method
    void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " " + ": Engine is off Cannot accelerate");
            return;
        }
        currentSpeed += 70;
        System.out.println(brand + " " + model + " " + ": Accelerating to  : " + currentSpeed + "km/h");

    }

    // override the method
    void breake() {
        currentSpeed -= 10;
        if (currentSpeed < 0)
            currentSpeed = 0; 
        System.out.println(brand + " " + model + " " + ": Breaking speed is now : " + currentSpeed + "km/h");

    }

}

class ElectricCar extends SportCar {
    private int batteryRate;

    ElectricCar(String b, String m) {
        super(b, m);
        batteryRate = 100;
    }

    void chargeBattery() {
        batteryRate = 100;
        System.out.println(brand + " " + model + " " + ": Battery is fully charge!");
    }


    // override the method
    void accelerate(){
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " " + ": Engine is off Cannot accelerate");
            return;
        }
        if(batteryRate <= 0){
            System.out.println(brand + " " + model + " " + ": Battery is dead! Cannot accelerate");
            return;
        }
        batteryRate -= 10;
        currentSpeed += 60;
        System.out.println(brand + " " + model + " " + ": Accelerating to  :" + currentSpeed + "km/h. Battery at" + batteryRate + "%");
    }

    // override the method
    void breake(){
        currentSpeed -= 15;
        if(currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " " + ": Regenerative! Speed is now  :" + currentSpeed + "km/h. Battery at" + batteryRate + "%");
    }



}

public class DynamicPolymorphism {

    public static void main(String[] args) {
        ManualCar m = new ManualCar("Honda", "Honda City");
        m.start();
        m.accelerate();
        m.breake();

        System.out.println("......................................................................");


        ElectricCar e = new ElectricCar("Tesla", "tesla Model Y");
        e.start();
        e.accelerate();
        e.breake();
        
    }
}