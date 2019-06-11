package mao.bw.com.movie.presenter;

import io.reactivex.Observable;
import mao.bw.com.movie.base.BaseMoviePresenter;
import mao.bw.com.movie.core.DataCall;
import mao.bw.com.movie.model.IRequest;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/10 13:09:12
 * @Description: 描述信息
 */
public class MoviePresenter extends BaseMoviePresenter {
    public MoviePresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.findHotMovieList();
    }

}
