package samples

import io.kotest.assertions.print.print
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.neverNullMatcher
import io.kotest.matchers.should
import io.kotest.matchers.shouldNot

fun bePalindrome(): Matcher<String?> = neverNullMatcher { value ->
    MatcherResult(
        passed = value.isPalindrome(),
        failureMessageFn = { "${value.print().value} should be palindrome" },
        negatedFailureMessageFn = { "${value.print().value} should not be palindrome" }
    )
}

class PalindromeSpec : FreeSpec({

    "radar should be palindrome" {
        "radar" should bePalindrome()
    }

    "kotlin should not be palindrome" {
        "kotlin" shouldNot bePalindrome()
    }

    "let's trigger some failures to check the messages".config(enabled = false) - {
        "false negative" {
            "radar" shouldNot bePalindrome()
        }
        "false positive" {
            "kotlin" should bePalindrome()
        }
        "what about null" {
            null shouldNot bePalindrome()
        }
    }
})
