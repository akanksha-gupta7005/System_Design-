package OOPS;

abstract class Car {
    abstract void start();

    abstract void stop();

    abstract void gearShift(int g);

    abstract void breaks();

    abstract void accelerate();

}

class SportCar extends Car {
    String brand;
    String model;
    boolean isEngineOn;
    int currentSpeed;
    int currentGear;

    SportCar(String b, String m){
         brand = b;
         model = m;
         isEngineOn = false;
         currentGear = 0;
         currentSpeed = 0;
    }

    void start(){
        isEngineOn = true;
        System.out.println(brand + " " + model + " " + ": Engine start with a rear!");
    }

    void gearShift(int g){
        if(!isEngineOn){
        System.out.println(brand + " " + model + " " + ": Engine is off! Cannot Shift gear");
         return;
        }

        currentGear = g;
        System.out.println("Shift to gear :" + currentGear);

    }

    void accelerate(){
        if(!isEngineOn){
        System.out.println(brand + " " + model + " " + ": Engine is off Cannot accelerate");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " " + ": Accelerating to  :" + currentSpeed + "km/h");

    }

    void breaks(){
        currentSpeed -= 10;
        if(currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " " + ": Breaking speed is now :" + currentSpeed + "km/h");

    }
    void stop(){
        isEngineOn = false;
        currentGear = 0;
         currentSpeed = 0;
        System.out.println(brand + " " + model + " " + ": Engine turn off ");

    }

   
}

public class AboutCar {
    public static void main(String[] args) {
        SportCar sp = new SportCar("Roll Royal", "Version 10");
        sp.start();
        sp.gearShift(2);
        sp.accelerate();
        // sp.breaks();
        // sp.stop();

        // sp.start();
        sp.gearShift(4);
        sp.accelerate();
        sp.breaks();
        sp.stop();


    }

}
