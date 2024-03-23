package com.mehedi.inspections

enum class InspectionStatus(val status: String) {
    INPROGRESS("inprogress"), CANCEL("cancel"), DONE("done")
}

enum class TaskStatus(val status: String) {
    DONE("done"), BLOCK("block"), NEXT_TIME("next_time"), CANCEL("cancel")
}

data class Inspection(
    val inspectionType: String,
    val propertyName: String,
    val inspectionDate: Long,
    val inspectionStatus: InspectionStatus,
    val inspectedBy: String,
    val inspectionDetailsList: List<InspectionDetails>
)

data class InspectionDetails(
    val inspectionName: String, // Showing current Rv
    val list: List<WorkingArea> // will be shown to the child Rv
)

data class WorkingArea(
    val name: String, // Showing current Rv
    val list: List<TaskDetails> // will be shown to the child Rv
)


data class TaskDetails(
    val title: String,
    val numberOfStar: Int,
    val numberOfAttach: Int,
    val numberOfComments: Int,
    val taskStatus: TaskStatus
)
