package com.example.icode.tripaid;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout dotLayout;
    private ViewPager viewPager;

    private TextView[] slider_dots;

    private Button backBtn;
    private Button nextBtn;

    //variable for the current page of the slider
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerAdapter = new ViewPagerAdapter(this);

        dotLayout = (LinearLayout)findViewById(R.id.dotLayout);
        viewPager = (ViewPager)findViewById(R.id.slider_viewPager);
        viewPager.setAdapter(viewPagerAdapter);

        //call to the addDotsIndicator function
        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);


        backBtn = (Button)findViewById(R.id.backBtn);
        nextBtn =(Button)findViewById(R.id.nextBtn);

        //onClickListeners
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage + 1);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage - 1);
            }
        });
    }

    //add Dots to the slideViewPager
    public void addDotsIndicator(int position){

        slider_dots = new TextView[3];
        dotLayout.removeAllViews();

        for(int i = 0; i < slider_dots.length; i++){
            slider_dots[i] = new TextView(this);
            slider_dots[i].setText(Html.fromHtml("&#8226;"));
            slider_dots[i].setTextSize(35);
            slider_dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            dotLayout.addView(slider_dots[i]);
        }

        if(slider_dots.length > 0){
            slider_dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            currentPage = i;

            if(i == 0){
                backBtn.setEnabled(false);
                backBtn.setVisibility(View.INVISIBLE);
                nextBtn.setEnabled(true);

                //Set text on the button if condition is satisfied
                backBtn.setText("");
                nextBtn.setText("NEXT");

            }
            else if(i == slider_dots.length - 1){
                backBtn.setEnabled(true);
                backBtn.setVisibility(View.VISIBLE);

                nextBtn.setEnabled(true);

                nextBtn.setText("Finish");
                backBtn.setText("Back");

            }

            else{
                backBtn.setEnabled(true);
                backBtn.setVisibility(View.VISIBLE);
                nextBtn.setEnabled(true);

                nextBtn.setText("Next");
                backBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
