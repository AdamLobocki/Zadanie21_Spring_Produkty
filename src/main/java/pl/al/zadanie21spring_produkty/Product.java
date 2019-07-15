package pl.al.zadanie21spring_produkty;

public class Product {
    private String name;
    private int price;
    private String category;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
