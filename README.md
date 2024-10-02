# FizzBuzz
A thrilling tale of numerous FizzBuzz implementations and what to learn from
them.

## Premise
A README about FizzBuzz, without FizzBuzz. That would be a shame. Here you find
a vanilla flavored python implementation in 36 lines.

```python
def fizzbuzz(n):
    if n % 15 == 0:
        return "FizzBuzz"
    if n % 5 == 0:
        return "Buzz"
    if n % 3 == 0:
        return "Fizz"
    return f"{n}"

class FizzBuzzTest:
    def __init__(self, n):
        self.n = n

    def should_be(self, expected):
        assert fizzbuzz(self.n) == expected, f"fizzbuzz({self.n}) should equal \"{expected}\" but was \"{fizzbuzz(self.n)}\""
        
def fizzbuzz_of(n):
    return FizzBuzzTest(n)

if __name__ == "__main__":
    fizzbuzz_of(1).should_be("1")
    fizzbuzz_of(2).should_be("2")
    fizzbuzz_of(3).should_be("Fizz")
    fizzbuzz_of(4).should_be("4")
    fizzbuzz_of(5).should_be("Buzz")
    fizzbuzz_of(6).should_be("Fizz")
    fizzbuzz_of(7).should_be("7")
    fizzbuzz_of(8).should_be("8")
    fizzbuzz_of(9).should_be("Fizz")
    fizzbuzz_of(10).should_be("Buzz")
    fizzbuzz_of(11).should_be("11")
    fizzbuzz_of(12).should_be("Fizz")
    fizzbuzz_of(13).should_be("13")
    fizzbuzz_of(14).should_be("14")
    fizzbuzz_of(15).should_be("FizzBuzz")
```

You can find it under [`src/python/standard/main.py`][example:python]

## Development
We use Make to automate various tasks in this project. Run 

```plain
make
```

To kick things off.

[example:python]: https://github.com/fifth-postulate/fizzbuzz/blob/main/src/python/standard/main.py
