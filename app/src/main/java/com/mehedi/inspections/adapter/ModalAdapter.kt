package com.mehedi.inspections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.inspections.data.InspectionDetails
import com.mehedi.inspections.databinding.ItemInspectionsDetailsBinding
import com.mehedi.inspections.utils.handleVisibility

class ModalAdapter(private val listener: TaskAdapter.TaskClickListener) :
    ListAdapter<InspectionDetails, ModalAdapter.ModalViewHolder>(COMPARATOR) {

    var inspectionDetails: InspectionDetails? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModalViewHolder {
        return ModalViewHolder(
            ItemInspectionsDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ModalViewHolder, position: Int) {
        inspectionDetails = getItem(position)
        inspectionDetails?.let {
            holder.bind(it)
        }
    }

    inner class ModalViewHolder(var binding: ItemInspectionsDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(details: InspectionDetails) {
            inspectionDetails?.let {
                val areaAdapter = AreaAdapter(it, listener)
                areaAdapter.submitList(details.list)

                binding.apply {
                    txtInspectionsTypeTitle.text = details.inspectionName
                    txtInspectionsTypeTitle.setOnClickListener {
                        rvWorkingArea.handleVisibility(txtInspectionsTypeTitle)
                    }

                    rvWorkingArea.apply {
                        adapter = areaAdapter
                        setHasFixedSize(true)
                    }
                }
            }


        }
    }


    companion object {

        val COMPARATOR = object : DiffUtil.ItemCallback<InspectionDetails>() {
            override fun areItemsTheSame(
                oldItem: InspectionDetails,
                newItem: InspectionDetails
            ): Boolean {
                return oldItem.inspectionName == newItem.inspectionName
            }

            override fun areContentsTheSame(
                oldItem: InspectionDetails,
                newItem: InspectionDetails
            ): Boolean {
                return oldItem == newItem
            }

        }


    }


}