package mao.bw.com.movie.bean;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/10 09:28:03
 * @Description: 描述信息
 */
public class MovieBean {
   /* "followMovie": 2,
            "id": 20,
            "imageUrl": "http://172.17.8.100/images/movie/stills/ws/ws1.jpg",
            "name": "无双",
            "rank": 1,
            "summary": "以代号“画家”（周润发 饰）为首的犯罪团伙，掌握了制造伪钞技术，难辨真伪，并在全球进行交易获取利益，引起警方高度重视。然而“画家”和其他成员的身份一直成谜，警方的破案进度遭受到了前所未有的挑战。在关键时刻，擅长绘画的李问（郭富城 饰）打开了破案的突破口，而“画家”的真实身份却让众人意想不到……",
            "type": 1*/
    private String followMovie;
    private String id;
    private String imageUrl;
    private String name;
    private String rank;
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
