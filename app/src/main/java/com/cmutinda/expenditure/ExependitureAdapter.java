package com.cmutinda.expenditure;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class ExependitureAdapter extends RecyclerView.Adapter<ExependitureAdapter.ExpenditureViewHolder> {
    private Context mctx;
    private Cursor mcursor;
    public  ExependitureAdapter(Context context, Cursor cursor){

        mctx=context;
        mcursor=cursor;
    }
    public class ExpenditureViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView price;
        public TextView date;

        public ExpenditureViewHolder( View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.text1);
            price=itemView.findViewById(R.id.text2);
            date=itemView.findViewById(R.id.text3);
        }
    }



    @Override
    public ExpenditureViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mctx);
       View view= inflater.inflate(R.layout.row_layout,parent,false);
        return new ExpenditureViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ExpenditureViewHolder holder, int position) {
        if(!mcursor.moveToPosition(position)){
            return;}
         String name = mcursor.getString(mcursor.getColumnIndex(ItemContract.ItemEntry.ITEM_NAME));
         int price = mcursor.getInt(mcursor.getColumnIndex(ItemContract.ItemEntry.PRICE));
         int date = mcursor.getInt(mcursor.getColumnIndex(ItemContract.ItemEntry.DATE));


         holder.name.setText(name);
         holder.price.setText(mctx.getString(R.string.price, String.valueOf(price)));
         holder.date.setText(String.valueOf(date));
    }
    @Override
    public int getItemCount() {
        return mcursor.getCount();
    }

  public void swapCursor(Cursor newCursor){
        if(mcursor!=null){
            mcursor.close();
        }
        if(newCursor!=null){
            mcursor = newCursor;
            notifyDataSetChanged();


        }
  }
}
