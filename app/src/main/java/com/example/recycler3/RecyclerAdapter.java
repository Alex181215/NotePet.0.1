package com.example.recycler3;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<String> nameList;
    List<String> ageList;
    List<String> idList;


    private RecyclerViewClickInterface recyclerViewClickInterface;

    public RecyclerAdapter(List<String> nameList, List<String> ageList, List<String> idList, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.nameList = nameList;
        this.ageList = ageList;
        this.idList = idList;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // тут раздуваем представление из формы, и возвращаем его и показываем в ресайкле
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // в этом методе работаем с элементами таблички
        // ниже выводим порядковые номера в табличку
        holder.textViewName.setText(nameList.get(position));
        holder.textViewAge.setText(ageList.get(position));
    }

    @Override
    public int getItemCount() {
        return nameList.size();  // определяем сколько показывать Холдеров/табличек
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // В этом классе обьявляем переменные из таблички
        LinearLayout layoutProfile;
        ImageView imageViewAva;
        TextView textViewName, textViewAge;
        RelativeLayout layoutPen;
        RelativeLayout layoutDel;
        ImageView imageViewPen, imageViewDel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // здесь инициализируем переменные из таблички
            layoutProfile = itemView.findViewById(R.id.layoutItem);
            imageViewAva = itemView.findViewById(R.id.ava);
            textViewName = itemView.findViewById(R.id.tv_name);
            textViewAge = itemView.findViewById(R.id.tv_animal_age);
            layoutPen = itemView.findViewById(R.id.layout1);
            layoutDel = itemView.findViewById(R.id.layout2);
            imageViewPen = itemView.findViewById(R.id.btn_pen);
            imageViewDel = itemView.findViewById(R.id.btn_del);

            imageViewAva.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    String testId = idList.get(position);
                    int id = Integer.parseInt(testId);
                    recyclerViewClickInterface.onItemClick("profile",  id);
                }
            });
//
            layoutProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Test", "Adapter");

                    int position = getAdapterPosition();
                    String testId = idList.get(position);
                    int id = Integer.parseInt(testId);

                    recyclerViewClickInterface.onItemClick("profile", id);
                }
            });

            layoutPen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    String testId = idList.get(position);
                    int id = Integer.parseInt(testId);
                    recyclerViewClickInterface.onItemClick("edit", id);
                }
            });

            imageViewPen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    String testId = idList.get(position);
                    int id = Integer.parseInt(testId);
                    recyclerViewClickInterface.onItemClick("edit",  id);
                }
            });

            layoutDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    String testId = idList.get(position);
                    int id = Integer.parseInt(testId);
                    recyclerViewClickInterface.onItemClick("del", id);
                }
            });
//
            imageViewDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    String testId = idList.get(position);
                    int id = Integer.parseInt(testId);
                    recyclerViewClickInterface.onItemClick("del", id);
                }
            });
        }
    }
}
