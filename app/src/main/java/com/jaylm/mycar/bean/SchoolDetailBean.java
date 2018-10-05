package com.jaylm.mycar.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by jaylm
 * on 2018/10/5.
 */
public class SchoolDetailBean extends BaseBean implements Parcelable {

    /**
     * Corp_Id : 00000038
     * Corp_Name : 南宁惠通机动车驾驶培训有限公司（青秀）
     * Short_CorpName : 惠通驾校（青秀区分训练场）
     * Corp_Level : 一级
     * Manage_Addr : 南宁市西乡塘区鹏飞路168号
     * AvgScore : 0.0
     * SetPrice : 3280.0
     * Canton_Code : 220002
     * IsRecommand : 0
     * CommentCount : 0
     * Lon : 108.367987
     * Lat : 22.832766
     * LonLatType : 1
     * LonLatId : 1021
     * LonLatAddr : 南宁市青秀区茅桥路4号
     * LonLatName : 惠通驾校青秀区分训练场地
     * Train_Vehicle_Type : C1;C2
     * Summary : 南宁惠通机动车驾驶培训有限公司成立于2009年5月,是经南宁交通部门审核批准的专业驾驶技术培训公司。现主要经营业务有小型汽车(C1)、小型自动挡汽车(C2)驾驶技术培训。分有早中晚班,节假日不休,学员随到随学;培训车辆有73辆全新铁雪龙更能满足中高层次学员的车型选择要求。教练员均由全国驾驶行业名校经理现场指导强化训练,我们将始终如一、坚持以人为本,实行人性化管理,服务热情细致,全心全意,因材施教,为了实现更多人的驾车梦而努力!我们将不断超越自我、敢为人先,为驾培行业再做贡献!“
     学车选惠通,拿证更轻松”一树立南宁一流驾校品牌,培训优秀驾驶人才是我校的办学宗旨,惠通驾校真诚欢迎广大学员来我校报名学车,我校全体教职员工将全心全意为广大学员服务。
     * CorpMarks : [{"CorpMarkId":null,"CorpId":null,"MarkId":null,"MarkOrder":0,"MarkType":0,"MarkStatus":0,"MarkName":"一人一车","MarkColor":"#E50000"},{"CorpMarkId":null,"CorpId":null,"MarkId":null,"MarkOrder":0,"MarkType":0,"MarkStatus":0,"MarkName":"金牌教练","MarkColor":"#FF7E5C"},{"CorpMarkId":null,"CorpId":null,"MarkId":null,"MarkOrder":0,"MarkType":0,"MarkStatus":0,"MarkName":"自主预约","MarkColor":"#52BEFF"}]
     * TrainVehicleTypes : ["C1","C2"]
     * Distance : 1.68
     * OrderNum : 1000
     * CorpLogo : http://www.gxxcc.com/JP_NNPay/api/v1/JPApp/Pic/GetCorpLogo?corpId=00000038&tick=636743438199746791
     * CorpPics : ["http://www.gxxcc.com/JP_NNPay/api/v1/JPApp/Pic/GetCorpPhoto?corpId=00000038&picId=d6f4db38-45a6-428b-aaf2-e3179c1055ba&tick=1527335592"]
     * EfencePics : ["http://www.gxxcc.com/JP_NNPay/api/v1/JPApp/Pic/GetEfencePhoto?efenceId=1021&picId=fd266255-ecb4-4f19-b990-8eeb158f7474&tick=1527054789"]
     * DisplayBig : 0
     * PicUrl3D : null
     * VedioUrl : null
     * OriVedioUrl : null
     */

    private String Corp_Id;
    private String Corp_Name;
    private String Short_CorpName;
    private String Corp_Level;
    private String Manage_Addr;
    private double AvgScore;
    private double SetPrice;
    private String Canton_Code;
    private int IsRecommand;
    private int CommentCount;
    private double Lon;
    private double Lat;
    private int LonLatType;
    private String LonLatId;
    private String LonLatAddr;
    private String LonLatName;
    private String Train_Vehicle_Type;
    private String Summary;
    private double Distance;
    private int OrderNum;
    private String CorpLogo;
    private int DisplayBig;
    private String PicUrl3D;
    private String VedioUrl;
    private String OriVedioUrl;
    private List<CorpMarksBean> CorpMarks;
    private List<String> TrainVehicleTypes;
    private List<String> CorpPics;
    private List<String> EfencePics;

