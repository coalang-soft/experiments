## Characters and meanings
* `?` - any type
* `#` - "empty" value
* `*type` - reference to a value of type `type`
* `{name} type`, `{name}` - define a name for a value to use the same value later
* `[ typeA ; typeB ; ... ]` - array of values. `type...` means "any number of `type` values"
* `typeA , typeB` - typeA and typeB are possible
* `(this is text)` - description

## Samples
Sum function
```
[ number... ] -> number |
[] -> []
```
Maximum function
```
{a} number -> {b} number -> {a} (if a is greater than b), {b} (otherwise)
```
