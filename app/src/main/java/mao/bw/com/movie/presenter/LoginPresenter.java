package mao.bw.com.movie.presenter;

import io.reactivex.Observable;
import mao.bw.com.movie.base.BaseLoginPresenter;
import mao.bw.com.movie.core.DataCalls;
import mao.bw.com.movie.model.IRequest;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/11 17:36
 * @Description：描述信息
 */
public class LoginPresenter extends BaseLoginPresenter {
    public LoginPresenter(DataCalls dataCalls) {
        super(dataCalls);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.login((String)args[0],(String)args[1]);

    }
}
