package model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Product {
    
    private String name;
    private int price;
    private int id;
    private ImageIcon logoImage;

    private ArrayList<Feature> features;

    private static int count = 0;
    
    public Product() {
        count++;
        id = count;
        name = "";
        price = 0;
        logoImage = null;

        features = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public Feature addNewFeature() {
        Feature feature = new Feature();
        features.add(feature);
        return feature;
    }

    public void removeFeature(Feature feature) {
        features.remove(feature);
    }

    public ImageIcon getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(ImageIcon logoImage) {
        this.logoImage = logoImage;
    }

    @Override
    public String toString() {
        return name;
    }
}
