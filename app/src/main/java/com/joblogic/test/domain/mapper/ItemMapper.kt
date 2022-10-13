package com.joblogic.test.domain.mapper

import com.joblogic.test.data.base.BaseMapper
import com.joblogic.test.data.local.database.entity.ItemEntity
import com.joblogic.test.domain.model.response.ItemResponse

class ItemMapper : BaseMapper<ItemResponse, ItemEntity> {
    override fun fromModel(data: ItemResponse) = ItemEntity(
        id = data.id, name = data.name, price = data.price, quantity = data.quantity,
        type = 2
    )

    override fun toModel(data: ItemEntity) = ItemResponse(
        id = data.id, name = data.name, price = data.price, quantity = data.quantity, type = 1
    )
}