package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private  String[][] packages={
            {"Parasitamol 250GM", "", "", "", "125"},
            {"Diplo 250GM", "", "", "", "150"},
            {"Castro 250GM", "", "", "", "175"},
            {"Histation 250GM", "", "", "", "225"},
            {"Lapicy 250GM", "", "", "", "405"},
            {"Diplo plus 250GM", "", "", "", "335"},
            {"Vantic 250GM", "", "", "", "325"},
            {"Easiuk 250GM", "", "", "", "256"},
            {"Flowey 250GM", "", "", "", "563"},
    };
    private String[] package_details= {
            "Blood Gulcose Test\n" +
                    " Blood Test\n" +
                    "Blood Test\n" +
                    " Blood Test\n" +
                    "Blood Test",
            "Blood Urin Test",
            "Blood  SSSSSSSSSSSSSSS Test",
            "Blood  xxxxxxxxxxxxxxx Test",
            "Complete Check Up\n" +
                    "Blood Gulcose Test\n" +
                    " Blood Test\n" +
                    "Blood Test\n" +
                    "Blood Test\n" +
                    "Blood Test",
            "Blood Urin Test",
            "Blood  SSSSSSSSSSSSSSS Test",
            "Blood  xxxxxxxxxxxxxxx Test",
            "Blood  SSSSSSSSSSSSSSS Test"


    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst =findViewById(R.id.listViewBM);
        btnBack=findViewById(R.id.buttonBMBack);
        btnGoToCart=findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicine.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        list =new ArrayList();
        for (int i=0;i<packages.length;i++) {
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "\nTotal Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa =new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it =new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);

            }
        });


    }
}