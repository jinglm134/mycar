package com.jaylm.mycar.bean.exam;

import android.os.Parcel;
import android.os.Parcelable;

import com.jaylm.mycar.bean.BaseBean;

import java.util.List;

/**
 * Created by jaylm
 * on 2018/10/10.
 */
public class LearnListBean extends BaseBean implements Parcelable{

    /**
     * icon : https://img.58cdn.com.cn/dist/logo/jxedt/chap1.png
     * playCount : 33.1W
     * videos : [{"topicid":"938029173056382902","title":"驾驶证的申领","duration":"455","likeNum":"6366","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/驾驶证的申领1.mp4","md5":"8de685154341de248367f1a2a7e5240b","isliked":0,"view":"11.7W","size":"39.5","imageBig":"http://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/jsz_1.png"},{"topicid":"938029173056026718","title":"驾驶证的使用","duration":"673","likeNum":"6280","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/驾驶证的使用2.mp4","md5":"ef695b462dc0bf9a1b63ffa795899f70","isliked":0,"view":"7.9W","size":"52","imageBig":"http://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/jsz_2.png"},{"topicid":"938029173056992861","title":"驾驶证考试","duration":"187","likeNum":"5408","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/驾驶证考试3.mp4","md5":"2f2fa10e8372cb4b58bf2f1885846aca","isliked":0,"view":"8.1W","size":"22","imageBig":"http://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/jsz_3.png"},{"topicid":"938029173056027189","title":"机动车登记、检验与保险","duration":"263","likeNum":"4715","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/机动车登记、检验与保险4.mp4","md5":"6c3b9e8d5a4d18b6dbbcb4d6f388b303","isliked":0,"view":"5.4W","size":"31","imageBig":"http://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/jsz_4.png"}]
     * chapterName : 驾驶证申领与使用
     */

    private String icon;
    private String playCount;
    private String chapterName;
    private List<VideosBean> videos;

    protected LearnListBean(Parcel in) {
        icon = in.readString();
        playCount = in.readString();
        chapterName = in.readString();
        videos = in.createTypedArrayList(VideosBean.CREATOR);
    }

    public static final Creator<LearnListBean> CREATOR = new Creator<LearnListBean>() {
        @Override
        public LearnListBean createFromParcel(Parcel in) {
            return new LearnListBean(in);
        }

        @Override
        public LearnListBean[] newArray(int size) {
            return new LearnListBean[size];
        }
    };

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public List<VideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosBean> videos) {
        this.videos = videos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(icon);
        dest.writeString(playCount);
        dest.writeString(chapterName);
        dest.writeTypedList(videos);
    }

    public static class VideosBean implements Parcelable {
        /**
         * topicid : 938029173056382902
         * title : 驾驶证的申领
         * duration : 455
         * likeNum : 6366
         * playurl : https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/驾驶证的申领1.mp4
         * md5 : 8de685154341de248367f1a2a7e5240b
         * isliked : 0
         * view : 11.7W
         * size : 39.5
         * imageBig : http://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/jsz_1.png
         */

        private String topicid;
        private String title;
        private String duration;
        private String likeNum;
        private String playurl;
        private String md5;
        private int isliked;
        private String view;
        private String size;
        private String imageBig;

        protected VideosBean(Parcel in) {
            topicid = in.readString();
            title = in.readString();
            duration = in.readString();
            likeNum = in.readString();
            playurl = in.readString();
            md5 = in.readString();
            isliked = in.readInt();
            view = in.readString();
            size = in.readString();
            imageBig = in.readString();
        }

        public static final Creator<VideosBean> CREATOR = new Creator<VideosBean>() {
            @Override
            public VideosBean createFromParcel(Parcel in) {
                return new VideosBean(in);
            }

            @Override
            public VideosBean[] newArray(int size) {
                return new VideosBean[size];
            }
        };

        public String getTopicid() {
            return topicid;
        }

        public void setTopicid(String topicid) {
            this.topicid = topicid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(String likeNum) {
            this.likeNum = likeNum;
        }

        public String getPlayurl() {
            return playurl;
        }

        public void setPlayurl(String playurl) {
            this.playurl = playurl;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public int getIsliked() {
            return isliked;
        }

        public void setIsliked(int isliked) {
            this.isliked = isliked;
        }

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getImageBig() {
            return imageBig;
        }

        public void setImageBig(String imageBig) {
            this.imageBig = imageBig;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(topicid);
            dest.writeString(title);
            dest.writeString(duration);
            dest.writeString(likeNum);
            dest.writeString(playurl);
            dest.writeString(md5);
            dest.writeInt(isliked);
            dest.writeString(view);
            dest.writeString(size);
            dest.writeString(imageBig);
        }
    }
}
