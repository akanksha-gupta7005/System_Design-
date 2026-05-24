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

    void priceInvoice(){
        System.out.println("Shopping Card Invoice!");
        for(Product p : list){
            System.out.println(p.name + " " + "-$" + p.price);
        }
        System.out.println("Total -$: " + calculateTotal());
    }

    void saveTodatabase(){
        System.out.println("Saving Shopping Card to database.");
    }
}

public class NFSRP {
    public static void main(String[] args) {
        ShopingCard sp = new ShopingCard();

        sp.addProduct(new Product("Sampoo", 99));
        sp.addProduct(new Product("Conditioner", 150));
        sp.addProduct(new Product("Loofa", 79));
        sp.addProduct(new Product("BodyLotion", 280));

        System.out.println(sp.getProduct());
        sp.priceInvoice();

        sp.saveTodatabase();
    }
    
}
