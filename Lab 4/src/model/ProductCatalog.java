package model;

import java.util.ArrayList;

public class ProductCatalog {
    
    private ArrayList<Product> productCatalog;
    
    public ProductCatalog() {
        productCatalog = new ArrayList<Product>();
    }

    public ArrayList<Product> getProductCatalog() {
        return productCatalog;
    }
    
    public Product addProduct() {
        Product p = new Product();
        productCatalog.add(p);
        return p;
    }
    
    public void removeProduct(Product p) {
        productCatalog.remove(p);
    }
    
    public Product searchProduct(int id) {
        for(Product p : productCatalog) {
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Product searchByName(String name) {
        for(Product p : productCatalog) {
            if(p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public Product searchByFeature(String name, Object value) {
        for(Product p : productCatalog) {
            for(Feature f : p.getFeatures()) {
                if (f.getName().equals(name) && f.getValue().equals(value)) {
                    return p;
                }
            }
        }
        return null;
    }
    
    public int getProductCount(){
        return productCatalog.size();
    }
}
