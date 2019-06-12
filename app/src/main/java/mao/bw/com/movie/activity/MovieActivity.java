package mao.bw.com.movie.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import mao.bw.com.movie.R;
import mao.bw.com.movie.moviefragment.Hot_Fragment;
import mao.bw.com.movie.moviefragment.JiFragment;
import mao.bw.com.movie.moviefragment.ZhengFragment;

public class MovieActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private RadioGroup home_group;
    List<Fragment> list =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        viewPager =findViewById(R.id.ViewPage);
        home_group=findViewById(R.id.home_group);
        viewPager.setOffscreenPageLimit(3);
        list.add(new Hot_Fragment());
        list.add(new JiFragment());
        list.add(new ZhengFragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        home_group.check(R.id.home1);
                        break;
                    case 1:
                        home_group.check(R.id.home2);
                        break;
                    case 2:
                        home_group.check(R.id.home3);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        home_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.home1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.home2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.home3:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
