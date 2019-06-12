package mao.bw.com.movie.fragment;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mao.bw.com.movie.R;
import mao.bw.com.movie.fragmentcinema.Fragment_Nearby;
import mao.bw.com.movie.fragmentcinema.Fragment_Recom;
import mao.bw.com.movie.view.CustomSearch;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/9 20:40:17
 * @Description: 描述信息
 */
public class Fragment_Two extends Fragment {
    private RadioGroup radioGroup;
    private ViewPager viewPager;
    List<Fragment> list = new ArrayList<>();
    private boolean netConnect;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        radioGroup = view.findViewById(R.id.radioGroup);
        viewPager = view.findViewById(R.id.viewPagwe);
        list.add(new Fragment_Nearby());
        list.add(new Fragment_Recom());

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置viewpage缓存界面数
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
                        radioGroup.check(R.id.bt1);
                        break;
                    case 1:
                        radioGroup.check(R.id.bt2);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt1:
                        viewPager.setCurrentItem(0);

                        break;
                    case R.id.bt2:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });

    }
}
