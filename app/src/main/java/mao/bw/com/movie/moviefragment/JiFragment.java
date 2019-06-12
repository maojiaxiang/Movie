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

import java.util.List;

import javax.xml.transform.Result;

import mao.bw.com.movie.R;
import mao.bw.com.movie.adapter.AboutAdapter;
import mao.bw.com.movie.bean.AboutBean;
import mao.bw.com.movie.core.DataCall;
import mao.bw.com.movie.presenter.AboutPresenter;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/11 21:36:21
 * @Description: 描述信息
 */
public class JiFragment extends Fragment implements DataCall<List<AboutBean>> {
    private RecyclerView recyclerView;
    private AboutPresenter aboutPresenter;
    private AboutAdapter aboutAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ji_item, container, false);
        recyclerView = view.findViewById(R.id.jijiang_recyclerView);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        aboutPresenter = new AboutPresenter(this);
        aboutPresenter.requestData();
        aboutAdapter = new AboutAdapter(getActivity());
        recyclerView.setAdapter(aboutAdapter);
        return view;
    }

    @Override
    public void onSuccess(List<AboutBean> result, Object... args) {
        aboutAdapter.allAdd(result);
        aboutAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail(Result result, Object... args) {

    }
}
