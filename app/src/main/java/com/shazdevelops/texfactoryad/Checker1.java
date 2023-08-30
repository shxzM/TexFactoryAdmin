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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Checker1 extends AppCompatActivity {

    EditText chname, chwork;
    Button chadd;
    FirebaseFirestore db,db2;
    String kw6,kw7;
    String chna11,chwork11,chstat11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checker1);
        db=FirebaseFirestore.getInstance();
        chname=findViewById(R.id.chname);
        chadd=findViewById(R.id.chadd);
        chwork=findViewById(R.id.chwork);
        kw6=getIntent().getStringExtra("kw6");
        kw7=getIntent().getStringExtra("kw7");
        db2=FirebaseFirestore.getInstance();

        db2.collection("Date").document(kw6).collection("Table").document(kw7).collection("Checker information").
                document("Checker 1").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()){
                            DocumentSnapshot snapshot= task.getResult();
                            if (snapshot.exists()){
                                chna11=String.valueOf(snapshot.get("checkName"));
                                chname.setText(chna11);
                                chwork11=String.valueOf(snapshot.get("checkWork"));
                                chwork.setText(chwork11);
                            }
                        }
                    }
                });


        chadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chnamee,chst,chwor;
                chnamee=chname.getText().toString();
                chst="active";
                chwor=chwork.getText().toString();
                CheckersInfo checkersInfo = new CheckersInfo(chnamee,chst,chwor);
                db.collection("Date").document(kw6).collection("Table").document(kw7).collection("Checker information").
                        document("Checker 1").set(checkersInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Checker1.this, "Successful", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(Checker1.this, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
    }
