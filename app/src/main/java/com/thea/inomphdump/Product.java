package com.thea.inomphdump;

/**
 * Created by Thea on 26/07/2017.
 */

public class Product {

    public static final String PRODUCT_TABLE_NAME = "Product";
    public static final String PRODUCT_ID = "product_id";
    public static final String PRODUCT_CATEGORY_ID = "category_id";
    public static final String PRODUCT_NAME = "name";
    public static final String PRODUCT_VOLUME = "volume";
    public static final String PRODUCT_PRICE = "price";
    public static final String PRODUCT_QTY = "quantity";
    public static final String PRODUCT_BOTTLER = "bottler";
    public static final String PRODUCT_AGE = "age";
    public static final String PRODUCT_COUNTRY = "country";
    public static final String PRODUCT_REGION = "region";
    public static final String PRODUCT_ESSENCE = "essence";
    public static final String PRODUCT_RICHNESS = "richness";
    public static final String PRODUCT_SMOKE = "smoke";
    public static final String PRODUCT_SWEETNESS = "sweetness";
    public static final String PRODUCT_ORDERLIST_ID = "orderlist_id";
    public static final String PRODUCT_RATINGLIST_ID = "ratinglist_id";

    private String age;
    private String bottler;
    private String category_id;
    private String country;
    private String essence;
    private String name;
    private String orderlist_id;
    private String price;
    private String ratinglist_id;
    private String region;
    private String richness;
    private String smoke;
    private String sweetness;
    private String volume;
    private String quantity;

    public Product() {
    }

    public Product(String age, String bottler, String category_id, String country, String essence, String name, String orderlist_id, String price, String ratinglist_id, String region, String richness, String smoke, String sweetness, String volume, String quantity) {
        this.age = age;
        this.bottler = bottler;
        this.category_id = category_id;
        this.country = country;
        this.essence = essence;
        this.name = name;
        this.orderlist_id = orderlist_id;
        this.price = price;
        this.ratinglist_id = ratinglist_id;
        this.region = region;
        this.richness = richness;
        this.smoke = smoke;
        this.sweetness = sweetness;
        this.volume = volume;
        this.quantity = quantity;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBottler() {
        return bottler;
    }

    public void setBottler(String bottler) {
        this.bottler = bottler;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEssence() {
        return essence;
    }

    public void setEssence(String essence) {
        this.essence = essence;
    }

    public String getRichness() {
        return richness;
    }

    public void setRichness(String richness) {
        this.richness = richness;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getSweetness() {
        return sweetness;
    }

    public void setSweetness(String sweetness) {
        this.sweetness = sweetness;
    }

    public String getOrderlist_id() {
        return orderlist_id;
    }

    public void setOrderlist_id(String orderlist_id) {
        this.orderlist_id = orderlist_id;
    }

    public String getRatinglist_id() {
        return ratinglist_id;
    }

    public void setRatinglist_id(String ratinglist_id) {
        this.ratinglist_id = ratinglist_id;
    }
}
