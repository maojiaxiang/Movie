package mao.bw.com.movie.fragmentcinema;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import javax.xml.transform.Result;

import mao.bw.com.movie.R;
import mao.bw.com.movie.adapter.NearbyAdapter;
import mao.bw.com.movie.adapter.RecomAdapter;
import mao.bw.com.movie.bean.cinema.FuJinBean;
import mao.bw.com.movie.bean.cinema.TuiJianBean;
import mao.bw.com.movie.core.DataCall;
import mao.bw.com.movie.presenter.NearbyPresenter;
import mao.bw.com.movie.presenter.RecomPresenter;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/12 16:19
 * @Description：描述信息
 */
public class Fragment_Recom extends Fragment implements DataCall<List<TuiJianBean>> {
    private XRecyclerView recyclerView;
    private RecomPresenter recomPresenter;
    private RecomAdapter recomAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recom_item, null, false);
        recyclerView = view.findViewById(R.id.recycle_recom);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        // 可以设置是否开启加载更多/下拉刷新
        recyclerView.setLoadingMoreEnabled(true);
        // 如果设置上这个，下拉刷新的时候会显示上次刷新的时间
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.refreshComplete();
                        recomAdapter.notifyDataSetChanged();
                    }
                }, 2000);

            }
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.loadMoreComplete();
                        recomAdapter.notifyDataSetChanged();
                    }
                }, 2000);

            }
        });
        recomPresenter = new RecomPresenter(this);
        recomPresenter.requestData();
        recomAdapter = new RecomAdapter(getActivity());
        recyclerView.setAdapter(recomAdapter);

        return view;
    }

    @Override
    public void onSuccess(List<TuiJianBean> result, Object... args) {
        recomAdapter.allAdd(result);
        recomAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail(Result result, Object... args) {

    }
}
