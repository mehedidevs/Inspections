//package com.mehedi.inspections
//
//enum class InspectionStatus(val type: String) {
//    IN_PROGRESS("in progress"), CANCEL("cancel"), DONE("done")
//}
//
//data class DataModel(
//    val dataList: List<Inspection>
//)
//
//data class Inspection(
//    val inspectionType: String,
//    val propertyName: String,
//    val inspectionDate: String,
//    val inspectionStatus: InspectionStatus,
//    val inspectedBy: String,
//    val inspectionCategory: InspectionCategory
//)
//
//data class InspectionCategory(
//    val categoryName: String,
//    val areaName: String,
//    val checkList: List<Details>
//)
//
//
//data class Details(
//    val title: String,
//    val numberOfStar: Int,
//    val numberOfAttach: Int,
//    val numberOfComments: Int,
//)
