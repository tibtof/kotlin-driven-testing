@file:OptIn(ExperimentalKotest::class)

package samples

import io.kotest.common.ExperimentalKotest
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class PalindromeOrigSpec : FreeSpec({

    "radar should be palindrome" {
        "radar" should bePalindrome()
    }
    "level should be palindrome" {
        "radar" should bePalindrome()
    }
    "lol should be palindrome" {
        "radar" should bePalindrome()
    }
})

class PalindromeDynamicSingleSpec : FreeSpec({

    "radar".let {
        "$it should be palindrome" {
            it should bePalindrome()
        }
    }
})

class PalindromeDynamicSpec : FreeSpec({

    listOf("radar", "level", "lol").forEach {
        "$it should be palindrome" {
            it should bePalindrome()
        }
    }
})

class PalindromeWithDataSpec : FreeSpec({

    "should be palindrome: " - {
        withData("radar", "level", "lol") { word ->
            word should bePalindrome()
        }
    }
})

class PalindromeDDDNamedSpec : FreeSpec({

    withData(
        nameFn = { (word, expected) ->
            "$word should ${if (expected) "" else "not"} be palindrome"
        },
        "radar" to true,
        "42" to false
    ) { (word, expected) ->
        word.isPalindrome() shouldBe expected
    }
})
