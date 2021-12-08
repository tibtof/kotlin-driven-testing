package samples

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.should
import io.kotest.property.checkAll

class PalindromePropSpec : FreeSpec({

    "any word concatenated with it's mirror should be palindrome" {
        checkAll<String> { word ->
            word + word.reversed() should bePalindrome()
        }
    }
})
