package com.shazdevelops.texfactoryad;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TableWorker extends AppCompatActivity {
    String key;
    String keyy;
    Button addWorker;
    RecyclerView wrcv;
    String kw21;
    String kw22;
    ImageView checker1,checker2;
    String chstatus1, chstatus2;
    ArrayList<WorkerInfo> allWorkerList;
    FirebaseFirestore db1,db2,db3;
    String wDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_worker);
        addWorker= findViewById(R.id.button2);
        db1=FirebaseFirestore.getInstance();
        checker1=findViewById(R.id.checker1);
        checker2=findViewById(R.id.checker2);
        wrcv = findViewById(R.id.wrcv);
        key=getIntent().getStringExtra("key");
        kw21=getIntent().getStringExtra("kw2");
        db2=FirebaseFirestore.getInstance();
        db3=FirebaseFirestore.getInstance();
        wDate=getIntent().getStringExtra("wDate");

//        db2.collection("Date").document(kw21).collection("Table")
//                .document(key).collection("Checker Information").document("Checker 1").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        if (task.isSuccessful()){
//                            DocumentSnapshot snapshot= task.getResult();
//                            if (snapshot.exists()){
//                                chstatus1=snapshot.get("checkStatus").toString();
//                                if (chstatus1.equals("inactive")){
//                                    checker1.setImageResource(R.drawable.redworker);
//                                }
//                            }
//                        }
//                    }
//                });

        checker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableWorker.this,Checker1.class).putExtra("kw6",kw21).putExtra("kw7",key);

                startActivity(intent);
            }
        });
        checker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableWorker.this,Checker2.class).putExtra("kw8",kw21)
                        .putExtra("kw9",key);
                startActivity(intent);
            }
        });



        addWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TableWorker.this,AddWorker.class).putExtra("k",key).putExtra("kw4",kw21);
                startActivity(intent);

            }
        });

        getAllWorkerInfo();
    }
    public void getAllWorkerInfo(){
        allWorkerList = new ArrayList<>();
        allWorkerList.clear();
        kw22=getIntent().getStringExtra("kw2");

        keyy = getIntent().getStringExtra("key");
        db1.collection("Date").document(kw22).collection("Table")
                .document(keyy).collection("Workers information").orderBy("workerNumber").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error == null){
                    List<WorkerInfo> dat = value.toObjects(WorkerInfo.class);
                    if(!dat.isEmpty()){
                        allWorkerList.clear();
                    }
                    allWorkerList.addAll(dat);
                    wrcv.setLayoutManager(new GridLayoutManager(TableWorker.this,2));
                    wrcv.setAdapter(new ReadWorkerInfo(TableWorker.this,allWorkerList));
                }
            }
        });

    }}
