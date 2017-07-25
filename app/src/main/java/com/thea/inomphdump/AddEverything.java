package com.thea.inomphdump;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


public class AddEverything {
    private DatabaseReference mDatabaseAdmin, mDatabaseCategory, mDatabaseCustomer, mDatabaseOrder, mDatabaseProduct, mDatabaseRating;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public static final String ADMIN_TABLE_NAME = "Admin";
    public static final String ADMIN_ID = "id";
    public static final String ADMIN_USERNAME = "username";
    public static final String ADMIN_PASSWORD = "password";
    public static final String ADMIN_TRANSLIST = "transactionlist_id";

    public static final String CATEGORY_TABLE_NAME = "Category";
    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "category_name";
    public static final String CATEGORY_PRODUCTSLIST = "productlist_id";

    public static final String CUSTOMER_TABLE_NAME = "Customer";
    public static final String CUSTOMER_ID = "customer_id";
    public static final String CUSTOMER_FNAME = "fname";
    public static final String CUSTOMER_MNAME = "mname";
    public static final String CUSTOMER_LNAME = "lname";
    public static final String CUSTOMER_EMAIL = "email";
    public static final String CUSTOMER_HOME_NUM = "home_num";
    public static final String CUSTOMER_HOME_STREET = "home_street";
    public static final String CUSTOMER_HOME_CITY = "home_city";
    public static final String CUSTOMER_HOME_POSTCODE = "home_postcode";
    public static final String CUSTOMER_ORDERLIST_ID = "orderlist_id";

    public static final String ORDER_TABLE_NAME = "Order";
    public static final String ORDER_ID = "order_id";
    public static final String ORDER_CUSTOMER_ID = "customer_id";
    public static final String ORDER_PRODUCT_ID = "product_id";
    public static final String ORDER_QTY = "quantity";

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

    public static final String RATING_TABLE_NAME = "Rating";
    public static final String RATING_ID = "rating_id";
    public static final String RATING_PRODUCT_ID = "product_id";
    public static final String RATING_CUSTOMER_ID = "customer_id";
    public static final String RATING_RATING = "rating";


    public void startAdding(){

        /*
        admin
        category
        customer
        product
        order
        rating
         */

        //Adding Admin info
        mDatabaseAdmin = database.getReference().child(ADMIN_TABLE_NAME);
        DatabaseReference newAdmin = mDatabaseAdmin.push();

        newAdmin.child(ADMIN_USERNAME).setValue("username");
        newAdmin.child(ADMIN_PASSWORD).setValue("password");

        //Adding Categry info
        mDatabaseCategory = database.getReference().child(CATEGORY_TABLE_NAME);
        DatabaseReference newCat = mDatabaseCategory.push();
        newCat.child(CATEGORY_NAME).setValue("category1");

        //Adding Customer
        mDatabaseCustomer = database.getReference().child(CUSTOMER_TABLE_NAME);
        DatabaseReference newCust = mDatabaseCustomer.push();
        newCust.child(CUSTOMER_FNAME).setValue("fname");
        newCust.child(CUSTOMER_MNAME).setValue("mname");
        newCust.child(CUSTOMER_LNAME).setValue("lname");
        newCust.child(CUSTOMER_EMAIL).setValue("email");
        newCust.child(CUSTOMER_HOME_NUM).setValue("home_num");
        newCust.child(CUSTOMER_HOME_STREET).setValue("home_street");
        newCust.child(CUSTOMER_HOME_CITY).setValue("city");
        newCust.child(CUSTOMER_HOME_POSTCODE).setValue("postcode");

        //Adding Product
        mDatabaseProduct = database.getReference().child(PRODUCT_TABLE_NAME);
        DatabaseReference newProd = mDatabaseProduct.push();
        newProd.child(PRODUCT_CATEGORY_ID).setValue(newCat.getKey().toString());
        newProd.child(PRODUCT_NAME).setValue("name");
        newProd.child(PRODUCT_VOLUME).setValue("volume");
        newProd.child(PRODUCT_PRICE).setValue("price");
        newProd.child(PRODUCT_QTY).setValue("qty");
        newProd.child(PRODUCT_BOTTLER).setValue("bottler");
        newProd.child(PRODUCT_AGE).setValue("age");
        newProd.child(PRODUCT_COUNTRY).setValue("country");
        newProd.child(PRODUCT_REGION).setValue("region");
        newProd.child(PRODUCT_ESSENCE).setValue("essence");
        newProd.child(PRODUCT_RICHNESS).setValue("richness");
        newProd.child(PRODUCT_SMOKE).setValue("smoke");
        newProd.child(PRODUCT_SWEETNESS).setValue("sweetness");
        newCat.child(CATEGORY_PRODUCTSLIST).child(newCat.getKey().toString()).setValue(newCat.getKey().toString());

        //Adding Order
        mDatabaseOrder = database.getReference().child(ORDER_TABLE_NAME);
        DatabaseReference newOrder = mDatabaseOrder.push();
        newOrder.child(ORDER_CUSTOMER_ID).setValue(newCust.getKey().toString());
        newOrder.child(ORDER_PRODUCT_ID).setValue(newProd.getKey().toString());
        newOrder.child(ORDER_QTY).setValue("100");
        newProd.child(PRODUCT_ORDERLIST_ID).child(newOrder.getKey().toString()).setValue(newOrder.getKey().toString());
        newCust.child(CUSTOMER_ORDERLIST_ID).child(newOrder.getKey().toString()).setValue(newOrder.getKey().toString());

        //Adding Rating
        mDatabaseRating = database.getReference().child(RATING_TABLE_NAME);
        DatabaseReference newRating = mDatabaseRating.push();
        newRating.child(RATING_RATING).setValue("sample");
        newRating.child(RATING_PRODUCT_ID).setValue(newProd.getKey().toString());
        newRating.child(RATING_CUSTOMER_ID).setValue(newCust.getKey().toString());
        newProd.child(PRODUCT_RATINGLIST_ID).child(newRating.getKey().toString()).setValue(newRating.getKey().toString());

        Log.i("done", "done");

    }
}
