package com.joblogic.test.data.base

interface BaseMapper<E, M> {
    fun fromModel(data: E): M?
    fun toModel(data: M): E?
}