package OOPS;

class SportCar {
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;
    protected String tyre;

    SportCar(String b, String m){
         brand = b;
         model = m;
         isEngineOn = false;
         currentSpeed = 0;
         tyre = "MRF";
    }

    void start(){
        isEngineOn = true;
        System.out.println(brand + " " + model + " " + ": Engine start with a rear!");
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
        currentSpeed = 0;
        System.out.println(brand + " " + model + " " + ": Engine turn off ");

    }

   
}

class ManualCar extends SportCar{
        private int currentGear = 0;

        ManualCar(String b, String m){
            super(b, m);
            currentGear = 0;
        }

       void gearShift(int g){
        currentGear = g;
        System.out.println("Shift to gear :" + currentGear);

    }

}

class ElectricCar extends SportCar{
    private int batteryRate;

    ElectricCar(String b, String m){
        super(b, m);
        batteryRate = 100;
    }

    void chargeBattery(){
        batteryRate = 100;
        System.out.println(brand + " " + model + " " + ": Battery is fully charge!");
    }

}

public class Inheritance {
    public static void main(String[] args) {
        ManualCar m = new ManualCar("Honda", "Honda City");
        m.start();
        m.gearShift(3);
        m.accelerate();
        m.breaks();
        m.stop();
        m.accelerate();

        System.out.println("......................................................................");

        ElectricCar e = new ElectricCar("Tesla", "tesla Model Y");
        e.chargeBattery();
        e.start();
        e.accelerate();
        e.breaks();
        e.stop();
    }
}
