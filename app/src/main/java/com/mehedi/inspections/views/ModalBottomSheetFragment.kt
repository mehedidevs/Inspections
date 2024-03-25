package com.mehedi.inspections.views

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mehedi.inspections.adapter.ModalAdapter
import com.mehedi.inspections.adapter.TaskAdapter
import com.mehedi.inspections.data.Images
import com.mehedi.inspections.data.Inspection
import com.mehedi.inspections.databinding.FragmentModalBottomSheetBinding
import com.mehedi.inspections.utils.toDateMonthTime
import com.mehedi.inspections.utils.toast
import kotlin.math.roundToInt


class ModalBottomSheetFragment : BottomSheetDialogFragment(), TaskAdapter.TaskClickListener {

    private lateinit var dialog: BottomSheetDialog
    private lateinit var binding: FragmentModalBottomSheetBinding
    private lateinit var behavior: BottomSheetBehavior<View>
    private lateinit var inspection: Inspection
    private lateinit var modalAdapter: ModalAdapter
    private val imageSliderFragment: ImageSliderFragment by lazy {
        ImageSliderFragment()
    }

    private val viewModel: InspectionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentModalBottomSheetBinding.inflate(inflater, container, false)



        setInspectionObserver()
        setListener()


        return binding.root
    }

    private fun setListener() {
        binding.apply {
            btnModalBack.setOnClickListener {
                this@ModalBottomSheetFragment.dismiss()
            }
            btnModalInfo.setOnClickListener {
                toast("Show Some Information ")
            }
        }

    }

    private fun setInspectionObserver() {

        viewModel.inspection.observe(viewLifecycleOwner) {
            inspection = it

            modalAdapter = ModalAdapter(this@ModalBottomSheetFragment)
            modalAdapter.submitList(inspection.inspectionDetailsList)

            binding.apply {
                txtPropertyName.text = inspection.inspectionType
                txtHotelName.text = inspection.propertyName
                txtDetails.text = getDetails(inspection)
                rvModal.adapter = modalAdapter
            }
        }


    }

    private fun getDetails(inspection: Inspection): String {
        return "${inspection.inspectionStatus.status}, ${inspection.inspectionDate.toDateMonthTime()}, by ${inspection.inspectedBy}."
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        binding.root.minimumHeight =
            ((Resources.getSystem().displayMetrics.heightPixels) * .95).roundToInt()

    }

    override fun onTaskClick(images: Images) {
        viewModel.onClickImages(images)
        imageSliderFragment.show(childFragmentManager, ImageSliderFragment.TAG)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        return dialog
    }


    companion object {
        const val TAG = "ModalBottomSheet"
    }

}