package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.ArrayList;


public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecipeRecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RecipeData> mData = null ;
    private RequestManager manager;



    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1 ;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            textView1 = itemView.findViewById(R.id.card_view_text) ;
            imageView = itemView.findViewById(R.id.card_view_img);
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    RecipeRecyclerAdapter(ArrayList<RecipeData> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public RecipeRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.activity_recycler_item, parent, false) ;
        RecipeRecyclerAdapter.ViewHolder vh = new RecipeRecyclerAdapter.ViewHolder(view) ;
        //선언한 contextdp parent.getContext 값을 넣어준다 (호출한 Context)
        context = parent.getContext();
        //Glide 라이브러리의 Context 값을 미리 넣어준다 ! 넣어주지 않고 한번에 호출해서 불러오면 값을 불러오기전에 CONTEXT 가 닫힘)
        manager = Glide.with(context);

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(RecipeRecyclerAdapter.ViewHolder holder, int position) {
        String text = mData.get(position).getName();
        String imgurl =mData.get(position).getImgurl();
        manager.load(imgurl).into(holder.imageView);
        holder.textView1.setText(text) ;
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }
}
