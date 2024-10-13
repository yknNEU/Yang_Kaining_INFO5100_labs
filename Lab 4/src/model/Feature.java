package model;

public class Feature {

    private Product owner;
    private String name;
    private Object value;

    public Feature() {
        this.owner = new Product();
        this.name = "";
        this.value = null;
    }

    public Feature(Product owner) {
        this.owner = owner;
        this.name = "";
        this.value = null;
    }

    public Feature(Product owner, String name, Object value) {
        this.owner = owner;
        this.name = name;
        this.value = value;
    }

    public Product getOwner() {
        return owner;
    }

    public void setOwner(Product owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }
}


