package samples

import io.kotest.core.spec.style.*
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.haveLength

class PalindromeAnnotationSpec : AnnotationSpec() {
    @Test
    fun `radar should be palindrome`() {
        "radar".isPalindrome() shouldBe true
    }
}

class PalindromeStringSpec : StringSpec({

    "radar should be palindrome" {
        "radar".isPalindrome() shouldBe true
    }
})

class PalindromeFunSpec : FunSpec({

    test("radar should be palindrome") {
        "radar".isPalindrome() shouldBe true
    }
})

class PalindromeBehaviorSpec : BehaviorSpec({

    given("the word radar") {
        val word = "radar"

        `when`("testing if it is palindrome") {
            val isPalindrome = word.isPalindrome()

            then("the result should be true") {
                isPalindrome shouldBe true
            }
        }
    }
})

class PalindromeDescribeSpec : DescribeSpec({

    describe("radar") {
        it("is palindrome") {
            "radar".isPalindrome() shouldBe true
        }

        it("has length 5") {
            "radar" should haveLength(5)
        }
    }
})

class PalindromeFeatureSpec : FeatureSpec({

    feature("test if a string is palindrome") {
        scenario("radar is palindrome") {
            "radar".isPalindrome() shouldBe true
        }
    }
})


class PalindromeWordSpec : WordSpec({

    "radar" should {
        "be palindrome" {
            "radar".isPalindrome() shouldBe true
        }
        "have length 5" {
            "radar" should haveLength(5)
        }
    }
})

class PalindromeShouldSpec : ShouldSpec({

    context("radar") {
        should("be palindrome") {
            "radar".isPalindrome() shouldBe true
        }
        should("have length 5") {
            "radar" should haveLength(5)
        }
    }
})

class PalindromeExpectSpec : ExpectSpec({

    context("radar") {
        expect("be palindrome") {
            "radar".isPalindrome() shouldBe true
        }
        expect("have length 5") {
            "radar" should haveLength(5)
        }
    }
})

class PalindromeFreeSpec : FreeSpec({

    "radar" - {
        "should be palindrome" {
            "radar".isPalindrome() shouldBe true
        }
        "should have length 5" {
            "radar" should haveLength(5)
        }
    }
})

class PalindromeFreeLetSpec : FreeSpec({

    "radar".let {
        it - {
            "should be palindrome" {
                it.isPalindrome() shouldBe true
            }
            "should have length 5" {
                it should haveLength(5)
            }
        }
    }
})

class PalindromeFreeWithSpec : FreeSpec({

    with("radar") {
        this - {
            "should be palindrome" {
                isPalindrome() shouldBe true
            }
            "should have length 5" {
                length shouldBe 5
            }
        }
    }
})
