package mao.bw.com.movie.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mao.bw.com.movie.R;
import mao.bw.com.movie.fragment.Fragment_One;
import mao.bw.com.movie.fragment.Fragment_Three;
import mao.bw.com.movie.fragment.Fragment_Two;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.home_group)
    RadioGroup radiogroup;
    List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        list.add(new Fragment_One());
        list.add(new Fragment_Two());
        list.add(new Fragment_Three());
        //设置viewpage缓存界面数
        viewpager.setOffscreenPageLimit(3);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        radiogroup.check(R.id.home1);
                        break;
                    case 1:
                        radiogroup.check(R.id.home2);
                        break;
                    case 2:
                        radiogroup.check(R.id.home3);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.home1:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.home2:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.home3:
                        viewpager.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
