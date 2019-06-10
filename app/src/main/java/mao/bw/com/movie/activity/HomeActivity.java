package mao.bw.com.movie.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;

import mao.bw.com.movie.R;
import mao.bw.com.movie.fragment.Fragment_One;
import mao.bw.com.movie.fragment.Fragment_Three;
import mao.bw.com.movie.fragment.Fragment_Two;

public class HomeActivity extends AppCompatActivity {

    private BottomTabBar bottom_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottom_tab = findViewById(R.id.bottom_tab);
        bottom_tab.init(getSupportFragmentManager())
                .setFontSize(8)
                .setChangeColor(Color.RED,Color.BLACK)
                .setTabPadding(6,8,10)
                .setImgSize(50,50)
                .addTabItem("首页",R.drawable.ying1,Fragment_One.class)
                .addTabItem("影院",R.drawable.yy1,Fragment_Two.class)
                .addTabItem("我的",R.drawable.wd1,Fragment_Three.class)
                .isShowDivider(false);
    }
}
