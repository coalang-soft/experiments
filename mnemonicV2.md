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
While this language hopefully is easy to understand (If you look at the CoaLang code `java("java.lang.System").out.println("Hello World");`), there are a few problems. First: The language uses more characters to express something than the Computer needs. Second: The language is not "smart". If other's languages compile into it, their output might not be optimized. The output of CoaLang is not completely optimized too. But of course optimized code would be faster. So it should optimize itself. Third: The language is not strongly typed. While this makes it way easier for the user, it gets slower for the Computer. It would be easier to compile into other languages with strong types too.

## Problem 1: Size
### First steps
There are a few steps to solve the "Size Problem". Here are the ones I thought of:
* Single-Character commands. Basically, `load` would become `l`, `putS` would become `s` and so on. Every instruction would only need one character.
* Remove spaces: If every instruction only needs one character, the following blank(s) are not needed. It is clear that the next characters are the parameter. If the runtime knows which instructions need parameters and which do not, the newlines (`\n`) following those without a parameter can be removed too. It is clear that the next character is an instruction again.
* Parameter list: String parameters (like `Hello World` in this example) could be stored in a global list. This list could be a resource or inside the compiled file. If an instruction needs a string, it can get an integer parameter and take the String at this index of the list. It would make small programs slightly bigger, but could save really much space in big programs.

If we apply this concepts to the sample code, we could get something like this:
```
@java                 //Index 0 of the String map
@java.lang.System     //Index 1 of the String map
@out                  //Index 2 of the String map
@println              //Index 3 of the String map
@Hello World!         //Index 4 of the String map
l0                    //load instruction. Requires a string, so it looks up index 0 of the String map
s1                    //putS instruction
c1                    //invoke
g2                    //get
g3                    //get
s4                    //putS
c1                    //invoke
p                     //pop
```
### Different goals
As you can see, the code gets shorter - except the String map - but harder to understand and to write by hand. So it does not make sense to look at this "new" shorter language as a replacement for the old one. It has the role of a Java .class file - being fast to execute - rather than the role of Jasmin (a Java Assembler), being easy to understand and write.
### Optimize for reading with streams

WIP
