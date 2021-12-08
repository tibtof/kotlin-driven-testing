package samples

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class HelloBobTest {

    private lateinit var outBackup: PrintStream
    private val out = ByteArrayOutputStream()

    @BeforeTest
    fun setup() {
        outBackup = System.out
        System.setOut(PrintStream(out))
    }

    @Test
    fun `should greet Bob`() {
        main(*arrayOf("Bob"))

        assertEquals("Hello, Bob!", out.toString().trim())
    }

    @Test
    fun `should greet the world`() {
        main(*emptyArray())

        assertEquals("Hello, World!", out.toString().trim())
    }

    @AfterTest
    fun teardown() {
        System.setOut(outBackup)
    }
}

fun main(vararg args: String) {
    val name = if (args.isNotEmpty()) args[0] else "World"
    println("Hello, $name!")
}
