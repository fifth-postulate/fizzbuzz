package nl.fifthpostulate.castingnines

import nl.fifthpostulate.FizzBuzz

class CastingNines : FizzBuzz {
    override fun of(n: Int): String {
        val divisibility3 = alternatingDigitSum(2, 1, n) % 3 == 0
        val divisibility5 = alternatingDigitSum(4, 1, n) % 5 == 0
        if (divisibility5 && divisibility3) {
            return "FizzBuzz"
        }
        if (divisibility5) {
            return "Buzz"
        }
        if (divisibility3) {
            return "Fizz"
        }
        return n.toString()
    }
}

fun alternatingDigitSum(base: Int, multiplier: Int, subject: Int): Int {
    val quotient = subject / base
    val addend = multiplier * (subject % base)
    return if (quotient == 0) {
        addend
    } else {
       addend + alternatingDigitSum(base, multiplier * -1, quotient)
    }
}