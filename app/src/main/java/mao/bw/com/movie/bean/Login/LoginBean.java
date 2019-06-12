package mao.bw.com.movie.bean.Login;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/11 17:10
 * @Description：描述信息
 */
public class LoginBean {
    private String sessionId;
    private String userId;
    private UserInfo userInfo;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
