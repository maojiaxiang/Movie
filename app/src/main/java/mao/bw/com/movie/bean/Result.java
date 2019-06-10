package mao.bw.com.movie.bean;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/9 21:58:53
 * @Description: 描述信息
 */
public class Result<T> {
   /* "message": "查询成功",
            "status": "0000"*/
   public String message="请求失败";
   public String status="-1";
   public T result;

    public Result(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public Result() {
    }
}
