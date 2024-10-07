# Ideas

This document list various ideas on tackling the implementation of FizzBuzz.
Since some of these ideas are orthogonal, we can rely on a multiplication
effect to increase the number of options

## Language
There are trivial syntactic changes that can be made to programs that make no
semantic difference.

For example, instead of using the idiomatic

```kotlin
data[n % 15] ?: n.toString()
```

to lookup a response, one could also make the `get` explicit

```kotlin
data.get(n % 15) ?: n.toString()
```

## Divisibilty
The essence of the FizzBuzz game is divisibility. There are various different
ways to determine, what is effectively, the equivalence class of a certain
number with respect to the modulus.

### `mod`
The standard implementation used the `mod` function that determines the modulus
of a number.

### Representation with different Radix
When the last digit of a representation of a number in a different radix is
zero that number is divible by the radix.

### Unrolling the loop
Knowing the remainder after division of 15 is all you need to determine the
action you need to take. You could use the following table

| Remainder | Result     |
|-----------|------------|
| 0         | "FizzBuzz" |
| 1         | "n"        |
| 2         | "n"        |
| 3         | "Fizz"     |
| 4         | "n"        |
| 5         | "Buzz"     |
| 6         | "Fizz"     |
| 7         | "n"        |
| 8         | "n"        |
| 9         | "Fizz"     |
| 10        | "Buzz"     |
| 11        | "n"        |
| 12        | "Fizz"     |
| 13        | "n"        |
| 14        | "n"        |

Where `"n"` represents the String representation of the subject under test.

This technique can be applied to various ways of looking up the result
depending on the remainder. E.g. using a switch expression, using a map for the
lookup.

### Casting out 9
There is a "well-know" calculation aid called casting out nines. This allows a
(human) computer to check if a result is plausible. In effect it can determine
if a number is divisible by nine.

The crux for decimal number (base 10) is that 10 = 9 + 1. There is a similar
test for divisibility of 11, which hinges on the fact that 10 = 11 - 1.

By inspecting the binary representation one can devise a similar test because
2 = 3 - 1 and 2^2 = 4 = 5 - 1.

Details will be in the presentation

## Technology
There are various other means then flat out implement the algorithm. Below are
a few suggestions

### SQL
One could query an prepared structured database.

### Knowledge System
One could query an knowledge system, like Prolog.

### Machine learning
One could train an machine to pick out the FizzBuzzyness of numbers.
