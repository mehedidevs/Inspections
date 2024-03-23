package com.mehedi.inspections

object DataSource {

    val dummyInspections = listOf(
        Inspection(
            inspectionType = "Fire Safety Inspection",
            propertyName = "123 Main Street",
            inspectionDate = System.currentTimeMillis(),
            inspectionStatus = InspectionStatus.INPROGRESS,
            inspectedBy = "John Doe",
            inspectionDetailsList = listOf(
                InspectionDetails(
                    inspectionName = "Fire Safety Equipment",
                    list = listOf(
                        WorkingArea(
                            name = "Fire Extinguishers",
                            list = listOf(
                                TaskDetails(
                                    title = "Check pressure gauge",
                                    numberOfStar = 3,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.DONE
                                ),
                                TaskDetails(
                                    title = "Inspect for physical damage",
                                    numberOfStar = 2,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.DONE
                                )
                            )
                        ),
                        WorkingArea(
                            name = "Emergency Exit",
                            list = listOf(
                                TaskDetails(
                                    title = "Ensure clear pathway",
                                    numberOfStar = 4,
                                    numberOfAttach = 0,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.DONE
                                ),
                                TaskDetails(
                                    title = "Test emergency lighting",
                                    numberOfStar = 5,
                                    numberOfAttach = 3,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.NEXT_TIME
                                )
                            )
                        )
                    )
                ),
                InspectionDetails(
                    inspectionName = "Electrical Safety",
                    list = listOf(
                        WorkingArea(
                            name = "Circuit Breakers",
                            list = listOf(
                                TaskDetails(
                                    title = "Check for proper labeling",
                                    numberOfStar = 3,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.DONE
                                ),
                                TaskDetails(
                                    title = "Inspect for overheating",
                                    numberOfStar = 4,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.CANCEL
                                )
                            )
                        ),
                        WorkingArea(
                            name = "Electrical Outlets",
                            list = listOf(
                                TaskDetails(
                                    title = "Check for grounding",
                                    numberOfStar = 5,
                                    numberOfAttach = 3,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.DONE
                                ),
                                TaskDetails(
                                    title = "Inspect for loose connections",
                                    numberOfStar = 4,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.NEXT_TIME
                                )
                            )
                        )
                    )
                )
            )
        ),
        Inspection(
            inspectionType = "Health and Safety Inspection",
            propertyName = "456 Oak Avenue",
            inspectionDate = System.currentTimeMillis(),
            inspectionStatus = InspectionStatus.DONE,
            inspectedBy = "Jane Smith",
            inspectionDetailsList = listOf(
                InspectionDetails(
                    inspectionName = "Sanitation",
                    list = listOf(
                        WorkingArea(
                            name = "Kitchen",
                            list = listOf(
                                TaskDetails(
                                    title = "Check refrigerator temperature",
                                    numberOfStar = 5,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.DONE
                                ),
                                TaskDetails(
                                    title = "Inspect food storage",
                                    numberOfStar = 4,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.DONE
                                )
                            )
                        ),
                        WorkingArea(
                            name = "Restrooms",
                            list = listOf(
                                TaskDetails(
                                    title = "Clean sinks and countertops",
                                    numberOfStar = 4,
                                    numberOfAttach = 3,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.DONE
                                ),
                                TaskDetails(
                                    title = "Restock paper towels",
                                    numberOfStar = 5,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.DONE
                                )
                            )
                        )
                    )
                ),
                InspectionDetails(
                    inspectionName = "Fire Safety Measures",
                    list = listOf(
                        WorkingArea(
                            name = "Smoke Alarms",
                            list = listOf(
                                TaskDetails(
                                    title = "Test functionality",
                                    numberOfStar = 5,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.DONE
                                ),
                                TaskDetails(
                                    title = "Replace batteries",
                                    numberOfStar = 4,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.NEXT_TIME
                                )
                            )
                        ),
                        WorkingArea(
                            name = "Emergency Evacuation Plan",
                            list = listOf(
                                TaskDetails(
                                    title = "Review with staff",
                                    numberOfStar = 5,
                                    numberOfAttach = 3,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.DONE
                                ),
                                TaskDetails(
                                    title = "Update exit routes",
                                    numberOfStar = 4,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.CANCEL
                                )
                            )
                        )
                    )
                )
            )
        )
    )


}