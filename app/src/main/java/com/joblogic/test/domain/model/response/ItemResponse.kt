package com.joblogic.test.domain.model.response

import com.joblogic.test.presentation.core.base.BaseModel

class ItemResponse(
    val name: String,
    val price: Long,
    val quantity: Int,
    val type: Int,
    val id: Int,
) : BaseModel()