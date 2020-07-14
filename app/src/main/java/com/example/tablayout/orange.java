package com.example.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class orange  extends Fragment {

    Context mContext;
    String urlAddr = "http://192.168.0.148:8080/test/student_all.jsp" ;
    TextView textView;
    ListView listView;

    public orange(){

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext =context;
        Log.v("mContext","onAttach"+mContext.toString());

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("mContext","onCreate"+mContext.toString());


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.v("mContext","onViewCreated"+mContext.toString());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.v("mContext","onActivityCreated"+mContext.toString());

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("mContext","onResume"+ mContext.toString());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.orange,container,false);

          listView = rootView.findViewById(R.id.orangelist);
//        textView.setText("오렌지");

//        textChange(rootView);
        return rootView;


    }



}
