package mao.bw.com.movie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import javax.xml.transform.Result;

import mao.bw.com.movie.R;
import mao.bw.com.movie.activity.MovieActivity;
import mao.bw.com.movie.adapter.HotMovieAdapter;
import mao.bw.com.movie.adapter.MovieAdapter;
import mao.bw.com.movie.bean.MovieBean;
import mao.bw.com.movie.core.DataCall;
import mao.bw.com.movie.presenter.MoviePresenter;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/9 20:40:17
 * @Description: 描述信息
 */
public class Fragment_One extends Fragment implements DataCall<List<MovieBean>> {
    private RecyclerCoverFlow recyclerCoverFlow;
    private MovieAdapter movieAdapter;
    private MoviePresenter moviePresenter;
    private RecyclerView recyclerView1;
    private HotMovieAdapter hotMovieAdapter;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private ImageView btn_img1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        recyclerCoverFlow = view.findViewById(R.id.recycle_view);
        btn_img1 = view.findViewById(R.id.btn_img);
        btn_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),MovieActivity.class);
                startActivity(intent);

            }
        });
        recyclerCoverFlow.setAlphaItem(true); //平面滚动
        movieAdapter = new MovieAdapter(getActivity());
        moviePresenter = new MoviePresenter(this);
        hotMovieAdapter = new HotMovieAdapter(getActivity());
        moviePresenter.requestData();
        recyclerCoverFlow.setAdapter(movieAdapter);
        recyclerView1 = view.findViewById(R.id.recycle_view1);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(hotMovieAdapter);


        LinearLayoutManager linearLayoutManager1 =new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView2 = view.findViewById(R.id.recycle_view2);
        recyclerView2.setLayoutManager(linearLayoutManager1);
        recyclerView2.setAdapter(hotMovieAdapter);


        LinearLayoutManager linearLayoutManager2 =new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView3 = view.findViewById(R.id.recycle_view3);
        recyclerView3.setLayoutManager(linearLayoutManager2);
        recyclerView3.setAdapter(hotMovieAdapter);
        return view;
    }

    @Override
    public void onSuccess(List<MovieBean> result, Object... args) {
        movieAdapter.addAll(result);
        hotMovieAdapter.addAll(result);
        hotMovieAdapter.notifyDataSetChanged();
        movieAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail(Result result, Object... args) {

    }

}
