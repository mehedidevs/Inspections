package com.mehedi.inspections.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mehedi.inspections.data.DataSource
import com.mehedi.inspections.data.Images
import com.mehedi.inspections.data.Inspection

class InspectionViewModel : ViewModel() {


    private val _inspectionResponse = MutableLiveData<List<Inspection>>()
    val inspectionResponse: LiveData<List<Inspection>>
        get() = _inspectionResponse

    private fun getInspection() {
        _inspectionResponse.postValue(DataSource.dummyInspections)

    }

    init {
        getInspection()
    }

    private val _inspection = MutableLiveData<Inspection>()
    val inspection: LiveData<Inspection>
        get() = _inspection

    fun onClickInspection(inspection: Inspection) {
        _inspection.postValue(inspection)
    }



    private val _images = MutableLiveData<Images>()
    val images: LiveData<Images>
        get() = _images

    fun onClickImages(images: Images) {
        _images.postValue(images)
    }


}