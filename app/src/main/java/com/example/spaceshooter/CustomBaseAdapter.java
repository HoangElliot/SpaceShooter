package com.example.spaceshooter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    String ListSpaceShip[];
    int ListSpaceShipImage[];
    LayoutInflater layoutInflater;

    public CustomBaseAdapter(Context context, String spaceShip[], int spaceShipImg[]) {
        this.context = context;
        this.ListSpaceShip = spaceShip;
        this.ListSpaceShipImage = spaceShipImg;

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ListSpaceShip.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.activity_space_ship_list_view, null);

        //TextView textView = (TextView) convertView.findViewById(R.id.name);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageIcon);

        //textView.setText(ListSpaceShip[position]);
        imageView.setImageResource(ListSpaceShipImage[position]);


        return convertView;
    }
}
