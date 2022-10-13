package com.joblogic.test.presentation.core.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executors

abstract class BaseListAdapter : ListAdapter<BaseModel, BaseListAdapter.BaseHolder>(
    AsyncDifferConfig.Builder(BaseDiffCallBack())
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {
    lateinit var binding: ViewDataBinding

    protected abstract fun requestLayout(): Int

    @LayoutRes
    protected abstract fun requestModelXml(): Int

    protected abstract fun makeOnClick(): ((Int) -> Unit)?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            requestLayout(),
            parent,
            false
        )
        return BaseHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    open inner class BaseHolder(var binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(model: BaseModel) {
            binding.apply {
                setVariable(requestModelXml(), model)
                executePendingBindings()
            }
            itemView.setOnClickListener {
                makeOnClick()?.let {
                    it(absoluteAdapterPosition)
                }
            }
        }
    }
}