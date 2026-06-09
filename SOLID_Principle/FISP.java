package SOLID_Principle;

abstract class TwoD{
    abstract int area();
}

abstract class ThreeD{
    abstract int area();
    abstract void volume();
}

class Square extends TwoD{
    private int side;
    Square(int side){
       this.side = side;
    }

    int area(){
        return side * side;
    }
}

class Cube extends ThreeD{
    private int side;
    Cube(int side){
        this.side = side;
    }

    int area(){
        return 6 * side;
    }

    void volume(){
        System.out.println("volume of cube " + side * side * side);
    }
}

public class FISP {
    public static void main(String[] args) {
        Square sq = new Square(3);
        Cube cb = new Cube(2);

        System.out.println(sq.area());

        System.out.println(cb.area());
        cb.volume();


    }
}
