package com.example.classworkfive;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter{

    ArrayList<Items> itemsList = new ArrayList<>();
    Context context;

    public Adapter(ArrayList<Items> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rawitem, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        ((ViewHolder)holder).textname.setText(itemsList.get(position).getItemName());
        ((ViewHolder)holder).textprice.setText(itemsList.get(position).getItemPrice() + "") ;
        ((ViewHolder)holder).img.setImageResource(itemsList.get(position).getItemImg());
        ((ViewHolder)holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra ("items", (Parcelable) itemsList.get(position));
                context.startActivity(intent);
            }
        });

        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Items removeditem = itemsList.get(position);
                AlertDialog.Builder alert = new AlertDialog.Builder(context)
                        .setTitle("Attention")
                        .setMessage("Are you sure you want to delete this item?")
                        .setPositiveButton("delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                itemsList.remove(position);
                                notifyDataSetChanged();
                                Snackbar.make(context, view, "1 item deleted", 3000)
                                        .setAction("Undo", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                itemsList.add(removeditem);

                                            }
                                        }).show();
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView textname, textprice;
        View v;
        ImageView delete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            img = v.findViewById(R.id.itemImg);
            textname = v.findViewById(R.id.itemName);
            textprice = v.findViewById(R.id.itemPrice);
            delete = v.findViewById(R.id.imageViewDelete);

        }
    }

}
