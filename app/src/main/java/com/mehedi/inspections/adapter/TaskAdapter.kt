package com.mehedi.inspections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.inspections.data.Images
import com.mehedi.inspections.data.TaskDetails
import com.mehedi.inspections.data.TaskStatus
import com.mehedi.inspections.databinding.ItemTaskBinding

class TaskAdapter(private val listener: TaskClickListener) :
    ListAdapter<TaskDetails, TaskAdapter.TaskViewHolder>(COMPARATOR) {

    interface TaskClickListener {
        fun onTaskClick(images: Images)
        fun onTaskStatusUpdate(status: TaskStatus)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TaskViewHolder(var binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(details: TaskDetails) {
            binding.apply {
                txtTaskTitle.text = details.title
                txtStarCount.text = details.numberOfStar.toString()
                txtAttachCount.text = details.numberOfAttach.toString()
                txtCommentsCount.text = details.numberOfComments.toString()

                itemView.setOnClickListener {
                    listener.onTaskClick(details.images)
                }

            }


        }
    }


    companion object {

        val COMPARATOR = object : DiffUtil.ItemCallback<TaskDetails>() {
            override fun areItemsTheSame(
                oldItem: TaskDetails,
                newItem: TaskDetails
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: TaskDetails,
                newItem: TaskDetails
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}