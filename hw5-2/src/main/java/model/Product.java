package model;

public class Product{
    private String product_id;
    private String name;
    private String image;
    private String price;
    private int amount;

    public Product(String product_id, String name, String image, String price){
        this.product_id = product_id;
        this.image = image;
        this.name = name;
        this.price = price;
        amount = 0;
    }
    public void amountInc(){
        amount++;
    }
    public void amountDec(){
        amount--;
    }
    public void amountSet(int val){
        amount = val;
    }
    public String amountGet(){
        return String.valueOf(amount);
    }

    public String getPrice(){
        return price;
    }
    public String getProduct_id() {
        return product_id;
    }
    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}