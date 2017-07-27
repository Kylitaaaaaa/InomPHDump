package com.thea.inomphdump;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Thea on 27/07/2017.
 */

public class GetEverything {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public void getProductList(){

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataSnapshot trysnap = dataSnapshot.child(AddEverything.PRODUCT_TABLE_NAME);
                Iterable<DataSnapshot> tryChildren = trysnap.getChildren();
                Log.i("huh", "HERE");

                //getting product ID
                for (DataSnapshot ty : tryChildren) {
                    String id = ty.getKey().toString();
                    Log.i("huh", "id: " + id);

                    //getting product details
                    mDatabase.child(AddEverything.PRODUCT_TABLE_NAME).child(id).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot2) {
                            String name = (String) dataSnapshot2.child(AddEverything.PRODUCT_NAME).getValue();
                            String pic = (String) dataSnapshot2.child(AddEverything.PRODUCT_PIC).getValue();
                            Log.i("huh", "name:  " + name);
                            Log.i("huh", "pic:  " + pic);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError2) {

                        }
                    });

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void searchProduct(final String prod){

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataSnapshot trysnap = dataSnapshot.child(AddEverything.PRODUCT_TABLE_NAME);
                Iterable<DataSnapshot> tryChildren = trysnap.getChildren();
                Log.i("huh", "HERE");

                //getting product ID
                for (DataSnapshot ty : tryChildren) {
                    String id = ty.getKey().toString();
                    Log.i("huh", "id: " + id);

                    //getting product details


                    mDatabase.child(AddEverything.PRODUCT_TABLE_NAME).child(id).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot2) {
                            String name = (String) dataSnapshot2.child(AddEverything.PRODUCT_NAME).getValue();
                            if(name.equals(prod)) {
                                Log.i("huh", "found it name:  " + name);
                                //do something
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError2) {

                        }
                    });

                }

                //ASDF
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
