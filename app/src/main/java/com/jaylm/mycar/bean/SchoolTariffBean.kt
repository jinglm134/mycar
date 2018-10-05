package com.jaylm.mycar.bean

/**
 * Created by jaylm
 * on 2018/10/5.
 */
data class SchoolTariffBean(val SetId: String, val CorpId: String, val SetName: String, val SetDescription: String, val Pickup: String, val InfactPay: Double, val TotalPay: Double, val VehicleType: String, val Subject2Hour: Int, val Subject3Hour: Int, val SetNum: Int, val Status: Int, val CreateTime: String, val UpdateTime: String, val SetType: Int, val DateType: Int, val SetOrder: Int, val IsRecommand: Int, val Discount: Double, val Practicetype: String, val TakeCardDate: String, val PracticeHour: String, val VehicleBrand: String, val BtnSign: Int) : BaseBean()