    protected SchoolDetailBean(Parcel in) {
        Corp_Id = in.readString();
        Corp_Name = in.readString();
        Short_CorpName = in.readString();
        Corp_Level = in.readString();
        Manage_Addr = in.readString();
        AvgScore = in.readDouble();
        SetPrice = in.readDouble();
        Canton_Code = in.readString();
        IsRecommand = in.readInt();
        CommentCount = in.readInt();
        Lon = in.readDouble();
        Lat = in.readDouble();
        LonLatType = in.readInt();
        LonLatId = in.readString();
        LonLatAddr = in.readString();
        LonLatName = in.readString();
        Train_Vehicle_Type = in.readString();
        Summary = in.readString();
        Distance = in.readDouble();
        OrderNum = in.readInt();
        CorpLogo = in.readString();
        DisplayBig = in.readInt();
        PicUrl3D = in.readString();
        VedioUrl = in.readString();
        OriVedioUrl = in.readString();
        TrainVehicleTypes = in.createStringArrayList();
        CorpPics = in.createStringArrayList();
        EfencePics = in.createStringArrayList();
    }

    public static final Creator<SchoolDetailBean> CREATOR = new Creator<SchoolDetailBean>() {
        @Override
        public SchoolDetailBean createFromParcel(Parcel in) {
            return new SchoolDetailBean(in);
        }

        @Override
        public SchoolDetailBean[] newArray(int size) {
            return new SchoolDetailBean[size];
        }
    };

    public String getCorp_Id() {
        return Corp_Id;
    }

    public void setCorp_Id(String Corp_Id) {
        this.Corp_Id = Corp_Id;
    }

    public String getCorp_Name() {
        return Corp_Name;
    }

    public void setCorp_Name(String Corp_Name) {
        this.Corp_Name = Corp_Name;
    }

    public String getShort_CorpName() {
        return Short_CorpName;
    }

    public void setShort_CorpName(String Short_CorpName) {
        this.Short_CorpName = Short_CorpName;
    }

    public String getCorp_Level() {
        return Corp_Level;
    }

    public void setCorp_Level(String Corp_Level) {
        this.Corp_Level = Corp_Level;
    }

    public String getManage_Addr() {
        return Manage_Addr;
    }

    public void setManage_Addr(String Manage_Addr) {
        this.Manage_Addr = Manage_Addr;
    }

    public double getAvgScore() {
        return AvgScore;
    }

    public void setAvgScore(double AvgScore) {
        this.AvgScore = AvgScore;
    }

    public double getSetPrice() {
        return SetPrice;
    }

    public void setSetPrice(double SetPrice) {
        this.SetPrice = SetPrice;
    }

    public String getCanton_Code() {
        return Canton_Code;
    }

    public void setCanton_Code(String Canton_Code) {
        this.Canton_Code = Canton_Code;
    }

    public int getIsRecommand() {
        return IsRecommand;
    }

    public void setIsRecommand(int IsRecommand) {
        this.IsRecommand = IsRecommand;
    }

    public int getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(int CommentCount) {
        this.CommentCount = CommentCount;
    }

    public double getLon() {
        return Lon;
    }

    public void setLon(double Lon) {
        this.Lon = Lon;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double Lat) {
        this.Lat = Lat;
    }

    public int getLonLatType() {
        return LonLatType;
    }

    public void setLonLatType(int LonLatType) {
        this.LonLatType = LonLatType;
    }

    public String getLonLatId() {
        return LonLatId;
    }

    public void setLonLatId(String LonLatId) {
        this.LonLatId = LonLatId;
    }

    public String getLonLatAddr() {
        return LonLatAddr;
    }

    public void setLonLatAddr(String LonLatAddr) {
        this.LonLatAddr = LonLatAddr;
    }

    public String getLonLatName() {
        return LonLatName;
    }

    public void setLonLatName(String LonLatName) {
        this.LonLatName = LonLatName;
    }

    public String getTrain_Vehicle_Type() {
        return Train_Vehicle_Type;
    }

    public void setTrain_Vehicle_Type(String Train_Vehicle_Type) {
        this.Train_Vehicle_Type = Train_Vehicle_Type;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String Summary) {
        this.Summary = Summary;
    }

    public double getDistance() {
        return Distance;
    }

    public void setDistance(double Distance) {
        this.Distance = Distance;
    }

    public int getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(int OrderNum) {
        this.OrderNum = OrderNum;
    }

    public String getCorpLogo() {
        return CorpLogo;
    }

    public void setCorpLogo(String CorpLogo) {
        this.CorpLogo = CorpLogo;
    }

