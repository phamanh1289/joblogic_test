package com.joblogic.test.presentation.model

import com.joblogic.test.presentation.core.base.BaseModel

data class ItemModel(
    val title: String,
    val price: Long,
    val quantity: Int
) : BaseModel() {
}