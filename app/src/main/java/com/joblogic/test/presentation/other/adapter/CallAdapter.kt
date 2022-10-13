package com.joblogic.test.presentation.other.adapter

import com.joblogic.test.BR
import com.joblogic.test.R
import com.joblogic.test.presentation.core.base.BaseListAdapter

class CallAdapter(
    private val onClickItem: (Int) -> Unit,
) : BaseListAdapter() {
    override fun requestLayout() = R.layout.item_rcv_call

    override fun requestModelXml() = BR.userResponse

    override fun makeOnClick() = onClickItem
}