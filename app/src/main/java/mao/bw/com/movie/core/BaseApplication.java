package mao.bw.com.movie.core;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/12 15:15:30
 * @Description: 描述信息
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
