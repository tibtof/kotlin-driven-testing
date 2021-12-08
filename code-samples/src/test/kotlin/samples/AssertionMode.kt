package samples

import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.AssertionMode
import io.kotest.matchers.shouldBe

class FakeTest : FreeSpec({
    assertions = AssertionMode.Error

    "I'm here just for code coverage" {
        "word".isPalindrome() shouldBe false
    }
})
