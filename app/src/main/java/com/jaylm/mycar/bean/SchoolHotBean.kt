package com.jaylm.mycar.bean

/**
 * Created by jaylm
 * on 2018/10/4.
 */
data class SchoolHotBean(val PageIndex: Int, val PageSize: Int, val TotalRecord: Int, val Items: ArrayList<ItemsBean>) : BaseBean() {
    data class ItemsBean(var Corp_Id: String, var Corp_Name: String, var Short_CorpName: String, var Corp_Level: String, var Manage_Addr: String, var AvgScore: Double, var SetPrice: Double, var Canton_Code: String, var IsRecommand: Int, var CommentCount: Int, var Lon: Double, var Lat: Double, var LonLatType: Int, var LonLatId: String, var LonLatAddr: String, var LonLatName: String, var Train_Vehicle_Type: String, var Summary: String, var Distance: Double, var OrderNum: Int, var CorpLogo: String, var DisplayBig: Int, var PicUrl3D: String, var VedioUrl: String, var OriVedioUrl: String, var CorpMarks: ArrayList<CorpMarksBean>, var TrainVehicleTypes: ArrayList<String>, var CorpPics: ArrayList<String>, var EfencePics: ArrayList<String>) {
        data class CorpMarksBean(var CorpMarkId: Int, var CorpId: Int, var MarkId: Int, var MarkOrder: Int, var MarkType: Int, var MarkStatus: Int, var MarkName: String, var MarkColor: String) : BaseBean()
    }
}