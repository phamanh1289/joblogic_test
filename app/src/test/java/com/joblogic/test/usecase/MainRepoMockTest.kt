package com.joblogic.test.usecase

import com.joblogic.test.domain.repo.MainRepo
import io.mockk.mockk

open class MainRepoMockTest {
    protected val mockMainRepo: MainRepo = mockk()
}