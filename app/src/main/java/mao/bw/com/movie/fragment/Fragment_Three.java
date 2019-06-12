package mao.bw.com.movie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;

import mao.bw.com.movie.R;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/9 20:40:17
 * @Description: 描述信息
 */
public class Fragment_Three extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        return view;
    }
}
