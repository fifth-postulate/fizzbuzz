package nl.fifthpostulate.lookup

import nl.fifthpostulate.FizzBuzz

class Fizzer : FizzBuzz {
    override fun of(n: Int): String = "Fizz"
}
class Buzzer : FizzBuzz {
    override fun of(n: Int): String = "Buzz"
}
class FizzBuzzer : FizzBuzz {
    override fun of(n: Int): String = "FizzBuzz"
}
class Number : FizzBuzz {
    override fun of(n: Int): String = n.toString()
}

class Lookup : FizzBuzz {
    private val l = listOf(
        FizzBuzzer(), Number(), Number(), Fizzer(), Number(),
        Buzzer(), Fizzer(), Number(), Number(), Fizzer(),
        Buzzer(), Number(), Fizzer(), Number(), Number(),
    )
    override fun of(n: Int): String {
        return l[n % 15].of(n)
    }
}
