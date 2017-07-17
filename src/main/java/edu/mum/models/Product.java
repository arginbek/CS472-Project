package edu.mum.models;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private String imgName;
    private static int idCounter;
    
    {
        idCounter = 1;
    }

    public Product(String name, String description, double price, String imgName) {
        this.id = Integer.valueOf(generateId()).toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgName = imgName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
    
    private static int generateId() {
        return idCounter++;
    }

}
