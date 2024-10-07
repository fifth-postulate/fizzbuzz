package nl.fifthpostulate.radix

import nl.fifthpostulate.FizzBuzz

data class UnrollWithMap(val data: Map<Int, String>): FizzBuzz {
    constructor(): this(mapOf(
        0 to "FizzBuzz",
        3 to "Fizz",
        5 to "Buzz",
        6 to "Fizz",
        9 to "Fizz",
        10 to "Buzz",
        12 to "Fizz",
    ))

    override fun of(n: Int): String =
        data[n % 15] ?: n.toString()
}