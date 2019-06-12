package mao.bw.com.movie.model;

import java.util.List;

import io.reactivex.Observable;
import mao.bw.com.movie.bean.AboutBean;
import mao.bw.com.movie.bean.BeingBean;
import mao.bw.com.movie.bean.MovieBean;
import mao.bw.com.movie.bean.Result;
import retrofit2.http.GET;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/9 21:57:02
 * @Description: 描述信息
 */
public interface IRequest {
    //热门影院
    @GET("findHotMovieList?page=1&count=10")
    Observable<Result<List<MovieBean>>>findHotMovieList();
    //正在上映
    @GET("findReleaseMovieList?page=1&count=5")
    Observable<Result<List<BeingBean>>>findReleaseMovieList();
    //即将上映
    @GET("findComingSoonMovieList?page=1&count=5")
    Observable<Result<List<AboutBean>>>findComingSoonMovieList();
}
