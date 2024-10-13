package model;

import javax.swing.ImageIcon;

public class Supplier {
    
    private String supplyName;
    private String description;
    private ProductCatalog productCatalog;
    private ImageIcon logoImage;

    public Supplier() {
        supplyName = "";
        description = "";
        productCatalog = new ProductCatalog();
        logoImage = null;
    }

    public Supplier(String supplyName, String description, ImageIcon logoImage) {
        this.supplyName = supplyName;
        this.description = description;
        this.logoImage = logoImage;
        productCatalog = new ProductCatalog();
    }

    public Supplier(String supplyName) {
        this.supplyName = supplyName;
        this.description = "";
        productCatalog = new ProductCatalog();
        logoImage = null;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }
    
    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public String toString() {
        return supplyName;
    }
}
