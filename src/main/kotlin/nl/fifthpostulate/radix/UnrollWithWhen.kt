package nl.fifthpostulate.radix

import nl.fifthpostulate.FizzBuzz

class UnrollWithWhen: FizzBuzz {
    override fun of(n: Int): String =
        when (n.toString(15).last()) {
            '0' -> "FizzBuzz"
            '3', '6', '9', 'c' -> "Fizz"
            '5', 'a' -> "Buzz"
            else -> n.toString()
        }
}