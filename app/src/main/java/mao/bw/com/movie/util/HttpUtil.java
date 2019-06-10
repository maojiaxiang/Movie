package mao.bw.com.movie.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/5/30 14:25:19
 * @Description: 工具类s
 */
public class HttpUtil {
    private static HttpUtil instance;
    private Retrofit retrofit;

    public static HttpUtil getInstance(){
        if (instance==null){
            instance = new HttpUtil();
        }
        return instance;
    }

    private HttpUtil(){
        OkHttpClient okHttpClient =new OkHttpClient.Builder()
                .writeTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .connectTimeout(60,TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://172.17.8.100/movieApi/movie/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
    }
    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
