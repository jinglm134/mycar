package com.jaylm.mycar.bean.host;

import java.util.List;

/**
 * Created by jaylm
 * on 2018/10/17.
 */
public class NewsDetailBean {

    /**
     * news_id : 260001083
     * mp_news_id : 260001083
     * author : 狐che
     * author_id : null
     * category_id : null
     * category_name : null
     * content : <!--VIDEO#0-->
     * <p>宝马 X7 量产版将于今年 11 月开幕的 2018 洛杉矶车展首发。X7 定位全尺寸 SUV，将成为宝马未来体型最大的 SUV，竞争对手为奔驰 GLS 和路虎揽胜等车型。X7 全球生产基地位于美国南卡罗来纳州的宝马斯巴腾堡工厂。</p>
     * <p class="ql-align-center">
     * <!--IMG#0--></p>
     * <p>宝马 X7 的双肾式前格栅相比现有的宝马车型而言尺寸更大，中央的连接处也更显紧密，同时，新车细长的大灯组与格栅相接，内部配有激光大灯，以及比例更加扁平的家族式 " 勺子形 "LED 日行灯。而在保险杠部分，该车采用了巨大的贯穿式 U 形下部进气口，整体造型极具个性。</p>
     * <p class="ql-align-center">
     * <!--IMG#1--></p>
     * <p class="ql-align-center">
     * <!--IMG#2--></p>
     * <p>宝马 X7 量产版的车身线条非常硬朗，笔直的腰线从前轮轮拱一直延伸至尾灯，前翼子板处配备 L 型通风口，配合大尺寸多辐式镀铬轮毂，令新车显得更加野性。此前概念版配备了隐藏式车门把手并没出现，但整车的侧面依然符合宝马家族式的动感风格。</p>
     * <p class="ql-align-center">
     * <!--IMG#3--></p>
     * <p class="ql-align-center">
     * <!--IMG#4--></p>
     * <p class="ql-align-center">
     * <!--IMG#5--></p>
     * <p>动力方面，新车预计至少会推出三种动力版本，其中 X7 xDrive 40i 搭载 3.0T L6 双涡轮增压发动机，最大功率 250kW（340PS），峰值扭矩为 450N · m；而 X7 xDrive 50i 则搭载 4.4T V8 双涡轮增压发动机，最大功率 332kW（451PS），峰值扭矩 648N · m。此外，预计未来还会推出插电混动车型</p>
     * <p>（内容转载自网络）</p>
     * title : 全尺寸巨兽 宝马X7量产版即将登场
     * favorite_count : 0
     * published_at : 1539748666000
     * url : http://mobile.auto.sohu.com/m/article.html?pvid=3a89a4b3#260001083
     * cover : http://5b0988e595225.cdn.sohucs.com/a_auto,c_cut,x_22,y_0,w_870,h_580/images/20181017/4a78ddb3e70045b0bf54e2be1d3b80b9.png
     * img : [{"alt":"","height":0,"width":0,"src":"http://5b0988e595225.cdn.sohucs.com/images/20181017/4936a69c6aa64173897ecee084b4b27b.png","small":null},{"alt":"","height":0,"width":0,"src":"http://5b0988e595225.cdn.sohucs.com/images/20181017/0deb325b92a642b184ef5eea6b45cfe4.png","small":null},{"alt":"","height":0,"width":0,"src":"http://5b0988e595225.cdn.sohucs.com/images/20181017/c1c397faf1e6490ab6c0a63c1b0c6ce8.png","small":null},{"alt":"","height":0,"width":0,"src":"http://5b0988e595225.cdn.sohucs.com/images/20181017/7d4bf98a4cad448084e7a5051dd9ea49.png","small":null},{"alt":"","height":0,"width":0,"src":"http://5b0988e595225.cdn.sohucs.com/images/20181017/cc56773d8c0e412988459a534bb58d90.png","small":null},{"alt":"","height":0,"width":0,"src":"http://5b0988e595225.cdn.sohucs.com/images/20181017/b5818b2a8e5540efac2af9834222528f.png","small":null}]
     * video : [{"video_id":107254269,"video_site":2,"source":null}]
     * mp_author : {"id":null,"nickname":"狐che","avatar":"http://sucimg.itc.cn/avatarimg/28689b5106e44db29bccea36c0cca1d9_1469415382057","cert":null,"desc":null,"followed":false}
     */

    private int news_id;
    private int mp_news_id;
    private String author;
    private Object author_id;
    private Object category_id;
    private Object category_name;
    private String content;
    private String title;
    private int favorite_count;
    private long published_at;
    private String url;
    private String cover;
    private MpAuthorBean mp_author;
    private List<ImgBean> img;
    private List<VideoBean> video;

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public int getMp_news_id() {
        return mp_news_id;
    }

    public void setMp_news_id(int mp_news_id) {
        this.mp_news_id = mp_news_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Object getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Object author_id) {
        this.author_id = author_id;
    }

    public Object getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Object category_id) {
        this.category_id = category_id;
    }

    public Object getCategory_name() {
        return category_name;
    }

    public void setCategory_name(Object category_name) {
        this.category_name = category_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public long getPublished_at() {
        return published_at;
    }

    public void setPublished_at(long published_at) {
        this.published_at = published_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public MpAuthorBean getMp_author() {
        return mp_author;
    }

    public void setMp_author(MpAuthorBean mp_author) {
        this.mp_author = mp_author;
    }

    public List<ImgBean> getImg() {
        return img;
    }

    public void setImg(List<ImgBean> img) {
        this.img = img;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class MpAuthorBean {
        /**
         * id : null
         * nickname : 狐che
         * avatar : http://sucimg.itc.cn/avatarimg/28689b5106e44db29bccea36c0cca1d9_1469415382057
         * cert : null
         * desc : null
         * followed : false
         */

        private Object id;
        private String nickname;
        private String avatar;
        private Object cert;
        private Object desc;
        private boolean followed;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Object getCert() {
            return cert;
        }

        public void setCert(Object cert) {
            this.cert = cert;
        }

        public Object getDesc() {
            return desc;
        }

        public void setDesc(Object desc) {
            this.desc = desc;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }
    }

    public static class ImgBean {
        /**
         * alt :
         * height : 0
         * width : 0
         * src : http://5b0988e595225.cdn.sohucs.com/images/20181017/4936a69c6aa64173897ecee084b4b27b.png
         * small : null
         */

        private String alt;
        private int height;
        private int width;
        private String src;
        private Object small;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public Object getSmall() {
            return small;
        }

        public void setSmall(Object small) {
            this.small = small;
        }
    }

    public static class VideoBean {
        /**
         * video_id : 107254269
         * video_site : 2
         * source : null
         */

        private int video_id;
        private int video_site;
        private Object source;

        public int getVideo_id() {
            return video_id;
        }

        public void setVideo_id(int video_id) {
            this.video_id = video_id;
        }

        public int getVideo_site() {
            return video_site;
        }

        public void setVideo_site(int video_site) {
            this.video_site = video_site;
        }

        public Object getSource() {
            return source;
        }

        public void setSource(Object source) {
            this.source = source;
        }
    }
}
