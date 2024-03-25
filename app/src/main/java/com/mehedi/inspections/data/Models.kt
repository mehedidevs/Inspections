package com.mehedi.inspections.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

enum class InspectionStatus(val status: String) {
    IN_PROGRESS("In Progress"),
    CANCEL("Cancel"),
    DONE("Done")
}

enum class TaskStatus(val status: String) {
    NO_STATUS("no_status"),
    DONE("done"),
    BLOCK("block"),
    NEXT_TIME("next_time"),
    CANCEL("cancel")
}

data class Inspection(
    val inspectionType: String,
    val propertyName: String,
    val inspectionDate: Long,
    val inspectionStatus: InspectionStatus,
    val inspectedBy: String,
    var inspectionDetailsList: MutableList<InspectionDetails>
)

data class InspectionDetails(
    val inspectionName: String,
    val list: MutableList<WorkingArea>
)

data class WorkingArea(
    val name: String,
    val list: MutableList<TaskDetails>
)


data class TaskDetails(
    val title: String,
    val numberOfStar: Int,
    val numberOfAttach: Int,
    val numberOfComments: Int,
    var taskStatus: TaskStatus,
    val images: Images

)

@Parcelize
data class Images(
    val imageList: List<String>
) : Parcelable

