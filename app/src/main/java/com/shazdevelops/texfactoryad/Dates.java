package com.shazdevelops.texfactoryad;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Dates extends AppCompatActivity {
    Button date;
    DatePickerDialog datePickerDialog;
    int year,month,day;
    ArrayList<DateModel> dateList;
    FirebaseFirestore db,db1;
    RecyclerView rcv2;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dates);
        rcv2=findViewById(R.id.rcv2);
        db=FirebaseFirestore.getInstance();
        db1=FirebaseFirestore.getInstance();
        Calendar calendar= Calendar.getInstance();
        date=findViewById(R.id.date);
        logout=findViewById(R.id.button4);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        initDatePicker();
        getDates();
    }

    private void getDates() {
        dateList = new ArrayList<>();
        dateList.clear();
        db1.collection("Date").orderBy("day").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error==null){
                    List<DateModel> dateModelList = value.toObjects(DateModel.class);
                    if(!dateModelList.isEmpty()){
                        dateList.clear();
                    }
                    dateList.addAll(dateModelList);
                    rcv2.setLayoutManager(new LinearLayoutManager(Dates.this));
                    rcv2.setAdapter(new ReadDate(Dates.this,dateList));
                }
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month= month+1;
                String duid =db.collection("Date").document().getId();
                DateModel dateModel = new DateModel(year,month,dayOfMonth,duid);
                db.collection("Date").document(duid).set(dateModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Dates.this, "Successful", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Dates.this, "Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        };
        Calendar cal = Calendar.getInstance();
        year=cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(Dates.this,dateSetListener,year,month,day);
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}