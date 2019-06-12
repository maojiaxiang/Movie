package mao.bw.com.movie.presenter;

import io.reactivex.Observable;
import mao.bw.com.movie.base.BaseMoviePresenter;
import mao.bw.com.movie.core.DataCall;
import mao.bw.com.movie.model.IRequest;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/12 14:32
 * @Description：描述信息
 */
public class RecomPresenter extends BaseMoviePresenter {
    public RecomPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.findRecommendCinemas();
    }
}
