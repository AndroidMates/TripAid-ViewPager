package com.example.icode.tripaid;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by iCODE on 3/8/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {


    Context context;

    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context){
        this.context = context;
    }

    //array for slider images
    public int[] slider_images = {
        R.mipmap.first_bus,
        R.mipmap.second_bus,
        R.mipmap.third_bus
    };

    //array for slider headings
    public String[] slider_headings = {
            "WELCOME TO TRIP AID",
            "YOU CAN BOOK A BUS OF CHOICE",
            "LET'S START!"
    };

    //array for slider description
    public String[] slider_descriptions = {
      "Trip Aid is bus booking app that allows city travelers to buy tickets in order to travel to their various choice of destination",
            "Feel free to check-out our buses available",
            "Great! Let's begin, Have a successful journey"
    };

    //get the count of the size of slider_headings
    @Override
    public int getCount() {
        return slider_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView slider_heading = (TextView)view.findViewById(R.id.slide_heading);
        TextView slider_description = (TextView)view.findViewById(R.id.slide_description);

        imageView.setImageResource(slider_images[position]);
        slider_heading.setText(slider_headings[position]);
        slider_description.setText(slider_descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
