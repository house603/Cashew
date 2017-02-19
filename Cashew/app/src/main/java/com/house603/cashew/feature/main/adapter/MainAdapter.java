package com.house603.cashew.feature.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.house603.cashew.R;

import java.util.List;

/**
 * Created by Admin on 2/18/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private int mType = 9;
    public static final int CONVERTER = 0;
    public static final int COMMODITY = 1;
    public static final int COMMENTARY = 2;
    private Context mContext;
    MainAdapterListner mClickListener;
    List<String>mModelList;

    public MainAdapter(Context context, int type, MainAdapterListner listener) {
        mContext = context;
        this.mClickListener = listener;
        this.mType = type;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView;
        // Inflate the custom layout
        if (mType == CONVERTER) {
            //contactView = inflater.inflate(R.layout.list_drag_contact_item, parent, false);
        } else if (mType == COMMODITY) {
           // contactView = inflater.inflate(R.layout.list_drag_favourite_contact_item, parent, false);
        } else {
           // contactView = inflater.inflate(R.layout.list_drag_recent_contact_item, parent, false);
        }

        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mfavouriteContactName;
        ImageView mCallTypeImage;


        View mItemView;

        ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            if (mType == CONVERTER){
            }else if(mType == COMMODITY){


            }else if(mType == COMMENTARY){

            }

        }
    }
}
