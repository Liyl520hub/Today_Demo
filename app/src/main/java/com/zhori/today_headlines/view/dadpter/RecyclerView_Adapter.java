package com.zhori.today_headlines.view.dadpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhori.today_headlines.R;
import com.zhori.today_headlines.model.threefragmentbena.ThreeBean;
import com.zhori.today_headlines.presenter.three_presenter.Three_Persenter;

import java.util.ArrayList;

/**
 * 作者：李亚雷
 * 时间：2017/5/17
 * 类用途：
 * 思路：
 */


public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.MyViewHolder> {


    private ArrayList<ThreeBean.ResultBean.DataBean> arr = new ArrayList<>();
    private Context mcontext;
    private Three_Persenter three_persenter;
    private MyonCliickListener myonCliickListener;


    public RecyclerView_Adapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void setMyonclickListener(MyonCliickListener myonCliickListener) {

        this.myonCliickListener=myonCliickListener;

    }


    public interface MyonCliickListener{


        void itemListener(View view,int position);
        void itemLongListener(View view,int position);


    }






    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(mcontext, R.layout.rec_item, null);

        MyViewHolder myViewHolder = new MyViewHolder(inflate);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        holder.text_view.setText(arr.get(position).getTitle());

        three_persenter.setImage(holder.imageView,arr.get(position).getThumbnail_pic_s());


        if (myonCliickListener!=null){

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position1=holder.getLayoutPosition();
                    myonCliickListener.itemListener(holder.imageView,position1);

                }
            });

            holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int layoutPosition = holder.getLayoutPosition();
                    myonCliickListener.itemLongListener(holder.imageView,layoutPosition);
                    return false;
                }
            });



        }



    }


    @Override
    public int getItemCount() {
        return arr.size();
    }


    public void setData(ArrayList<ThreeBean.ResultBean.DataBean> arrs) {

        if (arrs != null) {

            arr.addAll(arrs);

        }


    }

    public void setThree_persenter(Three_Persenter three_persenter) {

        this.three_persenter=three_persenter;

    }


    class MyViewHolder extends RecyclerView.ViewHolder {


        private final ImageView imageView;
        private final TextView text_view;

        public MyViewHolder(View itemView) {

            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imag_rec);
            text_view = (TextView) itemView.findViewById(R.id.text_rec);


        }


    }

}
