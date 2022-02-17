package com.example.league;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PagerImageAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<String> mImages;
    public PagerImageAdapter(Context mContext, ArrayList<String> mImages) {
        this.mContext = mContext;
        this.mImages = mImages;
    }


    @Override
    public int getCount() {
        return mImages.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        if(!mImages.get(position).equals("null")) {
            Picasso.get().load(mImages.get(position)).fit().centerInside().into(imageView);
            container.addView(imageView);
            return imageView;
        }
        return null;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
