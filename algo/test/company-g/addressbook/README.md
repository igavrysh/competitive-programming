# Addressbook

You have address book in a form `(number, city, street, state)` records - all not null fields

And have a query: `(number, city, street, state)` - same set of fields, but some of the fields can be `null`

Return `boolean`: if any of the records in address book match the search query.

`NULL` = any

Search is case sensitive, e.g. NewYork and newYork are different cities. No regular expressions etc - only full word match is required

**Example**

```
addressbook = [
    (number: 42, city: "Seattle", street: "Brandon", state: "Washington"),
    (number: 42, city: "San Francisco", street: "baz", state: "foobar")
]
```

calls:

```
query: (number: null, city: "Seattle", street: null, state: "Washington") should return true
as 1 record in addressbook satisfies search query: (number: 42, city: "Seattle", street: "Brandon", state: "Washington")

query: (number: 42, city: "Seattle", street: "Xoxoxo", state:null) should return false
as 0 records in addressbook satisfies search query, there is no city with name Xoxoxo in Seattle

query: (number: null, city: null, street: null, state:null) should return true
as 2 records in addressbook satisfies search query

query: (number: null, city: "seattle", street: null, state: "Washington") 
should return false
s Seattle in address book starts with capital letter
```
