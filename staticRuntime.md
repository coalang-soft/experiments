June 2nd 2017. By Matthias Huber

# Static Runtime - smart evaluation at compile time
It is really handy if the Computer can optimize a program for speed. This is what the **Static Runtime** concept is about.
## Goal
* Convert variables to constants if they never change (again)
* Evaluate operators (functions which return a value that only depends on its parameters) at compile time
* If a value, variable or function is never used, do not compile it
* Parameter type check, even if the language is not strongly typed
## Needed informations at compile time
* Is the return value of a function "not random" (only depends on parameters, outer scopes, ...) or random (can return different values every time) ?
* Which variable is visible in which scope? (In which scope) are not existing but used Variables created? Is there a default value for variables or parameters? Is there a default return value for functions?
* Type information for the language standard. Which variables exist, which type do they have, which functions exist and which return types and parameter types they have.

WIP
