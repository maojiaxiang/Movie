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

    private FrameLayout frameLayout;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        frameLayout = findViewById(R.id.fram_layout);
        radioGroup = findViewById(R.id.home_group);
        //默认显示第一页
        getSupportFragmentManager().beginTransaction().replace(R.id.fram_layout,new Fragment_One()).commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.home1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram_layout,new Fragment_One()).commit();
                        break;
                    case R.id.home2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram_layout,new Fragment_Two()).commit();
                        break;
                    case R.id.home3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fram_layout,new Fragment_Three()).commit();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
