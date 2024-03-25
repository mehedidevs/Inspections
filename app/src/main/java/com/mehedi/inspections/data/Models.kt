package com.mehedi.inspections.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

enum class InspectionStatus(val status: String) {
    INPROGRESS("inprogress"),
    CANCEL("cancel"),
    DONE("done")
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
    val inspectionName: String, // Showing current Rv
    val list: MutableList<WorkingArea> // will be shown to the child Rv
)

data class WorkingArea(
    val name: String, // Showing current Rv
    val list: MutableList<TaskDetails> // will be shown to the child Rv
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

