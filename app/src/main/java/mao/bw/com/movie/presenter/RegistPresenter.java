package mao.bw.com.movie.presenter;

import io.reactivex.Observable;
import mao.bw.com.movie.activity.RegisterActivity;
import mao.bw.com.movie.base.BaseLoginPresenter;
import mao.bw.com.movie.core.DataCalls;
import mao.bw.com.movie.model.IRequest;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/11 17:38
 * @Description：描述信息
 */
public class RegistPresenter extends BaseLoginPresenter {
    public RegistPresenter(RegisterActivity dataCalls) {
        super(dataCalls);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.register((String)args[0],(String)args[1],(String)args[2],
                (String)args[3],(String)args[4],(String)args[5],(String)args[6]);
    }
}
