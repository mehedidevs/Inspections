package com.mehedi.inspections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.inspections.data.WorkingArea
import com.mehedi.inspections.databinding.ItemInspectionsAreaBinding

class AreaAdapter(private val listener: TaskAdapter.TaskClickListener) :
    ListAdapter<WorkingArea, AreaAdapter.AreaViewHolder>(COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        return AreaViewHolder(
            ItemInspectionsAreaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {


        holder.bind(getItem(position))


    }

    inner class AreaViewHolder(var binding: ItemInspectionsAreaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val taskAdapter = TaskAdapter(listener)

        fun bind(details: WorkingArea) {
            taskAdapter.submitList(details.list)
            binding.txtInspectionsSubTitle.text = details.name
            binding.rvTask.apply {
                adapter = taskAdapter
                setHasFixedSize(true)
            }
        }
    }


    companion object {

        val COMPARATOR = object : DiffUtil.ItemCallback<WorkingArea>() {
            override fun areItemsTheSame(
                oldItem: WorkingArea,
                newItem: WorkingArea
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: WorkingArea,
                newItem: WorkingArea
            ): Boolean {
                return oldItem == newItem
            }

        }


    }


}