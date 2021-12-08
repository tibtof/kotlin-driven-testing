package samples

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.mockk.*

interface Logger {
    fun error(f: () -> String)
}

class LoggerMockkSpec : FreeSpec({

    "it just runs" {
        val mockLogger = mockk<Logger>()
        every { mockLogger.error(any()) } just Runs

        mockLogger.error { "Test log message" }

        verify(exactly = 1) {
            mockLogger.error(withArg { f -> f() shouldBe "Test log message" })
        }
    }
})

interface DataRepository<T, ID> {
    fun find(id: ID): T
}

class DataRepositoryMockkSpec : FreeSpec({

    "processing corner case data" {
        val ns = mockk<DataRepository<String, Int>>()
        every { ns.find(any()) }.answers {
            val id = firstArg<Int>()
            when (id) {
                in 0..10 -> "valid data"
                1000 -> "corner case"
                else -> "invalid data"
            }
        }

        ns.find(1000) shouldBe "corner case"
    }
})
