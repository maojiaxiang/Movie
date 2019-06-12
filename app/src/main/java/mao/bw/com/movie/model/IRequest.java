package mao.bw.com.movie.model;

import java.util.List;

import io.reactivex.Observable;
import mao.bw.com.movie.bean.Login.LoginBean;
import mao.bw.com.movie.bean.cinema.FuJinBean;
import mao.bw.com.movie.bean.movie.MovieBean;
import mao.bw.com.movie.bean.Login.RegistBean;
import mao.bw.com.movie.bean.Result;
import mao.bw.com.movie.bean.cinema.TuiJianBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/9 21:57:02
 * @Description: 描述信息
 */
public interface IRequest {
    //登录
    @FormUrlEncoded
    @POST("movieApi/user/v1/login")
    Observable<Result<LoginBean>> login(@Field("phone")String phone,@Field("pwd")String pwd);
    //注册
    @FormUrlEncoded
    @POST("movieApi/user/v1/registerUser")
    Observable<Result<RegistBean>> register(@Field("nickName") String nickName,
                                            @Field("sex")String sex,
                                            @Field("birthday")String birthday,
                                            @Field("phone")String phone,
                                            @Field("email")String email,
                                            @Field("pwd")String pwd,
                                            @Field("pwd2")String pwd2);


    @GET("movieApi/movie/v1/findHotMovieList?page=1&count=10")
    Observable<Result<List<MovieBean>>>findHotMovieList();
    //推荐影院
    @GET("movieApi/cinema/v1/findRecommendCinemas?page=1&count=10")
    Observable<Result<List<TuiJianBean>>>findRecommendCinemas();

    //附近影院
    @GET("movieApi/cinema/v1/findNearbyCinemas?page=1&count=10")
    Observable<Result<List<FuJinBean>>>findNearbyCinemas();
}
