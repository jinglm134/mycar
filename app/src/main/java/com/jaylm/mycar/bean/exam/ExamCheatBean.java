package com.jaylm.mycar.bean.exam;

import com.jaylm.mycar.bean.BaseBean;

import java.util.List;

/**
 * 秘籍bean
 * Created by jaylm
 * on 2018/10/10.
 */
public class ExamCheatBean extends BaseBean {


    /**
     * articleId : 1048157672190275584
     * channelId : 204
     * cmmtNum : 56
     * ctime : 2018年10月05日
     * imgNum : 1
     * imgages : ["https://t1.58cdn.com.cn/jxedt/seaspray/small/n_v2a5c99a3597f4498ab647bceb38a9d5df_77a34f2af97f6c18.jpg"]
     * likenum : 310
     * pv : 68244
     * title : 科目一速记口诀，考前务必看一遍！（推荐收藏）
     * useraction : {"actiontype":"loadpage","extparam":{"infoid":1048157672190275584},"pagetype":"news_detail","title":"科目一速记口诀，考前务必看一遍！（推荐收藏）","url":"https://bbsapi.jxedt.com/news/h5/detail/204/1048157672190275584"}
     */

    private long articleId;
    private int channelId;
    private int cmmtNum;
    private String ctime;
    private int imgNum;
    private int likenum;
    private int pv;
    private String title;
    private UseractionBean useraction;
    private List<String> imgages;

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getCmmtNum() {
        return cmmtNum;
    }

    public void setCmmtNum(int cmmtNum) {
        this.cmmtNum = cmmtNum;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public int getImgNum() {
        return imgNum;
    }

    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
    }

    public int getLikenum() {
        return likenum;
    }

    public void setLikenum(int likenum) {
        this.likenum = likenum;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UseractionBean getUseraction() {
        return useraction;
    }

    public void setUseraction(UseractionBean useraction) {
        this.useraction = useraction;
    }

    public List<String> getImgages() {
        return imgages;
    }

    public void setImgages(List<String> imgages) {
        this.imgages = imgages;
    }

    public static class UseractionBean {
        /**
         * actiontype : loadpage
         * extparam : {"infoid":1048157672190275584}
         * pagetype : news_detail
         * title : 科目一速记口诀，考前务必看一遍！（推荐收藏）
         * url : https://bbsapi.jxedt.com/news/h5/detail/204/1048157672190275584
         */

        private String actiontype;
        private ExtparamBean extparam;
        private String pagetype;
        private String title;
        private String url;

        public String getActiontype() {
            return actiontype;
        }

        public void setActiontype(String actiontype) {
            this.actiontype = actiontype;
        }

        public ExtparamBean getExtparam() {
            return extparam;
        }

        public void setExtparam(ExtparamBean extparam) {
            this.extparam = extparam;
        }

        public String getPagetype() {
            return pagetype;
        }

        public void setPagetype(String pagetype) {
            this.pagetype = pagetype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public static class ExtparamBean {
            /**
             * infoid : 1048157672190275584
             */

            private long infoid;

            public long getInfoid() {
                return infoid;
            }

            public void setInfoid(long infoid) {
                this.infoid = infoid;
            }
        }
    }
}
