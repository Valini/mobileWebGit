package com.example.a1796104.formdb;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.OneItemViewHolder> {

    ArrayList<Student> studentList;
    StudentAdapter(ArrayList<Student> list){

        studentList = list;
    }

    @NonNull
    @Override
    public OneItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View inflatedView = inflater.inflate(R.layout.per_item_view_layout, viewGroup, false);

        return new OneItemViewHolder(inflatedView);
    }
    @Override
    public void onBindViewHolder(@NonNull OneItemViewHolder oneItemViewHolder, final int i) {

        oneItemViewHolder.tvOneItem.setText(studentList.get(i).getName());
        oneItemViewHolder.tvSecondItem.setText(studentList.get(i).getAddress());
        oneItemViewHolder.tvThirdItem.setText(studentList.get(i).getPhone());
        oneItemViewHolder.singleItemParentLayout.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Log.d("recycleView", "Clicked card Number" + Integer.toString(i));


            }
        });

    }


    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class OneItemViewHolder extends RecyclerView.ViewHolder  {

        TextView tvOneItem;
        TextView tvSecondItem;
        TextView tvThirdItem;

        FrameLayout singleItemParentLayout;

        public OneItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOneItem = itemView.findViewById(R.id.tv_in_item);
            tvSecondItem = itemView.findViewById(R.id.tv_in_item2);
            tvThirdItem=itemView.findViewById(R.id.tv_in_item3);
            singleItemParentLayout = itemView.findViewById(R.id.single_item_parent_layout);
        }




    }



}
