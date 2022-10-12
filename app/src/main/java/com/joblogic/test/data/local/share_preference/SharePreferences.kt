package com.example.data.local.share_preference

import android.app.Application
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.joblogic.test.data.extension.get
import com.joblogic.test.data.extension.set

class SharePreferences(application: Application) {

    companion object {
        private const val ACCESS_TOKEN = "accessToken"
        private const val REFRESH_TOKEN = "refreshToken"
        private const val APP_SECRET_SHARED_PREFS = "app_secret_shared_prefs"
    }

    private val _shared by lazy {
        EncryptedSharedPreferences.create(
            APP_SECRET_SHARED_PREFS,
            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
            application,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    var accessToken: String
        get() = _shared.get(ACCESS_TOKEN) ?: ""
        set(value) = _shared.set(ACCESS_TOKEN, value)

    var refreshToken: String
        get() = _shared.get(REFRESH_TOKEN) ?: ""
        set(value) = _shared.set(REFRESH_TOKEN, value)

}
