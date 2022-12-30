package com.project.pendahospital.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pendahospital.Models.DiagnosisModel;
import com.project.pendahospital.Patient.DiagnosisActivity;
import com.project.pendahospital.R;
import com.project.pendahospital.Activities.TestActivity;

import java.util.ArrayList;

public class DiagnosisAdapter extends RecyclerView.Adapter<DiagnosisAdapter.ViewHolder> {

    public DiagnosisAdapter(Context context, ArrayList<DiagnosisModel> list, DiagnosisActivity diagnosisActivity) {
        this.context = context;
        this.list = list;
    }
    Context context;
    ArrayList<DiagnosisModel>list;

    @NonNull
    @Override
    public DiagnosisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.diagnostic_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull DiagnosisAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.icon.setImageResource(list.get(position).getImage());
        holder.title.setText(list.get(position).getDisease());
        holder.description.setText(list.get(position).getDescription());
        holder.amount.setText(list.get(position).getAmount());
        holder.booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TestActivity.class);
                intent.putExtra("title",list.get(position).getDisease());
                intent.putExtra("amount",list.get(position).getAmount());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,description,amount;
        ImageView icon;
        AppCompatButton booking;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.profile_image);
            title = itemView.findViewById(R.id.disease);
            description = itemView.findViewById(R.id.description_text);
            amount = itemView.findViewById(R.id.amount1);
            booking = itemView.findViewById(R.id.book);

        }
    }
}
