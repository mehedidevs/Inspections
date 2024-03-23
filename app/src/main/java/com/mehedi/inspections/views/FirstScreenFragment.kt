package com.mehedi.inspections.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mehedi.inspections.data.Inspection
import com.mehedi.inspections.R
import com.mehedi.inspections.adapter.InspectionAdapter
import com.mehedi.inspections.databinding.FragmentFirstScreenBinding


class FirstScreenFragment : Fragment(), InspectionAdapter.InspectionListener {

    private lateinit var binding: FragmentFirstScreenBinding
    private lateinit var inspectionAdapter: InspectionAdapter

    private val modalBottomSheet: ModalBottomSheet by lazy {
        ModalBottomSheet()
    }

    private val viewModel: InspectionViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_first_screen, container, false)
        inspectionAdapter = InspectionAdapter(this)
        setUpInspectionList()
        setInspectionObserver()



        return binding.root
    }

    private fun setInspectionObserver() {
        viewModel.inspectionResponse.observe(viewLifecycleOwner) {
            inspectionAdapter.submitList(it)
        }
    }

    private fun setUpInspectionList() {


        binding.rvInspections.apply {
            adapter = inspectionAdapter
            setHasFixedSize(true)

        }


    }

    override fun onInspectionClicked(inspection: Inspection) {

        modalBottomSheet.show(childFragmentManager, ModalBottomSheet.TAG)
        viewModel.onClickInspection(inspection)
    }

}