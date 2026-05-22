package OOPS;


class SportCar {
    private String brand;
    private String model;
    private boolean isEngineOn;
    private int currentSpeed;
    private int currentGear;
    private String tyre;

    SportCar(String b, String m){
         brand = b;
         model = m;
         isEngineOn = false;
         currentGear = 0;
         currentSpeed = 0;
         tyre = "MRF";
    }

    // getter and setter

    int getcurrentSpeed(){
        return this.currentSpeed;
    }

    String getTyre(){
        return this.tyre;
    }

    void setTyre(String tyre){
        this.tyre = tyre;
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

public class Encapsulation {
    public static void main(String[] args) {
        SportCar sp = new SportCar("Roll Royal", "Version 10");
        sp.start();
        sp.gearShift(2);
        sp.accelerate();
        
        sp.gearShift(4);
        sp.accelerate();
        sp.breaks();
        sp.stop();

        System.out.println(sp.getcurrentSpeed());


    }

}
