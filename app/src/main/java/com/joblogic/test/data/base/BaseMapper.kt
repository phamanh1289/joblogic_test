package com.joblogic.test.data.base

interface BaseMapper<L, R> {
    fun fromModel(data: L): R
    fun toModel(data: R): L
}