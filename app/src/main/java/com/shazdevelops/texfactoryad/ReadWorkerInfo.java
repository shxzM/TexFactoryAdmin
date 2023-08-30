package com.shazdevelops.texfactoryad;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReadWorkerInfo extends RecyclerView.Adapter<ReadWorkerInfo.ReadWorkerHolder>{
    TableWorker tableWorker;
    ArrayList<WorkerInfo> allWorkerList;
    String c;

    public ReadWorkerInfo(TableWorker tableWorker, ArrayList<WorkerInfo> allWorkerList) {
        this.allWorkerList=allWorkerList;
        this.tableWorker=tableWorker;

    }
    @NonNull
    @Override
    public ReadWorkerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReadWorkerHolder(LayoutInflater.from(tableWorker).inflate(R.layout.item_worker,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReadWorkerHolder holder, int position) {
        c=allWorkerList.get(position).getStatus().toString();
        if(c.equals("active")){
            holder.image.setImageResource(R.drawable.greenworker);

        }else if(c.equals("inactive")){
            holder.image.setImageResource(R.drawable.redworker);
        }

        holder.textView.setText(String.valueOf(allWorkerList.get(position).getWorkerNumber()));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableWorker.startActivity(new Intent(tableWorker,UpdateWorkerStatus.class).
                        putExtra("wkey",allWorkerList.get(position).getWuid()).putExtra("ke",allWorkerList.get(position).getKe()).
                        putExtra("n",allWorkerList.get(position).getName()).putExtra("worka",allWorkerList.get(position).getWork())
                        .putExtra("defect",allWorkerList.get(position).getReason()).putExtra("kw5",allWorkerList.get(position).getKw3())
                        .putExtra("d1",allWorkerList.get(position).getDef1()).putExtra("d2",allWorkerList.get(position).getDef2())
                        .putExtra("d3",allWorkerList.get(position).getDef3()).putExtra("d4",allWorkerList.get(position).getDef4())
                        .putExtra("d5",allWorkerList.get(position).getDef5()).putExtra("d6",allWorkerList.get(position).getDef6())
                        .putExtra("d7",allWorkerList.get(position).getDef7()).putExtra("d8",allWorkerList.get(position).getDef8())
                        .putExtra("wDate",tableWorker.wDate));
            }
        });
    }

    @Override
    public int getItemCount() {
        return allWorkerList.size();
    }

    class ReadWorkerHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView textView;
        public ReadWorkerHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.imageView4);
            textView=itemView.findViewById(R.id.textView4);

        }
    }
}
