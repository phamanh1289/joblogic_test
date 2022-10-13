package com.joblogic.test.presentation.other.adapter

import com.joblogic.test.BR
import com.joblogic.test.R
import com.joblogic.test.presentation.core.base.BaseListAdapter

class BuyAdapter (
    private val onClickItem: (Int) -> Unit,
) : BaseListAdapter() {
    override fun requestLayout() = R.layout.item_rcv_buy

    override fun requestModelXml() = BR.itemResponse

    override fun makeOnClick() = onClickItem
}