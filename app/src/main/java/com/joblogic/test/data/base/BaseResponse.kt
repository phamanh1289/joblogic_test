package com.joblogic.test.data.base

import com.joblogic.test.presentation.core.base.BaseModel


class BaseResponse<T>(val data: T) : BaseModel()