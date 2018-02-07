package com.example.tuan.obesityweightwatcher;

/**
 * Created by tuan on 16/5/2017.
 */

import android.content.Context;
import android.widget.BaseAdapter;



        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.MultiAutoCompleteTextView;
        import android.widget.TextView;

        import java.util.ArrayList;

/**
 * Created by User on 12/4/2017.
 */

public class PostListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<postDetails>PostingDetailsList;

    public PostListAdapter(Context context, int layout, ArrayList<postDetails> postingDetailsList) {
        this.context = context;
        this.layout = layout;
        PostingDetailsList = postingDetailsList;
    }

    @Override
    public int getCount() {
        return PostingDetailsList.size();
    }

    @Override
    public Object getItem(int position) {
        //return super.getItem(super.getCount() - position - 1);
        return PostingDetailsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{

        //TextView txtName,txtPassword;
        //TextView txtUsername;
        TextView txtWeight,txtHeight,txtBmiTarget,txtDate,txtBmiClass,txtCaloriesLoss;

    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if (row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);

            holder.txtDate = (TextView)row.findViewById(R.id.current_date);
            holder.txtWeight = (TextView)row.findViewById(R.id.data_1);
            holder.txtHeight = (TextView)row.findViewById(R.id.data_2);
            holder.txtBmiTarget = (TextView)row.findViewById(R.id.data_CaloriesTarget);
            holder.txtBmiClass = (TextView)row.findViewById(R.id.data_class);

            row.setTag(holder);

        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        postDetails postDetails = PostingDetailsList.get(position);//data_Caloriesloss




        holder.txtWeight.setText(postDetails.getWeight());
        holder.txtHeight.setText(postDetails.getHeight());
        //holder.txtBmiValue.setText(postDetails.getBmiValue());
        holder.txtDate.setText(postDetails.getDate());
        holder.txtBmiClass.setText(postDetails.getBmiClass());
        holder.txtBmiTarget.setText(postDetails.getCaloriesLoss());

        return row;
    }
}
