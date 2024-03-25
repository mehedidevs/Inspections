package com.mehedi.inspections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.inspections.R
import com.mehedi.inspections.data.InspectionDetails
import com.mehedi.inspections.data.TaskStatus
import com.mehedi.inspections.data.WorkingArea
import com.mehedi.inspections.databinding.ItemInspectionsAreaBinding
import com.mehedi.inspections.utils.handleVisibility
import com.mehedi.inspections.views.DividerItemDecoration
import com.mehedi.swipehelperlib.SwipeHelper

class AreaAdapter(
    private val inspectionDetails: InspectionDetails,
    private val listener: TaskAdapter.TaskClickListener
) :
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


        holder.bind(getItem(position), position)


    }

    inner class AreaViewHolder(var binding: ItemInspectionsAreaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var taskAdapter: TaskAdapter

        fun bind(workingArea: WorkingArea, position: Int) {
            taskAdapter = TaskAdapter(workingArea.list, listener)
            binding.apply {
                txtInspectionsSubTitle.text = workingArea.name

                txtInspectionsSubTitle.setOnClickListener {
                    rvTask.handleVisibility(txtInspectionsSubTitle)
                }

                binding.rvTask.apply {
                    addItemDecoration(DividerItemDecoration(binding.root.context))
                    adapter = taskAdapter
                    setHasFixedSize(true)
                }


            }


            handleRecyclerviewSwipe(position)


        }

        private fun handleRecyclerviewSwipe(position: Int) {
            val context = binding.root.context

            object : SwipeHelper(context, binding.rvTask, true) {

                override fun instantiateUnderlayButton(
                    viewHolder: RecyclerView.ViewHolder?,
                    underlayButtons: MutableList<UnderlayButton>?
                ) {

                    underlayButtons?.add(
                        UnderlayButton(
                            context,
                            R.drawable.ic_cancel,
                            "#F44336"
                        ) { pos ->
                            inspectionDetails.list[position].list[pos].taskStatus =
                                TaskStatus.CANCEL

                            taskAdapter.updateTaskList(inspectionDetails.list[position].list)
                        }
                    )

                    underlayButtons?.add(
                        UnderlayButton(
                            context,
                            R.drawable.ic_next_time,
                            "#FF9800"
                        ) { pos ->
                            inspectionDetails.list[position].list[pos].taskStatus =
                                TaskStatus.NEXT_TIME
                            taskAdapter.updateTaskList(inspectionDetails.list[position].list)

                        }
                    )

                    underlayButtons?.add(
                        UnderlayButton(
                            context,
                            R.drawable.ic_block,
                            "#B8B8B8"
                        ) { pos ->
                            inspectionDetails.list[position].list[pos].taskStatus =
                                TaskStatus.BLOCK
                            taskAdapter.updateTaskList(inspectionDetails.list[position].list)

                        }
                    )

                    underlayButtons?.add(
                        UnderlayButton(
                            context,
                            R.drawable.ic_done,
                            "#4CAF50"
                        ) { pos ->
                            inspectionDetails.list[position].list[pos].taskStatus =
                                TaskStatus.DONE
                            taskAdapter.updateTaskList(inspectionDetails.list[position].list)

                        }
                    )

                }

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