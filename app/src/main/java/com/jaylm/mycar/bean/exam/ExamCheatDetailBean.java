package com.jaylm.mycar.bean.exam;

import com.jaylm.mycar.bean.BaseBean;

import java.util.List;

/**
 * Created by jaylm
 * on 2018/10/10.
 */
public class ExamCheatDetailBean extends BaseBean {


    /**
     * cmtaction : {"actiontype":"loadpage","extparam":{"infoid":1049857245635960832,"articleid":1048157672190275584,"type":1},"pagetype":"cmtcmt","title":"评论详情"}
     * comment : 今天考试必过
     * commentdate : 5小时前
     * comments : []
     * commenttip : 0
     * createtime : 1539140447416
     * face : https://pic3.58cdn.com.cn/www/n_v1bl2lwkak2beftu44f4hq_d016075a4f426d09.png
     * floor : 1
     * groups : [{"actiontype":"loadpage","extparam":{"catetype":1,"infoid":335},"pagetype":"bbsgrouplist","title":"韶关"}]
     * id : 1049857245635960832
     * infoid : 1048157672190275584
     * isexpert : false
     * isvip : false
     * liketip : 1
     * nickname : 一点通8390
     * praised : 0
     * useraction : {"actiontype":"loadpage","extparam":{"infoid":3303025718212952272},"pagetype":"other","title":"一点通8390","url":"https://bbsapi.jxedt.com/userlist/3303025718212952272/"}
     * userid : 3303025718212952272
     * usertype : 4
     */

    private CmtactionBean cmtaction;
    private String comment;
    private String commentdate;
    private int commenttip;
    private long createtime;
    private String face;
    private String floor;
    private long id;
    private String infoid;
    private boolean isexpert;
    private boolean isvip;
    private int liketip;
    private String nickname;
    private int praised;
    private UseractionBean useraction;
    private String userid;
    private int usertype;
    private List<String> comments;
    private List<GroupsBean> groups;

    public CmtactionBean getCmtaction() {
        return cmtaction;
    }

    public void setCmtaction(CmtactionBean cmtaction) {
        this.cmtaction = cmtaction;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate;
    }

    public int getCommenttip() {
        return commenttip;
    }

    public void setCommenttip(int commenttip) {
        this.commenttip = commenttip;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfoid() {
        return infoid;
    }

    public void setInfoid(String infoid) {
        this.infoid = infoid;
    }

    public boolean isIsexpert() {
        return isexpert;
    }

    public void setIsexpert(boolean isexpert) {
        this.isexpert = isexpert;
    }

    public boolean isIsvip() {
        return isvip;
    }

    public void setIsvip(boolean isvip) {
        this.isvip = isvip;
    }

    public int getLiketip() {
        return liketip;
    }

    public void setLiketip(int liketip) {
        this.liketip = liketip;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPraised() {
        return praised;
    }

    public void setPraised(int praised) {
        this.praised = praised;
    }

    public UseractionBean getUseraction() {
        return useraction;
    }

    public void setUseraction(UseractionBean useraction) {
        this.useraction = useraction;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<GroupsBean> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupsBean> groups) {
        this.groups = groups;
    }

    public static class CmtactionBean {
        /**
         * actiontype : loadpage
         * extparam : {"infoid":1049857245635960832,"articleid":1048157672190275584,"type":1}
         * pagetype : cmtcmt
         * title : 评论详情
         */

        private String actiontype;
        private ExtparamBean extparam;
        private String pagetype;
        private String title;

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

        public static class ExtparamBean {
            /**
             * infoid : 1049857245635960832
             * articleid : 1048157672190275584
             * type : 1
             */

            private long infoid;
            private long articleid;
            private int type;

            public long getInfoid() {
                return infoid;
            }

            public void setInfoid(long infoid) {
                this.infoid = infoid;
            }

            public long getArticleid() {
                return articleid;
            }

            public void setArticleid(long articleid) {
                this.articleid = articleid;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }

    public static class UseractionBean {
        /**
         * actiontype : loadpage
         * extparam : {"infoid":3303025718212952272}
         * pagetype : other
         * title : 一点通8390
         * url : https://bbsapi.jxedt.com/userlist/3303025718212952272/
         */

        private String actiontype;
        private ExtparamBeanX extparam;
        private String pagetype;
        private String title;
        private String url;

        public String getActiontype() {
            return actiontype;
        }

        public void setActiontype(String actiontype) {
            this.actiontype = actiontype;
        }

        public ExtparamBeanX getExtparam() {
            return extparam;
        }

        public void setExtparam(ExtparamBeanX extparam) {
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

        public static class ExtparamBeanX {
            /**
             * infoid : 3303025718212952272
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

    public static class GroupsBean {
        /**
         * actiontype : loadpage
         * extparam : {"catetype":1,"infoid":335}
         * pagetype : bbsgrouplist
         * title : 韶关
         */

        private String actiontype;
        private ExtparamBeanXX extparam;
        private String pagetype;
        private String title;

        public String getActiontype() {
            return actiontype;
        }

        public void setActiontype(String actiontype) {
            this.actiontype = actiontype;
        }

        public ExtparamBeanXX getExtparam() {
            return extparam;
        }

        public void setExtparam(ExtparamBeanXX extparam) {
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

        public static class ExtparamBeanXX {
            /**
             * catetype : 1
             * infoid : 335
             */

            private int catetype;
            private int infoid;

            public int getCatetype() {
                return catetype;
            }

            public void setCatetype(int catetype) {
                this.catetype = catetype;
            }

            public int getInfoid() {
                return infoid;
            }

            public void setInfoid(int infoid) {
                this.infoid = infoid;
            }
        }
    }
}
