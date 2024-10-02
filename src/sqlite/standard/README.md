# sqlite

[sqlite][official:sqlite] is a

> small, fast, self-contained, high-reliability, full-featured, SQL database
> engine.

## Development
To create a sqlite database with fizzbuzz data run

```plain
sqlite3 fizzbuzz.sqlite < create.sql
```

Once the sqlite database is create start a session

```plain
sqlite3 fizzbuzz.sqlite
```

And query the database with fizzbuzz related questions

```sql
SELECT response FROM fizzbuzz WHERE n=15;
```

[official:sqlite]: https://www.sqlite.org/
