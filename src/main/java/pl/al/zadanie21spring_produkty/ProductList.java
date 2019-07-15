package pl.al.zadanie21spring_produkty;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
 public    List<Product> listProduct = new ArrayList<Product>();
    Product product1 = new Product("pralka", 2000, "Art. gosp. domowego");
    Product product2 = new Product("woda", 2, "Art. spożywcze");
    Product product3 = new Product("masło", 6, "Art. spożywcze");
    Product product4 = new Product("patelnia", 40, "Art. gosp. domowego");
    Product product5 = new Product("mleko", 4, "Art. spożywcze");
    Product product6 = new Product("czajnik", 2000, "Art. gosp. domowego");
    Product product7 = new Product("pies", 2000, "Inne");
    Product product8 = new Product("złota rybka", 2000, "Inne");
    public void addStatic(){
        listProduct.add(product1);
        listProduct.add(product2);
        listProduct.add(product3);
        listProduct.add(product4);
        listProduct.add(product5);
        listProduct.add(product6);
        listProduct.add(product7);
        listProduct.add(product8);
    }
    List<Product> getAll(){
        return listProduct;
    }
void addProduct(Product product){
      listProduct.add(product);
}
}
