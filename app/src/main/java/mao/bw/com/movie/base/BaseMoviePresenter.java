package mao.bw.com.movie.base;

import org.greenrobot.greendao.annotation.Id;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import mao.bw.com.movie.bean.Result;
import mao.bw.com.movie.core.DataCall;
import mao.bw.com.movie.model.IRequest;
import mao.bw.com.movie.util.HttpUtil;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/10 09:30:08
 * @Description: 描述信息
 */
public abstract class BaseMoviePresenter {
    private DataCall dataCall;

    public BaseMoviePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }
    public void requestData(Object...args){
        IRequest iRequest = HttpUtil.getInstance().create(IRequest.class);
        getModel(iRequest,args)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Function<Throwable,Result>() {
                    @Override
                    public Result apply(Throwable object) throws Exception {
                        object.printStackTrace();
                        return new Result(object.getMessage());
                    }
                })
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result o) throws Exception {
                        if ("0000".equals(o.status)){
                            dataCall.onSuccess(o.result);
                        }else {
                        }
                    }
                });
    }

    protected abstract Observable getModel(IRequest iRequest,Object...args);

}
