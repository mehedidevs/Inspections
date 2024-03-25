package com.mehedi.inspections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.inspections.data.Inspection
import com.mehedi.inspections.databinding.ItemInspectionsBinding
import com.mehedi.inspections.utils.toDateMonth

class InspectionAdapter(private val listener: InspectionListener) :
    ListAdapter<Inspection, InspectionAdapter.InspectionViewHolder>(COMPARATOR) {


    fun interface InspectionListener {
        fun onInspectionClicked(inspection: Inspection)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspectionViewHolder {
        return InspectionViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: InspectionViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }


    class InspectionViewHolder(private val binding: ItemInspectionsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(inspection: Inspection, listener: InspectionListener) {
            binding.apply {
                txtInspectionsTitle.text = inspection.inspectionType
                txtInspectionsSubTitle.text = inspection.propertyName
                txtInspectionsDate.text = inspection.inspectionDate.toDateMonth()
                itemView.setOnClickListener {
                    listener.onInspectionClicked(inspection)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup) = InspectionViewHolder(
                ItemInspectionsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )


        }

    }


    companion object {

        val COMPARATOR = object : DiffUtil.ItemCallback<Inspection>() {
            override fun areItemsTheSame(oldItem: Inspection, newItem: Inspection): Boolean {

                return oldItem.propertyName == newItem.propertyName
            }

            override fun areContentsTheSame(oldItem: Inspection, newItem: Inspection): Boolean {
                return oldItem == newItem
            }
        }


    }

}