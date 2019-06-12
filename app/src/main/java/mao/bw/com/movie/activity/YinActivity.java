package mao.bw.com.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import mao.bw.com.movie.R;

public class YinActivity extends AppCompatActivity {

    private SharedPreferences.Editor edit;
    private SharedPreferences sp;
    private ViewPager pager;
    private RadioGroup radio;
    private View view4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin);
        pager = findViewById(R.id.pager);
        radio = findViewById(R.id.radio);
        sp = getSharedPreferences("ydy", Context.MODE_PRIVATE);
        if(sp.getBoolean("第一次",false)){
            Intent intent = new Intent(YinActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        edit = sp.edit();
        edit.putBoolean("第一次",true);
        edit.commit();
        radio.check(radio.getChildAt(0).getId());
        final ArrayList<View> list = new ArrayList<>();

        View view1 = View.inflate(this,R.layout.yindaoye1,null);
        list.add(view1);
        View view2 = View.inflate(this,R.layout.yindaoye2,null);
        list.add(view2);
        View view3 = View.inflate(this,R.layout.yindaoye3,null);
        list.add(view3);
        view4 = View.inflate(this,R.layout.yindaoye4,null);
        list.add(view4);
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YinActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }


            @Override
            public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
                return arg0 == arg1;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view = list.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radio.check(radio.getChildAt(i).getId());
                if(i == list.size()-0){
                    Intent intent = new Intent(YinActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
