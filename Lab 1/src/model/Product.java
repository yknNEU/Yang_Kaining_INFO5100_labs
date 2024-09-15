package model;

public class Product {
    public String name;
    public String description;
    public String availability;
    public String price;

    public Product(String name, String description, String availability, String price) {
        this.name = name;
        this.description = description;
        this.availability = availability;
        this.price = price;
    }

    public Product() {
        this.name = "";
        this.description = "";
        this.availability = "";
        this.price = "";
    }
}
