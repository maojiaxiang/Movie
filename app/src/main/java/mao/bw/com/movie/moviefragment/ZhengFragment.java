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
import mao.bw.com.movie.adapter.BeingAdapter;
import mao.bw.com.movie.bean.BeingBean;
import mao.bw.com.movie.core.DataCall;
import mao.bw.com.movie.presenter.BeingPresenter;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/11 21:35:52
 * @Description: 描述信息
 */
public class ZhengFragment extends Fragment implements DataCall<List<BeingBean>> {
    private RecyclerView recyclerView;
    private BeingPresenter beingPresenter;
    private BeingAdapter beingAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhangzai_item, container, false);
        recyclerView = view.findViewById(R.id.zhengzai_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        beingPresenter = new BeingPresenter(this);
        beingPresenter.requestData();
        beingAdapter = new BeingAdapter(getActivity());
        recyclerView.setAdapter(beingAdapter);
        return view;
    }

    @Override
    public void onSuccess(List<BeingBean> result, Object... args) {
        beingAdapter.allAdd(result);
        beingAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail(Result result, Object... args) {

    }
}
