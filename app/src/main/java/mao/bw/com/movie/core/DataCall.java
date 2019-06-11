package mao.bw.com.movie.core;

import javax.xml.transform.Result;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/9 21:54:22
 * @Description: 描述信息
 */
public interface DataCall<T> {
    void onSuccess(T result,Object...args);
    void fail(Result result,Object...args);
}
