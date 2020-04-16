package com.cmutinda.expenditure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public  class MyAdapter extends BaseAdapter {
    private Context context;
  String [] drawer;
  int[] images={R.drawable.ic_person_black_24dp,R.drawable.ic_balance,R.drawable.ic_expense,
          R.drawable.ic_category,R.drawable.ic_setting,R.drawable.ic_log} ;

  public MyAdapter(Context context){
      this.context=context;

      drawer=context.getResources().getStringArray(R.array.drawer_list);
  }

  @Override
  public int getCount() {
      return drawer.length;
  }

  @Override
  public Object getItem(int position) {

      return drawer[position];
  }

  @Override
  public long getItemId(int position) {
      return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
        View row;
      if(convertView==null){
          LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          row=inflater.inflate(R.layout.row_list_view,parent,false);


      }
      else {
          row = convertView;

      }
      TextView textView=row.findViewById(R.id.drawer_text);
      ImageView imageView=row.findViewById(R.id.drawer_image);

      textView.setText(drawer[position]);
      imageView.setImageResource(images[position]);

      return row;
  }
}
