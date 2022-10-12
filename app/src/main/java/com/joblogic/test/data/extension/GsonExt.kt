package com.joblogic.test.data.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.parseList(data: String): ArrayList<T>? =
    fromJson(data, object : TypeToken<ArrayList<T>>() {}.type)

inline fun <reified T> Gson.parseObject(data: String): T? =
    fromJson(data, T::class.java) ?: null
