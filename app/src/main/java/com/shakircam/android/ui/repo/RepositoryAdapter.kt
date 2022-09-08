package com.shakircam.android.ui.repo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.shakircam.android.core.BaseAdapter
import com.shakircam.android.databinding.RepoItemBinding
import com.shakircam.android.model.Repository


class RepositoryAdapter : BaseAdapter<Repository.Item>(DiffCallback) {


    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return RepoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        val item = getItem(position)
        (binding as RepoItemBinding).repo = item
        binding.executePendingBindings()
    }

    object DiffCallback : DiffUtil.ItemCallback<Repository.Item>() {
        override fun areItemsTheSame(oldItem: Repository.Item, newItem: Repository.Item): Boolean {
            return oldItem.full_name == newItem.full_name
        }

        override fun areContentsTheSame(oldItem: Repository.Item, newItem: Repository.Item): Boolean {
            return  oldItem == newItem
        }

    }
}