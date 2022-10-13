package com.joblogic.test.presentation.core.base

import androidx.recyclerview.widget.DiffUtil

class BaseDiffCallBack<BM : BaseModel> : DiffUtil.ItemCallback<BM>() {
    override fun areItemsTheSame(oldItem: BM, newItem: BM): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: BM, newItem: BM): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}