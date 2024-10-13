package model;

import javax.swing.ImageIcon;

public class Supplier {
    
    private String supplyName;
    private ProductCatalog productCatalog;
    private ImageIcon logoImage;

    public Supplier() {
        productCatalog = new ProductCatalog();
    }

    public Supplier(String supplyName, ImageIcon logoImage) {
        this.supplyName = supplyName;
        this.logoImage = logoImage;
        productCatalog = new ProductCatalog();
    }

    public Supplier(String supplyName) {
        this.supplyName = supplyName;
        productCatalog = new ProductCatalog();
    }

    public ImageIcon getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(ImageIcon logoImage) {
        this.logoImage = logoImage;
    }
    
    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }
    
    @Override
    public String toString() {
        return supplyName;
    }
}
