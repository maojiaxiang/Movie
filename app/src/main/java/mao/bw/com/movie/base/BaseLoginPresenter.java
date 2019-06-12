package mao.bw.com.movie.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import mao.bw.com.movie.bean.Result;
import mao.bw.com.movie.core.DataCalls;
import mao.bw.com.movie.model.IRequest;
import mao.bw.com.movie.util.HttpUtil;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/11 17:36
 * @Description：描述信息
 */
public abstract class BaseLoginPresenter {
    private DataCalls dataCalls;

    public BaseLoginPresenter(DataCalls dataCalls) {
        this.dataCalls = dataCalls;
    }
    public void requestData(Object...args){
        IRequest iRequest = HttpUtil.getInstance().create(IRequest.class);
        getModel(iRequest,args)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Function<Throwable,Result>() {
                    @Override
                    public Result apply(Throwable o) throws Exception {
                        o.printStackTrace();
                        return new Result(o.getMessage());
                    }
                })
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result o) throws Exception {
                        if ("0000".equals(o.status)){
                            dataCalls.onSuccess(o.result);
                        }
                    }
                });
    }
    protected abstract Observable getModel(IRequest iRequest, Object...args);
}
