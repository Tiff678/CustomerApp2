package com.example.customerapp2;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart extends AppCompatActivity {
    int i1;
    int i2;
    String price1;
    String price2;
    String price3;
    double total = 0;
    int var = R.id.imageButton2;

    //EditText[] editTextsOrders;
    //int[] test1 = new int[]{1,2,3,4};
    int[] editTextOrders = new int[]{R.id.editTextOrder1, R.id.editTextOrder2, R.id.editTextOrder3, R.id.editTextOrder4, R.id.editTextOrder5};
    ArrayList<String> menuSelected = new ArrayList<>();
    ArrayList<String> pricesSelected = new ArrayList<>();
    //int editTextOrderInputted;
    //int counterOrders = 0;
    HashMap<String, String> menuPrice = new HashMap<String, String>() {{
        put("Chicken Chop", "4");
        put("Fries", "1.50");
        put("Nuggets", "2");
    }};
    HashMap<String, List<Integer>> widgets = new HashMap<String, List<Integer>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent mainToCart = getIntent();
        if (mainToCart.getStringExtra(MainActivity.ORDER1) != null) {
            Log.i("Tiff", "working");
            menuSelected.add(mainToCart.getStringExtra(MainActivity.ORDER1));
        }

        if (mainToCart.getStringExtra(MainActivity.ORDER2) != null) {
            Log.i("Tiff", "working yay");
            menuSelected.add(mainToCart.getStringExtra(MainActivity.ORDER2));
        }

        if (mainToCart.getStringExtra(MainActivity.ORDER3) != null) {
            Log.i("Tiff", "working yay yay");
            menuSelected.add(mainToCart.getStringExtra(MainActivity.ORDER3));
        }

        for (String menu: menuSelected){
            String price = menuPrice.get(menu);
            pricesSelected.add(price);
            Log.i("Tiff", "" + pricesSelected);
        }
        /*
        menuSelected.add(mainToCart.getStringExtra(MainActivity.ORDER1));
        menuSelected.add(mainToCart.getStringExtra(MainActivity.ORDER2));
        menuSelected.add(mainToCart.getStringExtra(MainActivity.ORDER3));

         */
        //EditText test = findViewById(R.id.editTextOrder1);
        //test.setText(menuSelected.get(0));

/*
//Option1
        editTextsOrders = new EditText[6];

        for(int i=0; i<editTextsOrders.length; i++) {

                String editTextsOrderID = "editTextsOrder" + (i + 1);

                int resID = getResources().getIdentifier(editTextsOrderID, "id", getPackageName());
                editTextsOrders[i] = ((EditText) findViewById(resID));
            }

        int index = 0;
        for (int i = 0; i < editTextsOrders.length; i++) {
            Log.i("Tiff", "looping works");
            //String text = editTextsOrders[i].getText().toString();
            if (editTextsOrders[i].getId() == R.id.editTextOrder5)
            {
                index = i;
                Log.i("Tiff", ""+ i);
                break;
            }


        }


 */
        for (int i = 0; i < menuSelected.size(); i++) {
            for (int order : editTextOrders) {
                Log.i("Tiff", Integer.toString(order));
                EditText orderWidget = findViewById(order);
                if (TextUtils.isEmpty(orderWidget.getText().toString())) {
                    orderWidget.setText(menuSelected.get(i));
                    //editTextOrderInputted = order;
                    //counterOrders += 1;
                    //Log.i("Tiff", "" + counterOrders);
                    break;
                }
            }
        }

        Integer[] widgetsExceptOrder1 = new Integer[]{R.id.Price1, R.id.imageButton2, R.id.quantityTextView1, R.id.imageButton3};
        widgets.put("" + 1, Arrays.asList(widgetsExceptOrder1));
        List a = widgets.get("1");
        Log.i("Tiff", "" + a);
        Log.i("Tiff", "" + a.get(0));
        Integer[] widgetsExceptOrder2 = new Integer[]{R.id.Price2, R.id.imageButton4, R.id.quantityTextView2, R.id.imageButton5};
        widgets.put("" + 2, Arrays.asList(widgetsExceptOrder2));
        List b = widgets.get("2");
        Log.i("Tiff", "" + b);
        Log.i("Tiff", "" + b.get(0));



/*
        for(int i = 1; i < menuSelected.size(); i++){
            for(int j : editTextOrders){

            }

        }

/*
        for (String menu : menuSelected) {
            if (!menu.equals("")) {
                Log.i("Tiff", "notempty");

                for (int order : editTextOrders) {
                    Log.i("Tiff", Integer.toString(order));
                    EditText orderWidget = findViewById(order);
                    if (orderWidget.getText().toString().equals("")) {
                        orderWidget.setText(menu);
                        break;
                    }


                }

            }
        }

 */
/*
        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        TextView textView1 = findViewById(R.id.quantityTextView1);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tiff", "Button Clicked");
                i1+=1;
                Log.i("Tiff", "" +i1);
                textView1.setText("" + i1);
                double individualPrice = CalculatePrice.calculatePrice(price1,""+ i1);
                EditText Price1 = findViewById(R.id.Price1);
                Price1.setText(Double.toString(individualPrice));
                total += new Double(price1);
                TextView totalTextView = findViewById(R.id.totalTextView);
                totalTextView.setText(Double.toString(total));



            }
        });

        ImageButton imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tiff", "Button Clicked");
                if(i1>0){i1 -=1;}
                Log.i("Tiff", "" +i1);
                textView1.setText("" + i1);

                double individualPrice = CalculatePrice.calculatePrice(price1,""+ i1);
                EditText Price1 = findViewById(R.id.Price1);
                Price1.setText(Double.toString(individualPrice));
                total -= new Double(price1);
                TextView totalTextView = findViewById(R.id.totalTextView);
                totalTextView.setText(Double.toString(total));


            }
        });

 */
        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        final TextView textView1 = findViewById(R.id.quantityTextView1);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tiff", "Button Clicked");
                i1 += 1;
                Log.i("Tiff", "" + i1);
                textView1.setText("" + i1);

                EditText editTextOrder1 = findViewById(R.id.editTextOrder1);
                String input = editTextOrder1.getText().toString();
                Log.i("Tiff", ""+ input);
                String price = menuPrice.get(input);
                Log.i("Tiff", "Here"+ price);

                double individualPrice = CalculatePrice.calculatePrice(price, "" + i1);
                EditText Price1 = findViewById(R.id.Price1);
                Price1.setText(Double.toString(individualPrice));

                total += new Double(price);
                TextView totalTextView = findViewById(R.id.totalTextView);
                totalTextView.setText(Double.toString(total));


            }
        });


        ImageButton imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tiff", "Button Clicked");
                if (i1 > 0) {
                    i1 -= 1;
                }
                Log.i("Tiff", "" + i1);
                textView1.setText("" + i1);

                EditText editTextOrder1 = findViewById(R.id.editTextOrder1);
                String input = editTextOrder1.getText().toString();
                Log.i("Tiff", ""+ input);
                String price = menuPrice.get(input);
                Log.i("Tiff", "Here"+ price);

                double individualPrice = CalculatePrice.calculatePrice(price, "" + i1);
                EditText Price1 = findViewById(R.id.Price1);
                Price1.setText(Double.toString(individualPrice));

                total -= new Double(price);
                TextView totalTextView = findViewById(R.id.totalTextView);
                totalTextView.setText(Double.toString(total));

            }
        });




        ImageButton imageButton4 = findViewById(R.id.imageButton4);
        final TextView textView2 = findViewById(R.id.quantityTextView2);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tiff", "Button Clicked");
                i2 += 1;
                Log.i("Tiff", "" + i2);
                textView2.setText("" + i2);

                EditText editTextOrder2 = findViewById(R.id.editTextOrder2);
                String input = editTextOrder2.getText().toString();
                Log.i("Tiff", ""+ input);
                String price = menuPrice.get(input);
                Log.i("Tiff", "Here"+ price);

                double individualPrice = CalculatePrice.calculatePrice(price, "" + i2);
                EditText Price2 = findViewById(R.id.Price2);
                Price2.setText(Double.toString(individualPrice));

                total += new Double(price);
                TextView totalTextView = findViewById(R.id.totalTextView);
                totalTextView.setText(Double.toString(total));
