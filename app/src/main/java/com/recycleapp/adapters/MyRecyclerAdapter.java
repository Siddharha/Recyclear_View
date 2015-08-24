package com.recycleapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recycleapp.R;
import com.recycleapp.bean.Items;

import java.util.List;

/**
 * Created by BLUEHORSE 2015 on 8/24/2015.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private List<Items> items;
    private int itemLayout;

    public MyRecyclerAdapter(List<Items> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Items item = items.get(i);
        viewHolder.txt1.setText(item.getName());
        viewHolder.txt2.setText(item.getPhone_number());
        viewHolder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt1,txt2;
        public ViewHolder(View itemView) {
            super(itemView);
            txt1 = (TextView) itemView.findViewById(R.id.textView);
            txt2 = (TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
