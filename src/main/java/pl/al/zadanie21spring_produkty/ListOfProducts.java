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


    @GetMapping("/lista")
    @ResponseBody
    public String list(@RequestParam(value = "kategoria") String category) {
        ProductList productList = new ProductList();
        productList.addStatic();
        List<Product> listProduct = productList.getAll();


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

    @RequestMapping("/add")
    @ResponseBody
    public String addProd(@RequestParam String nazwa, @RequestParam String cena, @RequestParam String kategoria) {

        Product product = new Product(nazwa, Integer.valueOf(cena), kategoria);
        ProductList productList = new ProductList();
        productList.addProduct(product);
        return "Dodano produkt: " + product.getName();
    }

}