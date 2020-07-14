package com.example.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class apple extends Fragment {

    String urladdr = "http://192.168.0.148:8080/test/recipe_all.jsp";
    ArrayList<RecipeData> list;
    RecipeRecyclerAdapter adapter;
    RecyclerView recyclerView;
    Context mcontext;


    public apple(){

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mcontext =context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.apple,container,false);
        try{
            list = new ArrayList<RecipeData>();
            NetworkTask networkTask = new NetworkTask(this,urladdr);
            list = (ArrayList<RecipeData>) networkTask.execute().get();
        }catch (Exception e){
            e.printStackTrace();
        }



        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        recyclerView = rootView.findViewById(R.id.recuocler_list) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(mcontext)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        adapter = new RecipeRecyclerAdapter(list) ;
        recyclerView.setAdapter(adapter) ;

        return rootView;

    }

}





