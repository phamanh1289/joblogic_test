package com.joblogic.test.usecase

import com.joblogic.test.domain.usecase.BuyUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.unmockkAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class BuyUseCaseTest : MainRepoMockTest() {

    private lateinit var buyUseCase: BuyUseCase

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        buyUseCase = BuyUseCase(mainRepo = mockMainRepo)
    }

    @Test
    fun getListBuyTest() {
        val countDownLatch = CountDownLatch(1)
        coEvery {
            mockMainRepo.getItemBuy({
                countDownLatch.countDown()
            }, {})
        } answers {
            countDownLatch.countDown()
        }
        countDownLatch.await(10, TimeUnit.SECONDS)

    }

    @AfterEach
    fun clearMockk() {
        unmockkAll()
    }
}