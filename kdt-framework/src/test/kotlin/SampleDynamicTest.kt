import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class SampleDynamicTest {

    @Test
    fun `radar should be palindrome`() {
        assertTrue("radar".isPalindrome())
    }

    @TestFactory
    fun `dynamic test`(): List<DynamicTest> {
        val test = DynamicTest.dynamicTest("radar should be palindrome") {
            assertTrue("radar".isPalindrome())
        }
        return listOf(test)
    }

    private val tests = mutableListOf<DynamicTest>()

    @TestFactory
    fun `dynamic tests`() = tests

    init {
        tests += DynamicTest.dynamicTest("radar should be palindrome") {
            assertTrue("radar".isPalindrome())
        }
    }
}