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

class ShoppingCardStorage{
    private ShopingCard card;

    ShoppingCardStorage(ShopingCard card){
           this.card = card;
    }

    void saveToSQLdatabase(){
        System.out.println("Saving Shopping Card to SQL database.");
    }

    void saveToMongodatabase(){
        System.out.println("Saving Shopping Card to Mongo database.");
    }

    void saveToPostgresdatabase(){
        System.out.println("Saving Shopping Card to Postgres database.");
    }

    void saveToFile(){
        System.out.println("Saving Shopping Card to File database.");
    }
}


public class NFOCP {
    public static void main(String[] args) {
        ShopingCard scard = new ShopingCard();
        ShoppingCardPrinter printer = new ShoppingCardPrinter(scard);
        ShoppingCardStorage db = new ShoppingCardStorage(scard);

        scard.addProduct(new Product("Laptop", 75000));
        scard.addProduct(new Product("Mouse", 180));

        System.out.println(scard.getProduct());

        printer.priceInvoice();
        db.saveToPostgresdatabase();
    }
}
