package com.jaylm.mycar.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by jaylm
 * on 2018/10/5.
 */
data class SchoolDetailBean(val Corp_Id: String, val Corp_Name: String, val Short_CorpName: String, val Corp_Level: String, val Manage_Addr: String, val AvgScore: Double, val SetPrice: Double, val Canton_Code: String, val IsRecommand: Int, val CommentCount: Int, val Lon: Double, val Lat: Double, val LonLatType: Int, val LonLatId: String, val LonLatAddr: String, val LonLatName: String, val Train_Vehicle_Type: String, val Summary: String, val Distance: Double, val OrderNum: Int, val CorpLogo: String, val DisplayBig: Int, val PicUrl3D: String, val VedioUrl: String, val OriVedioUrl: String, val CorpMarks: List<CorpMarksBean>, val TrainVehicleTypes: List<String>, val CorpPics: List<String>, val EfencePics: List<String>) :BaseBean(),Parcelable{

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            TODO("CorpMarks"),
            parcel.createStringArrayList(),
            parcel.createStringArrayList(),
            parcel.createStringArrayList()) {
    }

    data class CorpMarksBean(val CorpMarkId: String, val CorpId: String, val MarkId: String, val MarkOrder: Int, val MarkType: Int, val MarkStatus: Int, val MarkName: String, val MarkColor: String):BaseBean(),Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(CorpMarkId)
            parcel.writeString(CorpId)
            parcel.writeString(MarkId)
            parcel.writeInt(MarkOrder)
            parcel.writeInt(MarkType)
            parcel.writeInt(MarkStatus)
            parcel.writeString(MarkName)
            parcel.writeString(MarkColor)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<CorpMarksBean> {
            override fun createFromParcel(parcel: Parcel): CorpMarksBean {
                return CorpMarksBean(parcel)
            }

            override fun newArray(size: Int): Array<CorpMarksBean?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Corp_Id)
        parcel.writeString(Corp_Name)
        parcel.writeString(Short_CorpName)
        parcel.writeString(Corp_Level)
        parcel.writeString(Manage_Addr)
        parcel.writeDouble(AvgScore)
        parcel.writeDouble(SetPrice)
        parcel.writeString(Canton_Code)
        parcel.writeInt(IsRecommand)
        parcel.writeInt(CommentCount)
        parcel.writeDouble(Lon)
        parcel.writeDouble(Lat)
        parcel.writeInt(LonLatType)
        parcel.writeString(LonLatId)
        parcel.writeString(LonLatAddr)
        parcel.writeString(LonLatName)
        parcel.writeString(Train_Vehicle_Type)
        parcel.writeString(Summary)
        parcel.writeDouble(Distance)
        parcel.writeInt(OrderNum)
        parcel.writeString(CorpLogo)
        parcel.writeInt(DisplayBig)
        parcel.writeString(PicUrl3D)
        parcel.writeString(VedioUrl)
        parcel.writeString(OriVedioUrl)
        parcel.writeStringList(TrainVehicleTypes)
        parcel.writeStringList(CorpPics)
        parcel.writeStringList(EfencePics)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SchoolDetailBean> {
        override fun createFromParcel(parcel: Parcel): SchoolDetailBean {
            return SchoolDetailBean(parcel)
        }

        override fun newArray(size: Int): Array<SchoolDetailBean?> {
            return arrayOfNulls(size)
        }
    }

}