package mao.bw.com.movie.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mao.bw.com.movie.R;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/9 20:40:17
 * @Description: 描述信息
 */
public class Fragment_One extends Fragment {
    private RecyclerCoverFlow mList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        mList = view.findViewById(R.id.list);
        mList.setAlphaItem(true); //平面滚动

        return view;
    }
}
