package com.mehedi.inspections.data

class InspectionRepository {
    fun getInspections(): MutableList<Inspection> {
        return dummyInspections
    }


    private val dummyInspections = mutableListOf(
        Inspection(
            inspectionType = "Fire Safety Inspection",
            propertyName = "123 Main Street",
            inspectionDate = System.currentTimeMillis(),
            inspectionStatus = InspectionStatus.IN_PROGRESS,
            inspectedBy = "John Doe",
            inspectionDetailsList = mutableListOf(
                InspectionDetails(
                    inspectionName = "Fire Safety Equipment",
                    list = mutableListOf(
                        WorkingArea(
                            name = "Fire Extinguishers",
                            list = mutableListOf(
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
                            list = mutableListOf(
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
                    list = mutableListOf(
                        WorkingArea(
                            name = "Circuit Breakers",
                            list = mutableListOf(
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
                            list = mutableListOf(
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
            inspectionDetailsList = mutableListOf(
                InspectionDetails(
                    inspectionName = "Sanitation",
                    list = mutableListOf(
                        WorkingArea(
                            name = "Kitchen",
                            list = mutableListOf(
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
                            list = mutableListOf(
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
                    list = mutableListOf(
                        WorkingArea(
                            name = "Smoke Alarms",
                            list = mutableListOf(
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
                            list = mutableListOf(
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
        ),
        Inspection(
            inspectionType = "Property Inspection",
            propertyName = "Sample Property 1",
            inspectionDate = System.currentTimeMillis(),
            inspectionStatus = InspectionStatus.IN_PROGRESS,
            inspectedBy = "John Doe",
            inspectionDetailsList = mutableListOf(
                InspectionDetails(
                    inspectionName = "Interior Inspection",
                    list = mutableListOf(
                        WorkingArea(
                            name = "Living Room",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check furniture condition",
                                    numberOfStar = 4,
                                    numberOfAttach = 2,
                                    numberOfComments = 3,
                                    taskStatus = TaskStatus.NO_STATUS,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect walls for damages",
                                    numberOfStar = 5,
                                    numberOfAttach = 1,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.NO_STATUS,
                                    images = images()
                                )
                            )
                        ),
                        WorkingArea(
                            name = "Kitchen",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check appliances",
                                    numberOfStar = 3,
                                    numberOfAttach = 0,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.NO_STATUS,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect plumbing",
                                    numberOfStar = 4,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.NO_STATUS,
                                    images = images()
                                )
                            )
                        )
                    )
                )
            )
        ),
        Inspection(
            inspectionType = "Vehicle Inspection",
            propertyName = "Sample Vehicle 1",
            inspectionDate = System.currentTimeMillis(),
            inspectionStatus = InspectionStatus.DONE,
            inspectedBy = "Jane Smith",
            inspectionDetailsList = mutableListOf(
                InspectionDetails(
                    inspectionName = "Exterior Inspection",
                    list = mutableListOf(
                        WorkingArea(
                            name = "Body",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check for dents",
                                    numberOfStar = 4,
                                    numberOfAttach = 1,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.DONE,
                                    images = Images(
                                        imageList = listOf(
                                            "image5.jpg"
                                        )
                                    )
                                ),
                                TaskDetails(
                                    title = "Inspect paint condition",
                                    numberOfStar = 5,
                                    numberOfAttach = 2,
                                    numberOfComments = 3,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                )
                            )
                        ),
                        WorkingArea(
                            name = "Tires",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check tire pressure",
                                    numberOfStar = 4,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect tire tread depth",
                                    numberOfStar = 5,
                                    numberOfAttach = 0,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                )
                            )
                        )
                    )
                )
            )
        ),
        Inspection(
            inspectionType = "Property Inspection",
            propertyName = "Sample Property 2",
            inspectionDate = System.currentTimeMillis(),
            inspectionStatus = InspectionStatus.CANCEL,
            inspectedBy = "Alice Johnson",
            inspectionDetailsList = mutableListOf(
                InspectionDetails(
                    inspectionName = "Exterior Inspection",
                    list = mutableListOf(
                        WorkingArea(
                            name = "Front Yard",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check lawn condition",
                                    numberOfStar = 3,
                                    numberOfAttach = 1,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.CANCEL,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect exterior walls",
                                    numberOfStar = 4,
                                    numberOfAttach = 0,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.CANCEL,
                                    images = images()
                                )
                            )
                        ),
                        WorkingArea(
                            name = "Backyard",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check fence condition",
                                    numberOfStar = 4,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.CANCEL,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect patio area",
                                    numberOfStar = 3,
                                    numberOfAttach = 0,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.CANCEL,
                                    images = images()
                                )
                            )
                        )
                    )
                )
            )
        ),
        Inspection(
            inspectionType = "Property Inspection",
            propertyName = "Sample Property 3",
            inspectionDate = System.currentTimeMillis(),
            inspectionStatus = InspectionStatus.DONE,
            inspectedBy = "Michael Brown",
            inspectionDetailsList = mutableListOf(
                InspectionDetails(
                    inspectionName = "Electrical Inspection",
                    list = mutableListOf(
                        WorkingArea(
                            name = "Main Electrical Panel",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check circuit breakers",
                                    numberOfStar = 5,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect wiring connections",
                                    numberOfStar = 4,
                                    numberOfAttach = 0,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                )
                            )
                        ),
                        WorkingArea(
                            name = "Outdoor Lighting",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check bulbs",
                                    numberOfStar = 4,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect wiring",
                                    numberOfStar = 5,
                                    numberOfAttach = 1,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                )
                            )
                        )
                    )
                )
            )
        ),
        Inspection(
            inspectionType = "Property Inspection",
            propertyName = "Sample Property 4",
            inspectionDate = System.currentTimeMillis(),
            inspectionStatus = InspectionStatus.IN_PROGRESS,
            inspectedBy = "Emily Wilson",
            inspectionDetailsList = mutableListOf(
                InspectionDetails(
                    inspectionName = "Plumbing Inspection",
                    list = mutableListOf(
                        WorkingArea(
                            name = "Bathroom",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check faucets for leaks",
                                    numberOfStar = 4,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.BLOCK,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect toilet operation",
                                    numberOfStar = 5,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                )
                            )
                        ),
                        WorkingArea(
                            name = "Kitchen",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check sink drainage",
                                    numberOfStar = 4,
                                    numberOfAttach = 0,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.NEXT_TIME,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect dishwasher operation",
                                    numberOfStar = 5,
                                    numberOfAttach = 1,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.CANCEL,
                                    images = images()
                                )
                            )
                        )
                    )
                )
            )
        ),
        Inspection(
            inspectionType = "Vehicle Inspection",
            propertyName = "Sample Vehicle 2",
            inspectionDate = System.currentTimeMillis(),
            inspectionStatus = InspectionStatus.IN_PROGRESS,
            inspectedBy = "David Lee",
            inspectionDetailsList = mutableListOf(
                InspectionDetails(
                    inspectionName = "Interior Inspection",
                    list = mutableListOf(
                        WorkingArea(
                            name = "Dashboard",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check instrument cluster",
                                    numberOfStar = 4,
                                    numberOfAttach = 1,
                                    numberOfComments = 0,
                                    taskStatus = TaskStatus.NEXT_TIME,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect air conditioning system",
                                    numberOfStar = 5,
                                    numberOfAttach = 2,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.DONE,
                                    images = images()
                                )
                            )
                        ),
                        WorkingArea(
                            name = "Seats",
                            list = mutableListOf(
                                TaskDetails(
                                    title = "Check seat adjustment",
                                    numberOfStar = 4,
                                    numberOfAttach = 0,
                                    numberOfComments = 2,
                                    taskStatus = TaskStatus.CANCEL,
                                    images = images()
                                ),
                                TaskDetails(
                                    title = "Inspect seat upholstery",
                                    numberOfStar = 5,
                                    numberOfAttach = 1,
                                    numberOfComments = 1,
                                    taskStatus = TaskStatus.NO_STATUS,
                                    images = images()
                                )
                            )
                        )
                    )
                )
            )
        ),


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