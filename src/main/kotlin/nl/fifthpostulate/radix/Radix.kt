package nl.fifthpostulate.radix

import nl.fifthpostulate.FizzBuzz

class Radix: FizzBuzz {
    override fun of(n: Int): String {
        if (n.toString(15).endsWith('0')) {
            return "FizzBuzz"
        }
        if (n.toString(5).endsWith('0')) {
            return "Buzz"
        }
        if (n.toString(3).endsWith('0')) {
            return "Fizz"
        }
        return n.toString()
    }
}