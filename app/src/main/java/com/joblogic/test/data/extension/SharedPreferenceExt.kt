package com.joblogic.test.data.extension

import android.content.SharedPreferences

private fun SharedPreferences.put(operation: (SharedPreferences.Editor) -> Unit) {
    with(edit()) {
        operation(this)
        apply()
    }
}

inline fun <reified T> SharedPreferences.get(key: String): T? =
    if (contains(key)) {
        when (T::class) {
            Boolean::class -> getBoolean(key, false) as T?
            String::class -> getString(key, "") as T?
            Float::class -> getFloat(key, 0f) as T?
            Int::class -> getInt(key, 0) as T?
            Long::class -> getLong(key, 0L) as T?
            else -> null
        }
    } else {
        null
    }

fun <T> SharedPreferences.set(key: String, value: T) {
    put {
        when (value) {
            is Boolean -> it.putBoolean(key, value)
            is String -> it.putString(key, value)
            is Float -> it.putFloat(key, value)
            is Long -> it.putLong(key, value)
            is Int -> it.putInt(key, value)
        }
    }
}

fun SharedPreferences.remove(key: String) {
    put { it.remove(key) }
}

fun SharedPreferences.clearAll() {
    put { it.clear() }
}

