package com.mehedi.inspections

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mehedi.inspections.databinding.ModalBottomSheetContentBinding
import kotlin.math.roundToInt


class ModalBottomSheet : BottomSheetDialogFragment() {

    private lateinit var dialog: BottomSheetDialog
    private lateinit var binding: ModalBottomSheetContentBinding
    private lateinit var behavior: BottomSheetBehavior<View>

    private val viewModel: InspectionViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        return dialog
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.modal_bottom_sheet_content,
                container,
                false
            )
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        setInspectionObserver()
        setListener()


        return binding.root
    }

    private fun setListener() {
        binding.apply {
            btnModalBack.setOnClickListener {
                this@ModalBottomSheet.dismiss()
            }
            btnModalInfo.setOnClickListener {
                toast("Show Some Information ")
            }
        }

    }

    private fun setInspectionObserver() {

        viewModel.inspection.observe(viewLifecycleOwner) { inspection ->

            val modalAdapter = ModalAdapter()
            modalAdapter.submitList(inspection.inspectionDetailsList)

            binding.apply {
                txtPropertyName.text = inspection.propertyName
                txtHotelName.text = inspection.propertyName
                rvModal.adapter = modalAdapter


            }
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        binding.root.minimumHeight =
            ((Resources.getSystem().displayMetrics.heightPixels) * .95).roundToInt()

    }


    companion object {
        const val TAG = "ModalBottomSheet"
    }
}