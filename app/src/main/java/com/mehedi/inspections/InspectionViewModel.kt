package com.mehedi.inspections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InspectionViewModel : ViewModel() {

    private val _inspectionResponse = MutableLiveData<List<Inspection>>()
    val inspectionResponse: LiveData<List<Inspection>>
        get() = _inspectionResponse

    init {
        getInspection()
    }


    private fun getInspection() {
        _inspectionResponse.postValue(DataSource.dummyInspections)

    }


    private val _inspection = MutableLiveData<Inspection>()
    val inspection: LiveData<Inspection>
        get() = _inspection

    fun onClickInspection(inspection: Inspection) {
        _inspection.postValue(inspection)
    }


}