package pl.al.zadanie21spring_produkty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ListOfProducts {

    @RequestMapping("/lista")
    @ResponseBody
    List newList(){
        List<Product> listProduct = new ArrayList<Product>();
        Product product1 = new Product("pralka", 2000, "Art. gosp. domowego");
        Product product2 = new Product("woda", 2, "Art. spożywcze");
        Product product3 = new Product("masło", 6, "Art. spożywcze");
        Product product4 = new Product("patelnia", 40, "Art. gosp. domowego");
        Product product5 = new Product("mleko", 4, "Art. spożywcze");
        Product product6 = new Product("czajnik", 2000, "Art. gosp. domowego");
        Product product7 = new Product("pies", 2000, "Inne");
        Product product8 = new Product("złota rybka", 2000, "Inne");
        listProduct.add(product1);
        listProduct.add(product2);
        listProduct.add(product3);
        listProduct.add(product4);
        listProduct.add(product5);
        listProduct.add(product6);
        listProduct.add(product7);
        listProduct.add(product8);
        return listProduct;
    }


    @GetMapping("/lista")
    @ResponseBody
    public String list(@RequestParam(value = "kategoria") String category) {

        List<Product> listProduct =  newList();

        List<Product> newProductList = new ArrayList<>();
        String result = "";
        int priceSum = 0;
        if (category.equals("spozywcze")) {
            for (int i = 0; i < listProduct.size(); i++) {
                if (listProduct.get(i).getCategory().equals("Art. spożywcze")) {
                    newProductList.add(listProduct.get(i));

                }

            }


        } else if (category.equals("gospodarstwa")) {
            for (int i = 0; i < listProduct.size(); i++) {
                if (listProduct.get(i).getCategory().equals("Art. gosp. domowego")) {
                    newProductList.add(listProduct.get(i));


                }

            }


        } else if (category.equals("inne")) {
            for (int i = 0; i < listProduct.size(); i++) {
                if (listProduct.get(i).getCategory().equals("Inne")) {
                    newProductList.add(listProduct.get(i));


                }

            }


        } else if (category.equals("wszystkie")) {
            for (int i = 0; i < listProduct.size(); i++) {
                newProductList.add(listProduct.get(i));
                priceSum += newProductList.get(i).getPrice();

            }


        }
        for (int i = 0; i < newProductList.size(); i++) {
            result += "Nazwa: " + newProductList.get(i).getName() + " cena: " + newProductList.get(i).getPrice() + " kategoria " + newProductList.get(i).getCategory() + "<br/>";

        }
        for (int i = 0; i < newProductList.size(); i++) {
            priceSum += newProductList.get(i).getPrice();

        }


        return result + "<br/>" + "Suma cen: " + priceSum;
    }


}