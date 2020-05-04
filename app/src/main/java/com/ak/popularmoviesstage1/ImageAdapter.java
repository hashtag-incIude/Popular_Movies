package com.ak.popularmoviesstage1;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.github.florent37.viewanimator.ViewAnimator;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mPosters;
    private String[] poster_paths;

    String base_url = "https://image.tmdb.org/t/p/w342";
    String LOG_TAG = "ImageAdapter";

    public ImageAdapter(Context c, ArrayList<String> posters) {
        mContext = c;
        mPosters = posters;
        try {
            poster_paths = new String[mPosters.size()];
            for (int i = 0; i < mPosters.size(); i++) {
                poster_paths[i] = base_url + mPosters.get(i);
            }
        } catch (NullPointerException e) {
            Log.e(LOG_TAG, "Error", e);
        }
    }

    @Override
    public int getCount() {
        return poster_paths.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            //setAnimation();
            ViewAnimator
                    .animate(imageView)
                    .translationY(-1000, 0)
                    .alpha(0,1)
                    .start();



            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        Picasso.get().load(poster_paths[position])
                .placeholder(R.drawable.imaaa)
                .error(R.drawable.ic_error_outline_black_24dp).into(imageView);
        return imageView;
    }
}
