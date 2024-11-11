package model;

public class OrderItem {
    
    private Product product;
    private int quantity;
    private double salesPrice;

    public OrderItem(Product product, int quantity, double salesPrice) {
        this.product = product;
        this.quantity = quantity;
        this.salesPrice = salesPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    @Override
    public String toString() {
        return this.product.toString();
    }
}
