package com.jaylm.mycar.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

import java.util.List;

/**
 * Created by jaylm
 * on 2018/10/16.
 */
public class NewsBean{

    /**
     * id : 819350038517669888
     * hot_at : 1539670977494
     * item_type : NEWS
     * item_id : 259796453
     * layout : NORMAL
     * published_at : 1539670977000
     * media_name : 远光灯
     * title : 新西兰航空与拉里-佩奇投资公司合作 推电动飞行汽车
     * cover : http://5b0988e595225.cdn.sohucs.com/a_auto,c_cut,x_0,y_5,w_1500,h_1000/images/20181016/245897d2262a400883040ce213c32d4f.jpeg
     * images : [{"src":"http://5b0988e595225.cdn.sohucs.com/images/20181016/471eab5d8a0a451b8574d1d88b05c99c.jpeg","small":"http://5b0988e595225.cdn.sohucs.com/c_fill,w_450,h_300,g_faces/images/20181016/471eab5d8a0a451b8574d1d88b05c99c.jpeg","width":1500,"height":1011}]
     * comment_count : 0
     * video_id : null
     * duration : null
     * video_site : null
     * play_count : null
     * media_id : null
     * media_avatar : null
     * media_intro : null
     * content : null
     * like_count : null
     * liked : false
     * followed : false
     * album_type : null
     * pic_count : null
     * item_id_str : 259796453
     */

    private String id;
    private long hot_at;
    private String item_type;
    private int item_id;
    private String layout;
    private long published_at;
    private String media_name;
    private String title;
    private String cover;
    private int comment_count;
    private Object video_id;
    private Object duration;
    private Object video_site;
    private Object play_count;
    private Object media_id;
    private Object media_avatar;
    private Object media_intro;
    private Object content;
    private Object like_count;
    private boolean liked;
    private boolean followed;
    private Object album_type;
    private Object pic_count;
    private String item_id_str;
    private List<ImagesBean> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getHot_at() {
        return hot_at;
    }

    public void setHot_at(long hot_at) {
        this.hot_at = hot_at;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public long getPublished_at() {
        return published_at;
    }

    public void setPublished_at(long published_at) {
        this.published_at = published_at;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public Object getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Object video_id) {
        this.video_id = video_id;
    }

    public Object getDuration() {
        return duration;
    }

    public void setDuration(Object duration) {
        this.duration = duration;
    }

    public Object getVideo_site() {
        return video_site;
    }

    public void setVideo_site(Object video_site) {
        this.video_site = video_site;
    }

    public Object getPlay_count() {
        return play_count;
    }

    public void setPlay_count(Object play_count) {
        this.play_count = play_count;
    }

    public Object getMedia_id() {
        return media_id;
    }

    public void setMedia_id(Object media_id) {
        this.media_id = media_id;
    }

    public Object getMedia_avatar() {
        return media_avatar;
    }

    public void setMedia_avatar(Object media_avatar) {
        this.media_avatar = media_avatar;
    }

    public Object getMedia_intro() {
        return media_intro;
    }

    public void setMedia_intro(Object media_intro) {
        this.media_intro = media_intro;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Object getLike_count() {
        return like_count;
    }

    public void setLike_count(Object like_count) {
        this.like_count = like_count;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public Object getAlbum_type() {
        return album_type;
    }

    public void setAlbum_type(Object album_type) {
        this.album_type = album_type;
    }

    public Object getPic_count() {
        return pic_count;
    }

    public void setPic_count(Object pic_count) {
        this.pic_count = pic_count;
    }

    public String getItem_id_str() {
        return item_id_str;
    }

    public void setItem_id_str(String item_id_str) {
        this.item_id_str = item_id_str;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class ImagesBean {
        /**
         * src : http://5b0988e595225.cdn.sohucs.com/images/20181016/471eab5d8a0a451b8574d1d88b05c99c.jpeg
         * small : http://5b0988e595225.cdn.sohucs.com/c_fill,w_450,h_300,g_faces/images/20181016/471eab5d8a0a451b8574d1d88b05c99c.jpeg
         * width : 1500
         * height : 1011
         */

        private String src;
        private String small;
        private int width;
        private int height;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
