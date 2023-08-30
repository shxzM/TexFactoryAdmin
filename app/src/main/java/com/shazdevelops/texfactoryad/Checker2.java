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

public class Checker2 extends AppCompatActivity {
    EditText chname1, chwork1;
    Button chadd1;
    FirebaseFirestore db,db2;
    String kw6,kw7;
    String chna22,chwork22,chstat22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checker2);
        chname1=findViewById(R.id.chname1);
        kw6=getIntent().getStringExtra("kw8");
        kw7=getIntent().getStringExtra("kw9");
        chadd1=findViewById(R.id.chadd1);
        chwork1=findViewById(R.id.chwork1);
        db2=FirebaseFirestore.getInstance();

        db2.collection("Date").document(kw6).collection("Table").document(kw7).collection("Checker information").
                document("Checker 2").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()){
                            DocumentSnapshot snapshot= task.getResult();
                            if (snapshot.exists()){
                                chna22=String.valueOf(snapshot.get("checkName"));
                                chname1.setText(chna22);
                                chwork22=String.valueOf(snapshot.get("checkWork"));
                                chwork1.setText(chwork22);
                            }
                        }
                    }
                });

        chadd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chnamee,chst,chwor;
                chnamee=chname1.getText().toString();
                chst="active";
                chwor=chwork1.getText().toString();
                CheckersInfo checkersInfo = new CheckersInfo(chnamee,chst,chwor);
                db.collection("Date").document(kw6).collection("Table").document(kw7).collection("Checker information").
                        document("Checker 2").set(checkersInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Checker2.this, "Successful", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(Checker2.this, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });




    }
    }
