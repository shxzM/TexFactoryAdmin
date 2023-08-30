package com.shazdevelops.texfactoryad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddWorker extends AppCompatActivity {

    EditText editWorkerNumber;
    Button ad;
    FirebaseFirestore db;
    String k;
    String kw4;
    EditText name;
    EditText work;
   FirebaseDatabase db1;
  DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_worker);
        editWorkerNumber = findViewById(R.id.editWorkerNumber);
        ad = findViewById(R.id.button3);
        work=findViewById(R.id.work);
        db=FirebaseFirestore.getInstance();
        kw4=getIntent().getStringExtra("kw4");
        name = findViewById(R.id.name);
        k=getIntent().getStringExtra("k");

        db1=FirebaseDatabase.getInstance();
        reference=db1.getReference("Workers");

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String status,nam,wo,re;
                int workerNumber;
                String wuid=db.collection("Date").document(kw4).collection("Table").document(k).
                        collection("Workers information").document().getId();
                workerNumber = Integer.parseInt(editWorkerNumber.getText().toString());
                status ="active";
                wo=work.getText().toString();
                nam=name.getText().toString();
                String ke=k;
                String kw21=kw4;
                re="";
                int d1,d2,d3,d4,d5,d6,d7,d8;
                d1=0;
                d2=0;
                d3=0;
                d4=0;
                d5=0;
                d6=0;
                d7=0;
                d8=0;
               String wname2 = name.getText().toString();

                WorkerInfo workerInfo = new WorkerInfo(workerNumber,status,wuid,ke,nam,wo,re,kw21,d1,d2,d3,d4,d5,d6,d7,d8);

                WorkerModel workerModel= new WorkerModel(wname2);
               reference.child(wname2).setValue(workerModel);

                db.collection("Date").document(kw21).collection("Table").document(k).collection("Workers information").
                        document(wuid).set(workerInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(AddWorker.this, "Worker added", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(AddWorker.this, "Worker failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



            }
        });



    }
    }
