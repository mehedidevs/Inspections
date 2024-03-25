package com.mehedi.inspections.views

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mehedi.inspections.R
import com.mehedi.inspections.adapter.ModalAdapter
import com.mehedi.inspections.adapter.TaskAdapter
import com.mehedi.inspections.data.Images
import com.mehedi.inspections.data.Inspection
import com.mehedi.inspections.data.InspectionDetails
import com.mehedi.inspections.databinding.ModalBottomSheetContentBinding
import com.mehedi.inspections.utils.toast
import kotlin.math.roundToInt


class ModalBottomSheet : BottomSheetDialogFragment(), TaskAdapter.TaskClickListener {

    private lateinit var dialog: BottomSheetDialog
    private lateinit var binding: ModalBottomSheetContentBinding
    private lateinit var behavior: BottomSheetBehavior<View>

    private val viewModel: InspectionViewModel by activityViewModels()

    lateinit var inspection: Inspection
    lateinit var modalAdapter: ModalAdapter

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
            this.inspection = inspection

            modalAdapter = ModalAdapter(this@ModalBottomSheet)
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

    override fun onTaskClick(images: Images) {
        Log.d(TAG, "onTaskClick: $images ")
        val bundle = Bundle()
        bundle.putParcelable("images", images)
        findNavController().navigate(R.id.action_firstScreenFragment_to_imageSliderFragment, bundle)

    }


}