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
import com.google.firebase.firestore.FirebaseFirestore;

public class AddTables extends AppCompatActivity {
    Button add;
    EditText edtTableName;
    EditText edtTableNumber;
    FirebaseFirestore db;
    String du1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tables);
        db= FirebaseFirestore.getInstance();

        add = findViewById(R.id.add);
        edtTableName = findViewById(R.id.edtTableName);
        edtTableNumber = findViewById(R.id.edtTableNumber);
        du1=getIntent().getStringExtra("du1");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName,tableNumber;
                String uid=db.collection("Table").document().getId();
                tableName = edtTableName.getText().toString();
                tableNumber = edtTableNumber.getText().toString();
                String kw=du1;

                TableInfo tableInfo = new TableInfo(tableName,tableNumber,uid,kw);

                db.collection("Date").document(du1).collection("Table").document(uid).
                        set(tableInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(AddTables.this, "Successful", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AddTables.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

    }
}