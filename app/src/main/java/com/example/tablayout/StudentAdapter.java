package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    private Context mContext;
    private int layout;
    private ArrayList<Student> data;
    private LayoutInflater layoutInflater;

    public StudentAdapter(Context mContext, int layout, ArrayList<Student> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(this.layout, parent, false);
        }


        TextView tv_name = convertView.findViewById(R.id.name);
        TextView tv_dept = convertView.findViewById(R.id.dept);
        TextView tv_phone = convertView.findViewById(R.id.phone);


        tv_name.setText("이름 : " +data.get(position).getName());
        tv_dept.setText("학과 : " + data.get(position).getDept());
        tv_phone.setText("번호 : " + data.get(position).getPhone());


        return convertView;
    }
}
