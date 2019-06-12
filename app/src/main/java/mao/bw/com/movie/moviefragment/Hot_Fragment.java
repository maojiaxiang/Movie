package mao.bw.com.movie.moviefragment;

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
import mao.bw.com.movie.adapter.RemenAdapter;
import mao.bw.com.movie.bean.MovieBean;
import mao.bw.com.movie.core.DataCall;
import mao.bw.com.movie.presenter.MoviePresenter;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/11 21:35:07
 * @Description: 描述信息
 */
public class Hot_Fragment extends Fragment implements DataCall<List<MovieBean>> {
    private ImageView imageView;
    private RecyclerView recyclerView;
    private MoviePresenter moviePresenter;
    private RemenAdapter remenAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_item, container, false);
        recyclerView = view.findViewById(R.id.hot_recyclerView);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        moviePresenter = new MoviePresenter(this);
        imageView = view.findViewById(R.id.image);
        moviePresenter.requestData();
        remenAdapter = new RemenAdapter(getActivity());
        recyclerView.setAdapter(remenAdapter);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }

    @Override
    public void onSuccess(List<MovieBean> result, Object... args) {
        remenAdapter.allAdd(result);
        remenAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail(Result result, Object... args) {

    }
}
