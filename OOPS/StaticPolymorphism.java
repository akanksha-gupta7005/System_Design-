package OOPS;

  class ManualCar {
    private String brand;
    private String model;
    private boolean isEngineOn;
    private int currentSpeed;
    private String tyre;
    private int currentGear;

    ManualCar(String b, String m) {
        brand = b;
        model = m;
        isEngineOn = false;
        currentSpeed = 0;
        tyre = "MRF";
         currentGear = 0;
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

    
    void gearShift(int g) {
        currentGear = g;
        System.out.println("Shift to gear :" + currentGear);
    }

    void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " " + ": Engine is off Cannot accelerate");
            return;
        }
        currentSpeed += 70;
        System.out.println(brand + " " + model + " " + ": Accelerating to  : " + currentSpeed + "km/h");

    }

    void accelerate(int speed) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " " + ": Engine is off Cannot accelerate");
            return;
        }
        currentSpeed += speed;
        System.out.println(brand + " " + model + " " + ": Accelerating to  : " + currentSpeed + "km/h");

    }



    void breake() {
        currentSpeed -= 10;
        if (currentSpeed < 0)
            currentSpeed = 0; 
        System.out.println(brand + " " + model + " " + ": Breaking speed is now : " + currentSpeed + "km/h");

    }

     
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        ManualCar m = new ManualCar("Toto", "Toto Type 5");
        m.start();
        m.accelerate();
        m.accelerate(30);
        m.breake();
        m.stop();
    }
    
}
