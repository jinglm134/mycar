package com.jaylm.mycar.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by jaylm
 * on 2018/10/4.
 */
data class SchoolHotBean(val PageIndex: Int, val PageSize: Int, val TotalRecord: Int, val Items: ArrayList<ItemsBean>) : BaseBean() ,Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            TODO("Items"))

    data class ItemsBean(var Corp_Id: String, var Corp_Name: String, var Short_CorpName: String, var Corp_Level: String, var Manage_Addr: String, var AvgScore: Double, var SetPrice: Double, var Canton_Code: String, var IsRecommand: Int, var CommentCount: Int, var Lon: Double, var Lat: Double, var LonLatType: Int, var LonLatId: String, var LonLatAddr: String, var LonLatName: String, var Train_Vehicle_Type: String, var Summary: String, var Distance: Double, var OrderNum: Int, var CorpLogo: String, var DisplayBig: Int, var PicUrl3D: String, var VedioUrl: String, var OriVedioUrl: String, var CorpMarks: ArrayList<CorpMarksBean>, var TrainVehicleTypes: ArrayList<String>, var CorpPics: ArrayList<String>, var EfencePics: ArrayList<String>) {
        data class CorpMarksBean(var CorpMarkId: Int, var CorpId: Int, var MarkId: Int, var MarkOrder: Int, var MarkType: Int, var MarkStatus: Int, var MarkName: String, var MarkColor: String) : BaseBean()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(PageIndex)
        parcel.writeInt(PageSize)
        parcel.writeInt(TotalRecord)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SchoolHotBean> {
        override fun createFromParcel(parcel: Parcel): SchoolHotBean {
            return SchoolHotBean(parcel)
        }

        override fun newArray(size: Int): Array<SchoolHotBean?> {
            return arrayOfNulls(size)
        }
    }
}