/*
                double individualPrice = CalculatePrice.calculatePrice(price2, "" + i2);
                EditText Price2 = findViewById(R.id.Price2);
                total += new Double(price2);
                Price2.setText(Double.toString(individualPrice));
                TextView totalTextView = findViewById(R.id.totalTextView);
                totalTextView.setText(Double.toString(total));


 */

            }
        });

        ImageButton imageButton5 = findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tiff", "Button Clicked");
                if (i2 > 0) {
                    i2 -= 1;
                }
                Log.i("Tiff", "" + i2);
                textView2.setText("" + i2);

                EditText editTextOrder2 = findViewById(R.id.editTextOrder2);
                String input = editTextOrder2.getText().toString();
                Log.i("Tiff", ""+ input);
                String price = menuPrice.get(input);
                Log.i("Tiff", "Here"+ price);

                double individualPrice = CalculatePrice.calculatePrice(price, "" + i2);
                EditText Price2 = findViewById(R.id.Price2);
                Price2.setText(Double.toString(individualPrice));

                total -= new Double(price);
                TextView totalTextView = findViewById(R.id.totalTextView);
                totalTextView.setText(Double.toString(total));


/*
                double individualPrice = CalculatePrice.calculatePrice(price2, "" + i2);
                EditText Price2 = findViewById(R.id.Price2);
                total -= new Double(price2);
                Price2.setText(Double.toString(individualPrice));
                TextView totalTextView = findViewById(R.id.totalTextView);
                totalTextView.setText(Double.toString(total));

 */

            }
        });
