package com.example.engrumair.musicplayer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Engr.Umair on 6/2/2015.
 */
public class GridAdapter extends BaseAdapter {
  //  private Context mContext;
  private Context mContext;
    private final String[] lower_item;
    private final int[] Image_id;
      String [] result;
//    Context context;
//    int [] imageId;
//    public Integer[] mThumb = {
//            R.drawable.pic_1, R.drawable.pic_2,
//            R.drawable.pic_3, R.drawable.pic_4
//             };
//    private static LayoutInflater inflater = null;

    public GridAdapter(Context c,String[] lower_item,int[] Image_id ) {
        mContext = c;
        this.Image_id = Image_id;
        this.lower_item = lower_item;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return lower_item.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        View view= convertView;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_lower_item);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            if(position == 0)
            grid.setBackgroundColor(Color.parseColor("#4c86aa"));
            if(position == 1)
                grid.setBackgroundColor(Color.parseColor("#857f96"));
            if(position == 2)
                grid.setBackgroundColor(Color.parseColor("#2298bf"));
            if(position == 3)
                grid.setBackgroundColor(Color.parseColor("#67bf9c"));
            if(position == 4)
                grid.setBackgroundColor(Color.parseColor("#e5a16a"));
            if(position == 5)
                grid.setBackgroundColor(Color.parseColor("#3ad19e"));
            if(position == 6)
                grid.setBackgroundColor(Color.parseColor("#7caebf"));

            grid.setAlpha(0.8f);

//            view.getBackground().setColorFilter(Color.parseColor("#EFEDEC"), PorterDuff.Mode.DARKEN);
            textView.setText(lower_item[position]);
            imageView.setImageResource(Image_id[position]);

        }else {
            grid = (View) convertView;
        }
//        View view = inflater.inflate(R.layout.grid_item,null);
        return grid;
    }
}
