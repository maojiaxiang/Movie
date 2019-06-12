package mao.bw.com.movie.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import mao.bw.com.movie.R;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/11 21:19
 * @Description：描述信息
 */
public class CustomSearch extends LinearLayout {

    public CustomSearch(Context context) {
        this(context, null);
    }

    public CustomSearch(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomSearch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.search, null, false);
        addView(view);
    }


}