/*
        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        final TextView textView1 = findViewById(R.id.quantityTextView1);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tiff", "Button Clicked");
                i1 += 1;
                Log.i("Tiff", "" + i1);
                textView1.setText("" + i1);

                EditText editTextOrder1 = findViewById(R.id.editTextOrder1);
                String input = editTextOrder1.getText().toString();
                Log.i("Tiff", ""+ input);
                String price = menuPrice.get(input);
                Log.i("Tiff", "Here"+ price);

                double individualPrice = CalculatePrice.calculatePrice(price, "" + i1);
                EditText Price1 = findViewById(R.id.Price1);
                Price1.setText(Double.toString(individualPrice));

                total += new Double(price);
                TextView totalTextView = findViewById(R.id.totalTextView);
                totalTextView.setText(Double.toString(total));


            }
        });


        ImageButton imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tiff", "Button Clicked");
                if (i1 > 0) {
                    i1 -= 1;
                }
                Log.i("Tiff", "" + i1);
                textView1.setText("" + i1);

                EditText editTextOrder1 = findViewById(R.id.editTextOrder1);
                String input = editTextOrder1.getText().toString();
                Log.i("Tiff", ""+ input);
                String price = menuPrice.get(input);
                Log.i("Tiff", "Here"+ price);

                double individualPrice = CalculatePrice.calculatePrice(price, "" + i1);
                EditText Price1 = findViewById(R.id.Price1);
                Price1.setText(Double.toString(individualPrice));

                total -= new Double(price);
                TextView totalTextView = findViewById(R.id.totalTextView);
                totalTextView.setText(Double.toString(total));

            }
        });

 */
/*
  <EditText
        android:id="@+id/Price3"
        android:hint="Price3"
        android:paddingTop="300px"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:gravity="center"/>

    <EditText
        android:id="@+id/Price4"
        android:hint="Price4"
        android:paddingTop="400px"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:gravity="center"/>

    <EditText
        android:id="@+id/Price5"
        android:hint="Price5"
        android:paddingTop="550px"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:gravity="center"/>

 */



    }
}
