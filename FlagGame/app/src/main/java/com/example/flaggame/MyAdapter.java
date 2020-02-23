package com.example.flaggame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public class MyAdapter extends ArrayAdapter<String> {

    private String [] countryNames;
    private String [] capitalNames;
    int [] flags;
    Context mContext;

    public MyAdapter(@NonNull Context context, String[] countryNames, String[] capitalNames, int[] countryFlags) {
        super(context, R.layout.listview_item);
        this.countryNames = countryNames;
        this.capitalNames = capitalNames;
        this.flags = countryFlags;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = Objects.requireNonNull(mInflater).inflate(R.layout.listview_item, parent, false);
            mViewHolder.mFlag = convertView.findViewById(R.id.imageView);
            mViewHolder.mName = convertView.findViewById(R.id.textView);
            mViewHolder.mName2 = convertView.findViewById(R.id.textView2);
            convertView.setTag(mViewHolder);

        }else{
            mViewHolder = (ViewHolder)convertView.getTag();
        }

            mViewHolder.mFlag.setImageResource(flags[position]);
            mViewHolder.mName.setText(countryNames[position]);

        return convertView;
    }

    static class ViewHolder{
        ImageView mFlag;
        TextView mName;
        TextView mName2;
    }
}
