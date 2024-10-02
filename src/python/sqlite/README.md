# FizzBuzz in python
This is a python implementation of FizzBuzz using sqlite3

## Development
### Environment
Make sure to create an venv directory with the following command

```plain
python3 -m venv .venv
```

And source the correct file for your environment. E.g.

```plain
source .venv/bin/activate
```

Then install the dependencies with

```plain
pip install -r requirements.txt
```

### sqlite3
Create a sqlite database with the following command

```plain
sqlite3 fizzbuzz.sqlite < create.sql
```

The [create.sql][link:create.sql] can be found in the sqlite section.

### Execution
`main.py` is a selfcontained python program that tests the FizzBuzz
implementation. If you want to develop you can execute `tdd`. This is a fish
shell script that wathes the `main.py` and on writes runs it.

[link:create.sql]: https://github.com/fifth-postulate/fizzbuzz/blob/main/src/sqlite/standard/create.sql
