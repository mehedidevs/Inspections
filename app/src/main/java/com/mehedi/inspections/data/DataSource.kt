package com.mehedi.inspections.data

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
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect for physical damage",
                                    numberOfStar = 2,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
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
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Test emergency lighting",
                                    numberOfStar = 5,
                                    numberOfAttach = 3,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.NEXT_TIME,
                                    images = images()
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
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect for overheating",
                                    numberOfStar = 4,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.CANCEL,
                                    images = images()
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
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect for loose connections",
                                    numberOfStar = 4,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.NEXT_TIME,
                                    images = images()
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
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect food storage",
                                    numberOfStar = 4,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
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
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Restock paper towels",
                                    numberOfStar = 5,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
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
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Replace batteries",
                                    numberOfStar = 4,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.NEXT_TIME,
                                    images = images()
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
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Update exit routes",
                                    numberOfStar = 4,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.CANCEL,
                                    images = images()
                                )
                            )
                        )
                    )
                )
            )
        )
    )


    private fun images() = Images(
        listOf(
            "https://media-cdn.tripadvisor.com/media/photo-s/0b/ee/1a/08/portrait-view-from-bldg.jpg",
            "https://photos.airmail.news/pko7cdpwcvwq0ylo4he1phm329x6-8a42f7884334fb80b82df9ad67f26c2c.jpg",
            "https://i.pinimg.com/736x/b3/d7/2c/b3d72c37533fb0571c2094417690b6f5.jpg",
            "https://media-cdn.tripadvisor.com/media/photo-s/0e/67/7e/c2/photo1jpg.jpg"
        )
    )


}