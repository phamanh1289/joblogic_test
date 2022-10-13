package com.joblogic.test.presentation.model

import com.joblogic.test.presentation.helper.enum.ErrorType

data class ErrorModel(
    val errorType: ErrorType = ErrorType.OTHER,
    val message: String = "",
)