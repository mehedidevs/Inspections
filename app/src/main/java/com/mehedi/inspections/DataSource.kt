package com.mehedi.inspections

object DataSource {
    val dummyData: DataModel = DataModel(
            dataList = listOf(
                Inspection(
                    inspectionType = "Routine",
                    propertyName = "Property A",
                    inspectionDate = "2024-03-23",
                    inspectionStatus = InspectionStatus.IN_PROGRESS,
                    inspectedBy = "Inspector X",
                    inspectionCategory = InspectionCategory(
                        categoryName = "General",
                        areaList = listOf(
                            Area(
                                areaName = "Exterior",
                                checkList = listOf(
                                    Details(
                                        title = "Roof condition",
                                        numberOfStar = 4,
                                        numberOfAttach = 2,
                                        numberOfComments = 3
                                    ),
                                    Details(
                                        title = "Sidewalk condition",
                                        numberOfStar = 5,
                                        numberOfAttach = 1,
                                        numberOfComments = 2
                                    )
                                )
                            ),
                            Area(
                                areaName = "Interior",
                                checkList = listOf(
                                    Details(
                                        title = "Floor condition",
                                        numberOfStar = 4,
                                        numberOfAttach = 0,
                                        numberOfComments = 1
                                    ),
                                    Details(
                                        title = "Wall condition",
                                        numberOfStar = 3,
                                        numberOfAttach = 0,
                                        numberOfComments = 0
                                    )
                                )
                            )
                        )
                    )
                ),
                Inspection(
                    inspectionType = "Scheduled",
                    propertyName = "Property B",
                    inspectionDate = "2024-03-24",
                    inspectionStatus = InspectionStatus.DONE,
                    inspectedBy = "Inspector Y",
                    inspectionCategory = InspectionCategory(
                        categoryName = "Electrical",
                        areaList = listOf(
                            Area(
                                areaName = "Wiring",
                                checkList = listOf(
                                    Details(
                                        title = "Main panel",
                                        numberOfStar = 5,
                                        numberOfAttach = 2,
                                        numberOfComments = 1
                                    ),
                                    Details(
                                        title = "Outlet testing",
                                        numberOfStar = 4,
                                        numberOfAttach = 1,
                                        numberOfComments = 0
                                    )
                                )
                            ),
                            Area(
                                areaName = "Fixtures",
                                checkList = listOf(
                                    Details(
                                        title = "Ceiling lights",
                                        numberOfStar = 3,
                                        numberOfAttach = 0,
                                        numberOfComments = 2
                                    ),
                                    Details(
                                        title = "Wall switches",
                                        numberOfStar = 4,
                                        numberOfAttach = 0,
                                        numberOfComments = 1
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )


}