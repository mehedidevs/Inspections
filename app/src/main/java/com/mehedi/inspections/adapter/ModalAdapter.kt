package com.mehedi.inspections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.inspections.data.InspectionDetails
import com.mehedi.inspections.databinding.ItemInspectionsDetailsBinding

class ModalAdapter(private val listener: TaskAdapter.TaskClickListener) :
    ListAdapter<InspectionDetails, ModalAdapter.ModalViewHolder>(COMPARATOR) {


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


        holder.bind(getItem(position))


    }

    inner class ModalViewHolder(var binding: ItemInspectionsDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val areaAdapter = AreaAdapter(listener)
        fun bind(details: InspectionDetails) {
            binding.txtInspectionsTypeTitle.text = details.inspectionName
            areaAdapter.submitList(details.list)
            binding.rvWorkingArea.apply {
                adapter = areaAdapter
                setHasFixedSize(true)

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