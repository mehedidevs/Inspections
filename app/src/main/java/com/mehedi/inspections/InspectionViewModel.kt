package com.mehedi.inspections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InspectionViewModel : ViewModel() {

    private val _inspectionResponse = MutableLiveData<DataModel>()
    val inspectionResponse: LiveData<DataModel>
        get() = _inspectionResponse

    init {
        getInspection()
    }


    private fun getInspection() {
        _inspectionResponse.postValue(DataSource.dummyData)

    }


    private val _inspection = MutableLiveData<Inspection>()
    val inspection: LiveData<Inspection>
        get() = _inspection

    fun onClickInspection(inspection: Inspection) {
        _inspection.postValue(inspection)
    }


}