package com.example.urbanres.Reviews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbanres.DB_Handler;
import com.example.urbanres.R;


import java.util.ArrayList;

public class RevAddapter extends RecyclerView.Adapter<RevAddapter.Holder> {

    private Context context;
    private ArrayList<Reviews> arrayList;
    private DB_Handler db_handler;

    public RevAddapter(Context context, ArrayList<Reviews> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        db_handler = new DB_Handler(context);

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sigle_review, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Reviews model = arrayList.get(position);
        //Get for view
        String id = model.getId();
        String review = model.getReview();
        String date = model.getDate();
        float scount = model.getScount();

        //Set view
        holder.rt.setRating(scount);
        holder.date.setText(date);
        holder.Msg.setText(review);

        //pop up menu for delete and edit
        holder.opt.setOnClickListener (v -> {
            PopupMenu popupMenu = new PopupMenu(context,v);
            popupMenu.getMenuInflater().inflate(R.menu.menu_rev, popupMenu.getMenu());
            popupMenu.show();

            popupMenu.setOnMenuItemClickListener( new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.edit:

                            Reviews bModel = new Reviews(id, date, Float. toString(scount), review);
                            int status = db_handler.updateReview(bModel);
                            if (status == 1){
                                context.startActivity(new Intent(context,GetReviews.class));
                                Toast.makeText(context, "Booking Updated Successfully!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case R.id.delete:
                            Toast.makeText(context,"Successfully Deleted",Toast.LENGTH_SHORT).show();
                            db_handler.deleteReview(id);
                            context.startActivity(new Intent(context,GetReviews.class));
                            break;
                    }
                    return true;
                }
            });
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        //
        TextView date,Msg;
        RatingBar rt;
        ImageView opt;

        public Holder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.posteddate);
            Msg = itemView.findViewById(R.id.msg);
            rt = itemView.findViewById(R.id.singleRt);
            opt = itemView.findViewById(R.id.options);

        }
    }

}