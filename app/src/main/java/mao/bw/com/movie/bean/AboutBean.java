package mao.bw.com.movie.bean;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/12 14:22:52
 * @Description: 描述信息
 */
public class AboutBean {
    /*	"followMovie": 2,
                "id": 16,
                "imageUrl": "http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg",
                "name": "碟中谍6：全面瓦解",
                "rank": 0,
                "releaseTime": 1569081600000,
                "releaseTimeShow": "2019-09-22",
                "summary": "有时好意会造成恶果，人反而被自己所造成的结果所困扰。伊桑·亨特（汤姆·克鲁斯 饰）和他的IMF团队（亚历克·鲍德温、西蒙·佩吉、文·瑞姆斯）将在最新的电影《碟中谍6：全面瓦解》中再度回归，他们会与观众们熟悉的盟友（丽贝卡·弗格森、米歇尔·莫娜汉）一起与时间赛跑，应对一次任务中出现的意外。亨利·卡维尔、安吉拉·贝塞特和凡妮莎·柯比也将加入本片的演员阵容，电影制片人克里斯托夫·迈考利将会再度担任导演。",
                "type": 2*/
    private String followMovie;
    private String id;
    private String imageUrl;
    private String name;
    private String rank;
    private String releaseTime;
    private String releaseTimeShow;
    private String summary;
    private String type;

    public String getFollowMovie() {
        return followMovie;
    }

    public void setFollowMovie(String followMovie) {
        this.followMovie = followMovie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getReleaseTimeShow() {
        return releaseTimeShow;
    }

    public void setReleaseTimeShow(String releaseTimeShow) {
        this.releaseTimeShow = releaseTimeShow;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
