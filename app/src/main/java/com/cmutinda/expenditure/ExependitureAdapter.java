package com.cmutinda.expenditure;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ExependitureAdapter extends RecyclerView.Adapter<ExependitureAdapter.ExpenditureViewHolder> {
    private List<Spend> spend=new ArrayList<>();
    private Context mctx;
    private Cursor mcursor;
    public  ExependitureAdapter(){}
    public class ExpenditureViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView price;
        public TextView date;

        public ExpenditureViewHolder( View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.text1);
            price=itemView.findViewById(R.id.text2);
        }
    }


    @Override
    public ExpenditureViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
       View view= inflater.inflate(R.layout.row_layout,parent,false);
        return new ExpenditureViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ExpenditureViewHolder holder, int position) {
//        if(!mcursor.moveToPosition(position)){
//            return;}
//         String name = mcursor.getString(mcursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_NAME));
//         int price = mcursor.getInt(mcursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_PRICE));
////         int date = mcursor.getInt(mcursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_DATE));

        Spend currentSpend =spend.get(position);
         holder.name.setText(currentSpend.getItem_name());
         holder.price.setText( String.valueOf(currentSpend.getPrice()));
//         holder.date.setText(String.valueOf(date));
    }

    @Override
    public int getItemCount() {
        return spend.size();
    }

    public void setSpend(List<Spend> spend) {
        this.spend = spend;
        notifyDataSetChanged();
    }
//  public void swapCursor(Cursor newCursor){
//        if(mcursor!=null){
//            mcursor.close();
//        }
//        if(newCursor!=null){
//            mcursor = newCursor;
//            notifyDataSetChanged();


        }


