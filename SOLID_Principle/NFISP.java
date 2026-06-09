package SOLID_Principle;

abstract class Shape{
    abstract int area();
    abstract void volume() throws Exception;

}

class Square extends Shape{
    private int side;

    Square(int side){
         this.side = side;
    }

    int area(){
        System.out.println("Square");
        return side * side;
    }

    void volume() throws Exception{
        throw new Exception("2D has no volume");
    }
}

class Cube extends Shape{
    private int side;

    Cube(int side){
        this.side = side;
    }
    int area(){
        System.out.println("Cube");
        return  6 * side ;
    }

    void volume(){
        System.out.println("volume of cube" + " " + side * side * side);
    }
}

public class NFISP{
    public static void main(String[] args) throws Exception {
        Square sq = new Square(7);
        Cube cb = new Cube(4);

        System.out.println(sq.area());

        System.out.println(cb.area());
        cb.volume();

        try{
            sq.volume();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}