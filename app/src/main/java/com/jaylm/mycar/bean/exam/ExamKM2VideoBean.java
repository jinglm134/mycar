package com.jaylm.mycar.bean.exam;

import android.os.Parcel;
import android.os.Parcelable;

import com.jaylm.mycar.bean.BaseBean;

import java.util.List;

/**
 * Created by jaylm
 * on 2018/10/12.
 */
public class ExamKM2VideoBean extends BaseBean implements Parcelable {


    /**
     * carbrand : [{"brandName":"捷达","brandId":1},{"brandName":"新桑塔纳","brandId":2},{"brandName":"爱丽舍","brandId":3}]
     * pageindex : 1
     * videos : [{"duration":"65","imageBig":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10011.webp","imagePc":"http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10011.jpg","imageTiny":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10011.webp","isliked":0,"label":"2018新规","likeNum":"12.7W","md5":"ee76183f88359c0d5e152763b2e73d6e","passrate":"","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/方向盘的操作方法.mp4","size":"9.6","summary":"方向向哪它说了算","title":"方向盘的操作方法","topicid":"938029173017290156","view":"1439.1W"},{"duration":"73","imageBig":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10014.webp","imagePc":"http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10014.jpg","imageTiny":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10014.webp","isliked":0,"label":"2018新规","likeNum":"12.3W","md5":"e7bd4b06256073d6ea9ee2f23a37c4fd","passrate":"","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/刹车和油门的操作方法1.mp4","size":"12.1","summary":"刹车油门一只脚，直踩刹车斜踩油门","title":"刹车和油门的操作方法","topicid":"938029173098078634","view":"1370.7W"},{"duration":"225","imageBig":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10012.webp","imagePc":"http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10012.jpg","imageTiny":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10012.webp","isliked":0,"label":"2018新规","likeNum":"11.6W","md5":"8c80314e6813cb3eeaf77177add8409d","passrate":"","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/变速杆的操作方法.mp4","size":"33.3","summary":"换挡操作要熟练","title":"变速杆的操作方法","topicid":"938029173078256817","view":"1491.0W"},{"duration":"79","imageBig":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10015.webp","imagePc":"http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10015.jpg","imageTiny":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10015.webp","isliked":0,"label":"2018新规","likeNum":"11.0W","md5":"041f7e0f53b99003c3a9bcee5159541d","passrate":"","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/油门离合器配合的操作方法1.mp4","size":"13.6","summary":"油离配合好，换挡更轻松","title":"油门离合器配合的操作方法","topicid":"938029173011781679","view":"1335.2W"},{"duration":"75","imageBig":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10001.webp","imagePc":"http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10001.jpg","imageTiny":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10001.webp","isliked":0,"label":"2018新规","likeNum":"12.2W","md5":"f9043860aeb7c0c93dad832598f2526d","passrate":"","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/转向灯的操作方法1.mp4","size":"12.4","summary":"转弯时示意其他车辆","title":"转向灯的操作方法","topicid":"938029173013425436","view":"1352.7W"},{"duration":"42","imageBig":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10006.webp","imagePc":"http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10006.jpg","imageTiny":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10006.webp","isliked":0,"label":"2018新规","likeNum":"11.6W","md5":"844301f4d93ea000b8394c7f3d4b6573","passrate":"","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/远光灯的操作方法.mp4","size":"10.0","summary":"夜间照明条件不良的路段使用","title":"远光灯的操作方法","topicid":"938029173012789024","view":"1239.2W"},{"duration":"43","imageBig":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10007.webp","imagePc":"http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10007.jpg","imageTiny":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10007.webp","isliked":0,"label":"2018新规","likeNum":"11.8W","md5":"aaef510a03a318410c6b8ed83381211e","passrate":"","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/远近灯光交替的作用.mp4","size":"10.3","summary":"夜间行车时提醒其他车辆注意","title":"远近灯光交替的作用","topicid":"938029173009792517","view":"1163.2W"},{"duration":"40","imageBig":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10008.webp","imagePc":"http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10008.jpg","imageTiny":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10008.webp","isliked":0,"label":"2018新规","likeNum":"10.6W","md5":"7212c1b74ab0de6156dc64460e1d9aeb","passrate":"","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/喇叭的操作方法1.mp4","size":"5.0","summary":"短按即可勿长按","title":"喇叭的操作方法","topicid":"938029173078260816","view":"1132.5W"},{"duration":"38","imageBig":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10009.webp","imagePc":"http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10009.jpg","imageTiny":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10009.webp","isliked":0,"label":"2018新规","likeNum":"11.5W","md5":"09561219bd9ef4400a73f39802c261ee","passrate":"","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/安全带的操作方法.mp4","size":"6.8","summary":"开车谨记，安全第一","title":"安全带的操作方法","topicid":"938029173008090724","view":"1234.6W"},{"duration":"55","imageBig":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10010.webp","imagePc":"http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10010.jpg","imageTiny":"https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10010.webp","isliked":0,"label":"2018新规","likeNum":"12.2W","md5":"1e94b018b224e40228829bfce1cdcbe4","passrate":"","playurl":"https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/驻车制动器的操作方法.mp4","size":"10.7","summary":"起步前，停车后，手刹不能忘","title":"驻车制动器的操作方法","topicid":"938029173079685714","view":"1159.9W"}]
     * islastpage : false
     */

