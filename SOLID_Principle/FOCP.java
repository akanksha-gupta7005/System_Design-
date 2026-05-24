package SOLID_Principle;

import java.util.ArrayList;
import java.util.List;

class Product{
    String name;
    double price;

    Product(String n, double p){
        name = n;
        price = p;
    }
}

class ShopingCard{
    private  List<Product> list = new ArrayList<>(); 

    void addProduct(Product p){
        list.add(p);
    }

    List<Product> getProduct(){
        return list;
    }

    double calculateTotal(){
        double total = 0;
        for(Product p : list){
            total += p.price;
        }
        return total;
    }

}

class ShoppingCardPrinter{
    private ShopingCard card;

    ShoppingCardPrinter(ShopingCard card){
           this.card = card;
    }

     void priceInvoice(){
        System.out.println("Shopping Card Invoice!");
        for(Product p : card.getProduct()){
            System.out.println(p.name + " " + "-$" + p.price);
        }
        System.out.println("Total -$: " + card.calculateTotal());
    }
}

abstract class Persistent{
    private ShopingCard card;

    Persistent(ShopingCard card){
        this.card = card;
    }

    abstract void save(ShopingCard card);
}

class SQLPersistent extends Persistent{
    
    SQLPersistent(ShopingCard card) {
        super(card);
    }

    public void save(ShopingCard card){
        System.out.println("Saving Shopping card to SQL db...");
    }
}

class MongoPersistent extends Persistent{
    
    MongoPersistent(ShopingCard card) {
        super(card);
    }

    public void save(ShopingCard card){
        System.out.println("Saving Shopping card to SQL db...");
    }
}

class PostgresPersistent extends Persistent{
    
    PostgresPersistent(ShopingCard card) {
        super(card);
    }

    public void save(ShopingCard card){
        System.out.println("Saving Shopping card to SQL db...");
    }
}

class FilePersistent extends Persistent{
    
    FilePersistent(ShopingCard card) {
        super(card);
    }

    public void save(ShopingCard card){
        System.out.println("Saving Shopping card to SQL db...");
    }
}



public class FOCP {
    public static void main(String[] args) {
        ShopingCard sc = new ShopingCard();
        ShoppingCardPrinter printer = new ShoppingCardPrinter(sc);
        SQLPersistent sdb = new SQLPersistent(sc);
        MongoPersistent mdb = new MongoPersistent(sc);
        PostgresPersistent pdb = new PostgresPersistent(sc);
        FilePersistent fdb = new FilePersistent(sc);

        sc.addProduct(new Product("Laptop", 75000));
        sc.addProduct(new Product("Mouse", 180));

        System.out.println("Product List : " + sc.getProduct());

        printer.priceInvoice();

        sdb.save(sc);
        mdb.save(sc);
        fdb.save(sc);
        pdb.save(sc);
    }
    
}
