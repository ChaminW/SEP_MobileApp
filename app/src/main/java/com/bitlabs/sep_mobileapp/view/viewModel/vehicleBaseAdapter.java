package com.bitlabs.sep_mobileapp.view.viewModel;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.bitlabs.sep_mobileapp.R;
import com.bitlabs.sep_mobileapp.data.Vehicle;

import java.util.ArrayList;


public class vehicleBaseAdapter extends BaseAdapter {

    private int[] IMAGE = {R.drawable.car_image1, R.drawable.car_image2, R.drawable.car_image3,
            R.drawable.car_image1, R.drawable.car_image2};

    Context context;
    ArrayList<Vehicle> vehicleList;
    Typeface fonts1, fonts2;
    String activeRegNo;

    public vehicleBaseAdapter(Context context, ArrayList<Vehicle> vehicleList,String activeRegNo) {
        this.context = context;
        this.vehicleList = vehicleList;
        this.activeRegNo=activeRegNo;
    }

    public void setList(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void setActiveRegNo(String activeRegNo) {
        this.activeRegNo = activeRegNo;

    }

    @Override
    public int getCount() {
        return vehicleList.size();
    }

    @Override
    public Object getItem(int position) {
        return vehicleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.vehicle_list_item, null);

            viewHolder = new ViewHolder();

            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.regNo = (TextView) convertView.findViewById(R.id.regNo);
            viewHolder.fuelType = (TextView) convertView.findViewById(R.id.fuelType);
            viewHolder.fuelUnit = (TextView) convertView.findViewById(R.id.fuelUnit);
            viewHolder.model = (TextView) convertView.findViewById(R.id.model);
            viewHolder.activeSwitch= (Switch) convertView.findViewById(R.id.vehicle_list_switch);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Vehicle vehicle = (Vehicle) getItem(position);

        try {
            viewHolder.image.setImageURI(Uri.parse(vehicle.getImage()));
        }
        catch (Exception e) {
            viewHolder.image.setImageResource(R.drawable.car_image2);
        }
        viewHolder.model.setText("Model: " + vehicle.getModel());
        viewHolder.regNo.setText(vehicle.getRegNo());
        //viewHolder.year.setText(bean.getYear());
        viewHolder.fuelType.setText(vehicle.getFuelType());
        viewHolder.fuelUnit.setText(vehicle.getFuelUnit());
        viewHolder.activeSwitch.setClickable(false);

        if (vehicle.getRegNo().equals(activeRegNo)) {
            viewHolder.activeSwitch.setChecked(true);
        }
        else {
            viewHolder.activeSwitch.setChecked(false);
        }
        return convertView;
    }


    private class ViewHolder {
        ImageView image;
        TextView model;
        TextView regNo;
        //TextView year;
        TextView fuelType;
        TextView fuelUnit;
        Switch activeSwitch;

    }
}