    private int pageindex;
    private boolean islastpage;
    private List<CarbrandBean> carbrand;
    private List<VideosBean> videos;

    protected ExamKM2VideoBean(Parcel in) {
        pageindex = in.readInt();
        islastpage = in.readByte() != 0;
        videos = in.createTypedArrayList(VideosBean.CREATOR);
    }

    public static final Creator<ExamKM2VideoBean> CREATOR = new Creator<ExamKM2VideoBean>() {
        @Override
        public ExamKM2VideoBean createFromParcel(Parcel in) {
            return new ExamKM2VideoBean(in);
        }

        @Override
        public ExamKM2VideoBean[] newArray(int size) {
            return new ExamKM2VideoBean[size];
        }
    };

    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public boolean isIslastpage() {
        return islastpage;
    }

    public void setIslastpage(boolean islastpage) {
        this.islastpage = islastpage;
    }

    public List<CarbrandBean> getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(List<CarbrandBean> carbrand) {
        this.carbrand = carbrand;
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
        dest.writeInt(pageindex);
        dest.writeByte((byte) (islastpage ? 1 : 0));
        dest.writeTypedList(videos);
    }

    public static class CarbrandBean {
        /**
         * brandName : 捷达
         * brandId : 1
         */

        private String brandName;
        private int brandId;

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }
    }

    public static class VideosBean implements Parcelable {
        /**
         * duration : 65
         * imageBig : https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10011.webp
         * imagePc : http://img.58cdn.com.cn/dist/jxedt/native/video_pc_cover/j10011.jpg
         * imageTiny : https://img.58cdn.com.cn/dist/jxedt/native/video_small_cover/j10011.webp
         * isliked : 0
         * label : 2018新规
         * likeNum : 12.7W
         * md5 : ee76183f88359c0d5e152763b2e73d6e
         * passrate :
         * playurl : https://wos.58cdn.com.cn/XyVuTsRqXyf/videos/方向盘的操作方法.mp4
         * size : 9.6
         * summary : 方向向哪它说了算
         * title : 方向盘的操作方法
         * topicid : 938029173017290156
         * view : 1439.1W
         */

        private String duration;
        private String imageBig;
        private String imagePc;
        private String imageTiny;
        private int isliked;
        private String label;
        private String likeNum;
        private String md5;
        private String passrate;
        private String playurl;
        private String size;
        private String summary;
        private String title;
        private String topicid;
        private String view;

        protected VideosBean(Parcel in) {
            duration = in.readString();
            imageBig = in.readString();
            imagePc = in.readString();
            imageTiny = in.readString();
            isliked = in.readInt();
            label = in.readString();
            likeNum = in.readString();
            md5 = in.readString();
            passrate = in.readString();
            playurl = in.readString();
            size = in.readString();
            summary = in.readString();
            title = in.readString();
            topicid = in.readString();
            view = in.readString();
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

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getImageBig() {
            return imageBig;
        }

        public void setImageBig(String imageBig) {
            this.imageBig = imageBig;
        }

        public String getImagePc() {
            return imagePc;
        }

        public void setImagePc(String imagePc) {
            this.imagePc = imagePc;
        }

        public String getImageTiny() {
            return imageTiny;
        }

        public void setImageTiny(String imageTiny) {
            this.imageTiny = imageTiny;
        }

        public int getIsliked() {
            return isliked;
        }

        public void setIsliked(int isliked) {
            this.isliked = isliked;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(String likeNum) {
            this.likeNum = likeNum;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getPassrate() {
            return passrate;
        }

        public void setPassrate(String passrate) {
            this.passrate = passrate;
        }

        public String getPlayurl() {
            return playurl;
        }

        public void setPlayurl(String playurl) {
            this.playurl = playurl;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTopicid() {
            return topicid;
        }

        public void setTopicid(String topicid) {
            this.topicid = topicid;
        }

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(duration);
            dest.writeString(imageBig);
            dest.writeString(imagePc);
            dest.writeString(imageTiny);
            dest.writeInt(isliked);
            dest.writeString(label);
            dest.writeString(likeNum);
            dest.writeString(md5);
            dest.writeString(passrate);
            dest.writeString(playurl);
            dest.writeString(size);
            dest.writeString(summary);
            dest.writeString(title);
            dest.writeString(topicid);
            dest.writeString(view);
        }
    }
}
