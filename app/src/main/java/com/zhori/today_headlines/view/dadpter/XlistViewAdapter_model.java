package com.zhori.today_headlines.view.dadpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhori.today_headlines.R;
import com.zhori.today_headlines.model.homeFragmentBean.HomeBean_F1Content;
import com.zhori.today_headlines.presenter.home_presenter.Fragment_Model_Persenter;

import java.util.ArrayList;

/**
 * 作者：李亚雷
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class XlistViewAdapter_model extends BaseAdapter {

    private Context context;
    private ArrayList<HomeBean_F1Content.ResultBean.DataBean> data = new ArrayList<>();

    private int TYPE_1 = 0;
    private int TYPE_2 = 1;
    private int TYPE_3 = 2;
    private Fragment_Model_Persenter fragment_model_persenter;


    public XlistViewAdapter_model(Context context) {
        this.context = context;


    }

    public void setListData(HomeBean_F1Content homeBean_f1Content) {


        if (homeBean_f1Content != null) {
            data.addAll(homeBean_f1Content.getResult().getData());
        }

    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public HomeBean_F1Content.ResultBean.DataBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getViewTypeCount() {
        return 3;
    }


    @Override
    public int getItemViewType(int position) {


        String s = data.get(position).getThumbnail_pic_s();
        String s1 = data.get(position).getThumbnail_pic_s02();
        String s2 = data.get(position).getThumbnail_pic_s03();


        if (s != null && s1 != null && s2 != null) {

            return TYPE_3;
        } else if (s != null && s1 != null) {

            return TYPE_2;
        } else {

            return TYPE_1;
        }

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        //返回值是类别
        int type = getItemViewType(position);


        switch (type) {

            case 0: {
                ViewHolder1 viewHolder1;
                if (convertView == null) {

                    convertView = View.inflate(context, R.layout.xlist_item_model1, null);

                    viewHolder1 = new ViewHolder1();
                    viewHolder1.imag_right = (ImageView) convertView.findViewById(R.id.right_imag);
                    viewHolder1.text_up = (TextView) convertView.findViewById(R.id.text_up);
                    viewHolder1.text_down = (TextView) convertView.findViewById(R.id.text_down);

                    convertView.setTag(viewHolder1);

                } else {

//                    if (convertView.getTag() instanceof ViewHolder1) {
//                        viewHolder1 = (ViewHolder1) convertView.getTag();
//                    }

                    viewHolder1 = (ViewHolder1) convertView.getTag();


                }

                fragment_model_persenter.setImag(viewHolder1.imag_right, data.get(position).getThumbnail_pic_s());

                viewHolder1.text_up.setText(data.get(position).getTitle() + "");
                viewHolder1.text_down.setText(data.get(position).getAuthor_name() + "");


            }

            break;

            case 1: {
                ViewHolder2 viewHolder2;

                if (convertView == null) {

                    viewHolder2 = new ViewHolder2();
                    convertView = View.inflate(context, R.layout.xlist_item_model2, null);
                    viewHolder2.imag_right = (ImageView) convertView.findViewById(R.id.right_imag);
                    viewHolder2.imag_left = (ImageView) convertView.findViewById(R.id.left_imag);

                    viewHolder2.text_up = (TextView) convertView.findViewById(R.id.text_up);

                    convertView.setTag(viewHolder2);

                } else {

//                    if (convertView.getTag() instanceof ViewHolder2) {
//                        viewHolder2 = (ViewHolder2) convertView.getTag();
//                    }

                    viewHolder2 = (ViewHolder2) convertView.getTag();

                }

                fragment_model_persenter.setImag(viewHolder2.imag_left, data.get(position).getThumbnail_pic_s());
                fragment_model_persenter.setImag(viewHolder2.imag_right, data.get(position).getThumbnail_pic_s02());
                viewHolder2.text_up.setText(data.get(position).getTitle() + "");


            }
            break;


            case 2: {
                ViewHolder3 viewHolder3;
                if (convertView == null) {

                    convertView = View.inflate(context, R.layout.xlist_item_model3, null);

                    viewHolder3 = new ViewHolder3();
                    viewHolder3.imag_right = (ImageView) convertView.findViewById(R.id.right_imag);
                    viewHolder3.imag_medol = (ImageView) convertView.findViewById(R.id.middle_imag);
                    viewHolder3.imag_left = (ImageView) convertView.findViewById(R.id.left_imag);
                    viewHolder3.text_up = (TextView) convertView.findViewById(R.id.text_up);

                    convertView.setTag(viewHolder3);

                } else {

                    viewHolder3 = (ViewHolder3) convertView.getTag();

                }

                fragment_model_persenter.setImag(viewHolder3.imag_left, data.get(position).getThumbnail_pic_s());
                fragment_model_persenter.setImag(viewHolder3.imag_medol, data.get(position).getThumbnail_pic_s02());
                fragment_model_persenter.setImag(viewHolder3.imag_right, data.get(position).getThumbnail_pic_s03());
                viewHolder3.text_up.setText(data.get(position).getTitle() + "");


            }
            break;


        }


        //xlist_item_model1是一张图片的布局

        return convertView;
    }

    public void setPersenter(Fragment_Model_Persenter fragment_model_persenter) {

        this.fragment_model_persenter = fragment_model_persenter;

    }


    private class ViewHolder1 {

        ImageView imag_right;
        TextView text_up;
        TextView text_down;


    }


    private class ViewHolder2 {

        ImageView imag_left;
        ImageView imag_right;
        TextView text_up;
    }


    private class ViewHolder3 {

        ImageView imag_left;
        ImageView imag_medol;
        ImageView imag_right;
        TextView text_up;
    }


}
