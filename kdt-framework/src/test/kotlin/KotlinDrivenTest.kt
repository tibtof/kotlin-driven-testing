import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.opentest4j.AssertionFailedError

abstract class KotlinDrivenTest(body: KotlinDrivenTest.() -> Unit) {

    private val tests = mutableListOf<DynamicTest>()

    init {
        body()
    }

    operator fun String.invoke(test: () -> Unit) {
        tests += DynamicTest.dynamicTest(this, test)
    }

    @TestFactory
    fun suite() = tests

    fun <T> withData(vararg args: T, test: (T) -> Unit) = args.toList().forEach {
        test(it)
    }

    infix fun <T> T.shouldBe(expected: T) {
        if (this != expected) {
            throw AssertionFailedError("expected: <$expected> but was: <$this>", expected, this)
        }
    }
}

class PalindromeTest : KotlinDrivenTest({
    val radar = "radar"

    listOf("radar", "lol", "level").forEach {
        "$it should be palindrome" {
            it.isPalindrome() shouldBe true
        }
    }

    withData("radar", "lol", "level") {
        "$it should be palindrome" {
            it.isPalindrome() shouldBe true
        }
    }

    "$radar should have size 5" {
        radar.length shouldBe 5
    }
})


fun String.isPalindrome() = this == this.reversed()
