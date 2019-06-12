package mao.bw.com.movie.presenter;

import io.reactivex.Observable;
import mao.bw.com.movie.base.BaseMoviePresenter;
import mao.bw.com.movie.core.DataCall;
import mao.bw.com.movie.model.IRequest;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/12 17:27
 * @Description：描述信息
 */
public class NearbyPresenter extends BaseMoviePresenter {
    public NearbyPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.findNearbyCinemas();
    }
}
