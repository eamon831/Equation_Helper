package com.example.equationhelper;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.equationhelper.database.User;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {
     List<User> list;
    Context context;

    public adapter(List<User> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return  new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.t.setText(list.get(position).firstName);
        holder.t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,Equations.class);
                intent.putExtra("item",list.get(position));


                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView t;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.itemTextView);
            t.setGravity(Gravity.CENTER_HORIZONTAL);
            t.setGravity(Gravity.CENTER_VERTICAL);
            t.setAlpha(0.8F);
        }
    }
}