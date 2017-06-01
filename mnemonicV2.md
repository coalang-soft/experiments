June 1st 2017.
By Matthias Huber

# Mnemonic V2 - aka Bytecode
## CoaLang Mnemonics
[The CoaLang programming language](https://www.github.com/ccldev/use-ccl) is compiled into an assembler-like language. This language was designed to be relatively easy to understand, the main goal was to create an easy platform for other programming languages. This language has not an official name, but I like to call it **CoaLang Mnemonics**.
### Hello World Mnemonics
Here is the "Hello World!" program, written in CoaLang Mnemonics:
```
load java
putS java.lang.System
invoke 1
get out
get println
putS Hello World!
invoke 1
pop
```
### Problems
While this language hopefully is easy to understand (If you look at the CoaLang code `java("java.lang.System").out.println("Hello World");`), there are a few problems. First: The language uses more characters to express something than the Computer needs. Second: The language is not "smart". If other's languages compile into it, their output might not be optimized. The output of CoaLang is not completely optimized too. But of course optimized code would be faster. So it should optimize itself. Third: The language is not strongly typed. While this makes it way easier for the user, it gets slower for the Computer.

## Problem 1: Size
### First steps
There are a few steps to solve the "Size Problem". Here are the ones I thought of:
* Single-Character commands. Basically, `load` would become `l`, `putS` would become `s` and so on. Every instruction would only need one character.
* Remove spaces: If every instruction only needs one character, the following blank(s) are not needed. It is clear that the next characters are the parameter. If the runtime knows which instructions need parameters and which do not, the newlines (`\n`) following those without a parameter can be removed too. It is clear that the next character is an instruction again.

WIP
