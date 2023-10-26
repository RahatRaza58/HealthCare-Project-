package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private  String[][] doctor_details1=
            {
                    {"Doctor Name:Dr.Sajib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:Dr.Kamrul", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:Dr.Nadim ", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Hasan", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rahi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Mahbub", "Hospital Address: Sylhet","Exp:5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rafid", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Habib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:Dr.Rafi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:Dr.Nayeem", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Hasan", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rahi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Mahbub", "Hospital Address: Sylhet","Exp:5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rafid", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Habib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:Dr.Rafi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},

            };
    private  String[][] doctor_details2=
            {
                    {"Doctor Name:- Dr. Mahmudur Rahman", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:- Dr. Habibur Ahmed", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:- Dr. Tarekul Wahid", "Hospital Address: Sylhet","Exp:5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:- Dr. Emdadur Rahim", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:- Dr. Jaminur Islam", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Hasan", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rahi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Mahbub", "Hospital Address: Sylhet","Exp:5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rafid", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Habib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Hasan", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rahman", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Miah", "Hospital Address: Sylhet","Exp:5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Riad", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Habib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},


            };
    private  String[][] doctor_details3=
            {
                    {"Doctor Name: Hasan", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rahi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Hasan", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rahi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Mahbub", "Hospital Address: Sylhet","Exp:5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rafid", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Habib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Mahbub", "Hospital Address: Sylhet","Exp:5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rafid", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Habib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},

            };
    private  String[][] doctor_details4=
            {
                    {"Doctor Name:Dr.Sajib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:Dr.Kamrul", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:Dr.Nadim ", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Hasan", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rahi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Mahbub", "Hospital Address: Sylhet","Exp:5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rafid", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Habib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:Dr.Rafi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:Dr.Nayeem", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},

            };

    private  String[][] doctor_details5=
            {
                    {"Doctor Name: Sajib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Kamrul", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Nadim ", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rafi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Hasan", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rahi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Mahbub", "Hospital Address: Sylhet","Exp:5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rafid", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Hasan", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rahi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Mahbub", "Hospital Address: Sylhet","Exp:5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Rafid", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Habib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name:Dr.Rafi", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Habib", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},
                    {"Doctor Name: Nayeem", "Hospital Address: Sylhet","Exp: 5years", "Mobile No:017701236877", "700"},

            };
    TextView tv;
    Button btn;
    String[][] doctor_details={};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv= findViewById(R.id.textViewLDTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it =getIntent();
        String title= it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Cardiologists")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list =new ArrayList();
        for (int i=0;i<doctor_details.length;i++) {
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "\nVisiting Fee:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa =new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );

        ListView lst =findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it =new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);

                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

        }
    }
