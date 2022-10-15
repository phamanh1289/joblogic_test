package com.joblogic.test.presentation.helper.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.joblogic.test.presentation.core.base.BaseListAdapter

fun RecyclerView.initAdapter(listAdapter: BaseListAdapter) {
    context?.let {
        apply {
            layoutManager = LinearLayoutManager(it)
            adapter = listAdapter
            setHasFixedSize(true)
        }
    }
}