    public int getDisplayBig() {
        return DisplayBig;
    }

    public void setDisplayBig(int DisplayBig) {
        this.DisplayBig = DisplayBig;
    }

    public String getPicUrl3D() {
        return PicUrl3D;
    }

    public void setPicUrl3D(String PicUrl3D) {
        this.PicUrl3D = PicUrl3D;
    }

    public String getVedioUrl() {
        return VedioUrl;
    }

    public void setVedioUrl(String VedioUrl) {
        this.VedioUrl = VedioUrl;
    }

    public String getOriVedioUrl() {
        return OriVedioUrl;
    }

    public void setOriVedioUrl(String OriVedioUrl) {
        this.OriVedioUrl = OriVedioUrl;
    }

    public List<CorpMarksBean> getCorpMarks() {
        return CorpMarks;
    }

    public void setCorpMarks(List<CorpMarksBean> CorpMarks) {
        this.CorpMarks = CorpMarks;
    }

    public List<String> getTrainVehicleTypes() {
        return TrainVehicleTypes;
    }

    public void setTrainVehicleTypes(List<String> TrainVehicleTypes) {
        this.TrainVehicleTypes = TrainVehicleTypes;
    }

    public List<String> getCorpPics() {
        return CorpPics;
    }

    public void setCorpPics(List<String> CorpPics) {
        this.CorpPics = CorpPics;
    }

    public List<String> getEfencePics() {
        return EfencePics;
    }

    public void setEfencePics(List<String> EfencePics) {
        this.EfencePics = EfencePics;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Corp_Id);
        dest.writeString(Corp_Name);
        dest.writeString(Short_CorpName);
        dest.writeString(Corp_Level);
        dest.writeString(Manage_Addr);
        dest.writeDouble(AvgScore);
        dest.writeDouble(SetPrice);
        dest.writeString(Canton_Code);
        dest.writeInt(IsRecommand);
        dest.writeInt(CommentCount);
        dest.writeDouble(Lon);
        dest.writeDouble(Lat);
        dest.writeInt(LonLatType);
        dest.writeString(LonLatId);
        dest.writeString(LonLatAddr);
        dest.writeString(LonLatName);
        dest.writeString(Train_Vehicle_Type);
        dest.writeString(Summary);
        dest.writeDouble(Distance);
        dest.writeInt(OrderNum);
        dest.writeString(CorpLogo);
        dest.writeInt(DisplayBig);
        dest.writeString(PicUrl3D);
        dest.writeString(VedioUrl);
        dest.writeString(OriVedioUrl);
        dest.writeStringList(TrainVehicleTypes);
        dest.writeStringList(CorpPics);
        dest.writeStringList(EfencePics);
    }

    public static class CorpMarksBean {
        /**
         * CorpMarkId : null
         * CorpId : null
         * MarkId : null
         * MarkOrder : 0
         * MarkType : 0
         * MarkStatus : 0
         * MarkName : 一人一车
         * MarkColor : #E50000
         */

        private Object CorpMarkId;
        private Object CorpId;
        private Object MarkId;
        private int MarkOrder;
        private int MarkType;
        private int MarkStatus;
        private String MarkName;
        private String MarkColor;

        public Object getCorpMarkId() {
            return CorpMarkId;
        }

        public void setCorpMarkId(Object CorpMarkId) {
            this.CorpMarkId = CorpMarkId;
        }

        public Object getCorpId() {
            return CorpId;
        }

        public void setCorpId(Object CorpId) {
            this.CorpId = CorpId;
        }

        public Object getMarkId() {
            return MarkId;
        }

        public void setMarkId(Object MarkId) {
            this.MarkId = MarkId;
        }

        public int getMarkOrder() {
            return MarkOrder;
        }

        public void setMarkOrder(int MarkOrder) {
            this.MarkOrder = MarkOrder;
        }

        public int getMarkType() {
            return MarkType;
        }

        public void setMarkType(int MarkType) {
            this.MarkType = MarkType;
        }

        public int getMarkStatus() {
            return MarkStatus;
        }

        public void setMarkStatus(int MarkStatus) {
            this.MarkStatus = MarkStatus;
        }

        public String getMarkName() {
            return MarkName;
        }

        public void setMarkName(String MarkName) {
            this.MarkName = MarkName;
        }

        public String getMarkColor() {
            return MarkColor;
        }

        public void setMarkColor(String MarkColor) {
            this.MarkColor = MarkColor;
        }
    }
}
