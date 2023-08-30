package com.shazdevelops.texfactoryad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.Calendar;

public class UpdateWorkerStatus extends AppCompatActivity {

    String[] item={"1st Hour","2nd Hour","3rd Hour","4th Hour","5th Hour","6th Hour","7th Hour","8th Hour"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapter;
    EditText reason;
    Button active,inactive;
    FirebaseFirestore db;
    String w;
    String dock;
    String n;
    EditText nam2;
    String defect;
    EditText work2;
    String wk;
    String d;
    Button save;
    String kw5;
    ImageView inc,dec;
    TextView tdef;
    int deft;
    int d1,d2,d3,d4,d5,d6,d7,d8;
    FirebaseDatabase db1;
    DatabaseReference reference;
    String wDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_worker_status);
        w=getIntent().getStringExtra("wkey");
        autoCompleteTextView = findViewById(R.id.auto);
        adapter = new ArrayAdapter<String>(this,R.layout.list_defect,item);
        nam2=findViewById(R.id.nam2);
        kw5=getIntent().getStringExtra("kw5");
        save=findViewById(R.id.save);
        defect=getIntent().getStringExtra("defect");
        tdef=findViewById(R.id.tdef);
        inc=findViewById(R.id.inc);
        dec=findViewById(R.id.dec);
        wDate=getIntent().getStringExtra("wDate");
//        textView=findViewById(R.id.textView5);
//        textView.setText(wDate);
       // deft=getIntent().getIntExtra("dt",0);
        //tdef.setText(String.valueOf(deft));

        d1=getIntent().getIntExtra("d1",0);
        d2=getIntent().getIntExtra("d2",0);
        d3=getIntent().getIntExtra("d3",0);
        d4=getIntent().getIntExtra("d4",0);
        d5=getIntent().getIntExtra("d5",0);
        d6=getIntent().getIntExtra("d6",0);
        d7=getIntent().getIntExtra("d7",0);
        d8=getIntent().getIntExtra("d8",0);

        db=FirebaseFirestore.getInstance();
        wk=getIntent().getStringExtra("worka");
        work2=findViewById(R.id.work2);
        work2.setText(wk);
        reason = findViewById(R.id.reason);
        reason.setText(defect);
        n=getIntent().getStringExtra("n");
        active=findViewById(R.id.active);
        nam2.setText(n);
        inactive=findViewById(R.id.inactive);
        dock=getIntent().getStringExtra("ke");

        db1=FirebaseDatabase.getInstance();
        reference = db1.getReference("Workers");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Note: month is 0-indexed
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String currentDate =String.valueOf(day)+String.valueOf(month)+String.valueOf(year);

        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                d =parent.getItemAtPosition(position).toString();
                if (d.equals("1st Hour")){
                    tdef.setText(String.valueOf(d1));
                }
                if (d.equals("2nd Hour")){
                    tdef.setText(String.valueOf(d2));
                }
                if (d.equals("3rd Hour")){
                    tdef.setText(String.valueOf(d3));
                }
                if (d.equals("4th Hour")){
                    tdef.setText(String.valueOf(d4));
                }
                if (d.equals("5th Hour")){
                    tdef.setText(String.valueOf(d5));
                }
                if (d.equals("6th Hour")){
                    tdef.setText(String.valueOf(d6));
                }
                if (d.equals("7th Hour")){
                    tdef.setText(String.valueOf(d7));
                }
                if (d.equals("8th Hour")){
                    tdef.setText(String.valueOf(d8));
                }
               // Toast.makeText(UpdateWorkerStatus.this, ""+d, Toast.LENGTH_SHORT).show();

            }
        });

        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentValue=tdef.getText().toString();
                int value=Integer.parseInt(currentValue);
                value=value+1;
                tdef.setText(String.valueOf(value));
                if (d.equals("1st Hour")){
                    db.collection("Date").document(kw5).
                    collection("Table").document(dock).collection("Workers information").document(w).update("def1",value);
                    reference.child(n).child(wDate).child("def1").setValue(value);
                    d1=value;
                }
                if (d.equals("2nd Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def2",value);
                    reference.child(n).child(wDate).child("def2").setValue(value);
                    d2=value;
                }
                if (d.equals("3rd Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def3",value);
                    reference.child(n).child(wDate).child("def3").setValue(value);
                    d3=value;
                }
                if (d.equals("4th Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def4",value);
                    reference.child(n).child(wDate).child("def4").setValue(value);
                    d4=value;
                }
                if (d.equals("5th Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def5",value);
                    reference.child(n).child(wDate).child("def5").setValue(value);
                    d5=value;
                }
                if (d.equals("6th Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def6",value);
                    reference.child(n).child(wDate).child("def6").setValue(value);
                    d6=value;
                }
                if (d.equals("7th Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def7",value);
                    reference.child(n).child(wDate).child("def7").setValue(value);
                    d7=value;
                }
                if (d.equals("8th Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def8",value);
                    reference.child(n).child(wDate).child("def8").setValue(value);
                    d8=value;

                }
                //db.collection("Date").document(kw5).
                      //  collection("Table").document(dock).collection("Workers information").document(w).update("def",value);

            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentValue=tdef.getText().toString();
                int value=Integer.parseInt(currentValue);
                value=value-1;
                tdef.setText(String.valueOf(value));
                if (d.equals("1st Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def1",value);
                    reference.child(n).child(wDate).child("def1").setValue(value);
                    d1=value;
                }
                if (d.equals("2nd Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def2",value);
                    reference.child(n).child(wDate).child("def2").setValue(value);
                    d2=value;
                }
                if (d.equals("3rd Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def3",value);
                    reference.child(n).child(wDate).child("def3").setValue(value);
                    d3=value;
                }
                if (d.equals("4th Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def4",value);
                    reference.child(n).child(wDate).child("def4").setValue(value);
                    d4=value;
                }
                if (d.equals("5th Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def5",value);
                    reference.child(n).child(wDate).child("def5").setValue(value);
                    d5=value;
                }
                if (d.equals("6th Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def6",value);
                    reference.child(n).child(wDate).child("def6").setValue(value);
                    d6=value;
                }
                if (d.equals("7th Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def7",value);
                    reference.child(n).child(wDate).child("def7").setValue(value);
                    d7=value;
                }
                if (d.equals("8th Hour")){
                    db.collection("Date").document(kw5).
                            collection("Table").document(dock).collection("Workers information").document(w).update("def8",value);
                    reference.child(n).child(wDate).child("def8").setValue(value);
                    d8=value;
                }
               // db.collection("Date").document(kw5).
                     //   collection("Table").document(dock).collection("Workers information").document(w).update("def",value);


            }
        });

        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("Date").document(kw5).
                        collection("Table").document(dock).collection("Workers information").document(w).update("status","active");
            }
        });
        inactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("Date").document(kw5).collection("Table").
                        document(dock).collection("Workers information").document(w).update("status","inactive");
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wor,namee,reaa;
                wor=work2.getText().toString();
                namee=nam2.getText().toString();
                reaa=reason.getText().toString();
                db.collection("Date").document(kw5).collection("Table")
                        .document(dock).collection("Workers information").document(w).update("reason",reaa,"name",namee
                                ,"work",wor);
            }
        });


    }
    }
