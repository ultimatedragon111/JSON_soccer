package com.example.league;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CompAdapter extends RecyclerView.Adapter <CompAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<Competition> competitions;

    public CompAdapter(ArrayList<Competition> competitions, Context context) {
        this.context = context;
        this.competitions = competitions;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        private ImageView flag;
        private TextView textTitle;
        private TextView textDescription;
        private Button button;
        private Button button2;


        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            flag= itemView.findViewById(R.id.imageView2);
            textTitle= itemView.findViewById(R.id.textView2);
            textDescription= itemView.findViewById(R.id.textView3);
            button= itemView.findViewById(R.id.button);
            button2= itemView.findViewById(R.id.button2);
            cardView = itemView.findViewById(R.id.CardRec);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_com,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        Picasso.get().load(competitions.get(position).getFlag())
                .fit()
                .centerCrop()
                .into(holder.flag);
        holder.textTitle.setText(competitions.get(position).getTextTitle());
        holder.textDescription.setText(competitions.get(position).getTextDescription());
        if (competitions.get(position).getImages().size() != 0){
            holder.button2.setVisibility(View.VISIBLE);
            holder.button2.setOnClickListener(v -> {
                Intent intent2 = new Intent(context,PagerActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.putStringArrayListExtra("images", competitions.get(holder.getAdapterPosition()).getImages());
                context.startActivity(intent2);
            });
        }else{
            holder.button2.setVisibility(View.INVISIBLE);

        }
        holder.button.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://" + competitions.get(holder.getAdapterPosition()).getVisitWeb());
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return competitions.size();
    }

}
