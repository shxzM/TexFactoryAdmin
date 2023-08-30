package com.shazdevelops.texfactoryad;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReadTableInfo extends RecyclerView.Adapter<ReadTableInfo.ReadTableInfoHolder> {
    MainScreen mainScreen;
    ArrayList<TableInfo> allDataList;

    public ReadTableInfo(MainScreen mainScreen, ArrayList<TableInfo> allDataList) {
        this.allDataList=allDataList;
        this.mainScreen=mainScreen;

    }

    @NonNull
    @Override
    public ReadTableInfoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReadTableInfoHolder(LayoutInflater.from(mainScreen).inflate(R.layout.item_table,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReadTableInfoHolder holder, int position) {
        holder.itemTableNumber.setText(allDataList.get(position).getTableNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainScreen.startActivity(new Intent(mainScreen,TableWorker.class).putExtra("key",allDataList.get(position).getUid())
                        .putExtra("kw2",allDataList.get(position).getKw()).putExtra("wDate",mainScreen.wDate));
            }
        });

    }

    @Override
    public int getItemCount() {
        return allDataList.size();
    }

    class ReadTableInfoHolder extends RecyclerView.ViewHolder {
        TextView itemTableNumber;

        public ReadTableInfoHolder(@NonNull View itemView) {
            super(itemView);
            itemTableNumber=itemView.findViewById(R.id.tableNo);
        }
    }


}
