package com.shazdevelops.texfactoryad;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReadDate extends RecyclerView.Adapter<ReadDate.ReadDateHolder> {

    Dates dates;
    ArrayList<DateModel> dateList;
    public ReadDate(Dates dates, ArrayList<DateModel> dateList) {
        this.dateList=dateList;
        this.dates=dates;

    }

    @NonNull
    @Override
    public ReadDateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReadDateHolder(LayoutInflater.from(dates).inflate(R.layout.item_date,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReadDateHolder holder, int position) {
        holder.day.setText(String.valueOf(dateList.get(position).getDay()));
        holder.year.setText(String.valueOf(dateList.get(position).getYear()));
        String wDate=String.valueOf(dateList.get(position).getDay())+String.valueOf(dateList.get(position).getMonth())+String.valueOf(dateList.get(position)
                .getYear());
        if(dateList.get(position).getMonth()==1){
            holder.month.setText("Jan");
        }
        if(dateList.get(position).getMonth()==2){
            holder.month.setText("Feb");
        }
        if(dateList.get(position).getMonth()==3){
            holder.month.setText("Mar");
        }
        if(dateList.get(position).getMonth()==4){
            holder.month.setText("Apr");
        }
        if(dateList.get(position).getMonth()==5){
            holder.month.setText("May");
        }
        if(dateList.get(position).getMonth()==6){
            holder.month.setText("Jun");
        }
        if(dateList.get(position).getMonth()==7){
            holder.month.setText("Jul");
        }
        if(dateList.get(position).getMonth()==8){
            holder.month.setText("Aug");
        }
        if(dateList.get(position).getMonth()==9){
            holder.month.setText("Sep");
        }
        if(dateList.get(position).getMonth()==10){
            holder.month.setText("Oct");
        }
        if(dateList.get(position).getMonth()==11){
            holder.month.setText("Nov");
        }
        if(dateList.get(position).getMonth()==12){
            holder.month.setText("Dec");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dates.startActivity(new Intent(dates, MainScreen.class).putExtra("du",dateList.get(position).getDuid()).putExtra("wDate",wDate));
            }
        });




    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }

    class ReadDateHolder extends RecyclerView.ViewHolder {
        TextView day;
        TextView month;
        TextView year;
        public ReadDateHolder(@NonNull View itemView) {
            super(itemView);
            day=itemView.findViewById(R.id.day);
            month=itemView.findViewById(R.id.month);
            year=itemView.findViewById(R.id.year);
        }
    }
}
