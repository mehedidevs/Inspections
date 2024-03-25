package com.mehedi.inspections.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.inspections.R
import com.mehedi.inspections.data.Images
import com.mehedi.inspections.data.TaskDetails
import com.mehedi.inspections.data.TaskStatus
import com.mehedi.inspections.databinding.ItemTaskBinding

class TaskAdapter(
    private var taskList: List<TaskDetails>,
    private val listener: TaskClickListener
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    interface TaskClickListener {
        fun onTaskClick(images: Images)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateTaskList(taskList: List<TaskDetails>) {
        this.taskList = taskList
        notifyDataSetChanged()
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

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    inner class TaskViewHolder(var binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val context: Context = binding.root.context
        fun bind(details: TaskDetails) {
            binding.apply {
                txtTaskTitle.text = details.title
                txtStarCount.text = details.numberOfStar.toString()
                txtAttachCount.text = details.numberOfAttach.toString()
                txtCommentsCount.text = details.numberOfComments.toString()
                setStatusIndicator(details.taskStatus, binding.viewStatusIndicator)
                itemView.setOnClickListener {
                    listener.onTaskClick(details.images)
                }

            }


        }

        private fun setStatusIndicator(taskStatus: TaskStatus, viewStatusIndicator: View) {
            when (taskStatus) {
                TaskStatus.NO_STATUS -> {
                    viewStatusIndicator.setBackgroundColor(
                        context.resources.getColor(
                            R.color.white,
                            null
                        )
                    )
                }

                TaskStatus.DONE -> {
                    viewStatusIndicator.setBackgroundColor(
                        context.resources.getColor(
                            R.color.green,
                            null
                        )
                    )
                }

                TaskStatus.BLOCK -> {
                    viewStatusIndicator.setBackgroundColor(
                        context.resources.getColor(
                            R.color.grey,
                            null
                        )
                    )
                }

                TaskStatus.NEXT_TIME -> {
                    viewStatusIndicator.setBackgroundColor(
                        context.resources.getColor(
                            R.color.yellow,
                            null
                        )
                    )
                }

                TaskStatus.CANCEL -> {
                    viewStatusIndicator.setBackgroundColor(
                        context.resources.getColor(
                            R.color.red,
                            null
                        )
                    )
                }
            }


        }
    }


}