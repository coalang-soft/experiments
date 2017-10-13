## Grundlagen
### Hello World
```
"Hello World"'out
```
`>>` sendet einen einzelnen Wert (links) an ein Objekt (rechts).
Ist der Wert eine Liste, werden ihre Elemente einzeln an das Objekt gesendet.
`<<` funktioniert gleich, nur dass hier der Wert rechts steht und das empfangende Objekt links.
`'` hat einen ähnlichen Effekt wie `>>`, nur dass hier im Fall einer Liste die Liste selbst gesendet wird.
### Rechnen
```
1+2*3
```
Ergebnis ist 9. Operatoren werden von Links nach Rechts ausgewertet.
### Konstanten
```
3.14159265359:PI
```
### Funktionen
```
{[x true] x*x}
```
Das Senden eines Wertes an eine Funktion bedeutet sie aufzurufen. `4>>{[x true] x*x}` ist `16`.
Berechnet das Quadrat einer Zahl.
```
{
  [toTest true][stuff {[x true] stuff=toTest}] true
  [toTest true][stuff {[x true] toTest%stuff=0}] false
  [toTest true][stuff true] toTest,(stuff+1)'self
}
```
Primzahltester mit allen Parameterbeschreibungen. Vollständige Parameterbeschreibungen sind in `[]` eingefasst, bestehen aus einem Namen,
gefolgt von einem Objekt. Die Parameterbeschreibung ist dann wahr, wenn der eingehende Parameter an das Objekt gesendet wird, und 1 (true)
die Antwort ist. Folgt auf eine Parameterbeschreibung direkt eine weitere, beschreibt diese den nächsten Parameter.
## Konzepte einbauen
### "Klassen"
```
{
  [firstName true][lastName true] {
    [property {[x true] x="firstName"}] firstName
    [property {[x true] x="lastName"}] lastName
  }
}:Person;

"John","Doe"'Person:john;
"firstName","lastName">>john>>out
```
Ein "Datentyp" Person wird erstellt, der `firstName` und `lastName` als Eigenschaften hat. Eine Person `John Doe` wird zusammen gebaut,
von ihr werden Vor- und Nachname ermittelt (`"firstName","lastName">>john`) und einzeln ausgegeben.
### "Vererbung"
```
{
  [firstName true][lastName true] firstName,lastName'Person:this; {
    [property {[x true] x'this'length=1}] property'this
    [property {[x true] x="fullName"}] "firstName"'this," ",("lastName"'this)
  }
}:SpecialPerson;
```
Hier wird ein neuer Datentyp "SpecialPerson" erstellt, der alle Eigenschaften von Person unterstützt, und `fullName` hinzu fügt.
`firstName,lastName'Person:this;` erstellt eine "normale" Person als Basis. `[property {[x true] x'this'length=1}] property'this` sorgt
dafür, dass wenn `this` (die normale Person) die angeforderte Eigenschaft unterstützt, diese der Rückgabewert ist.
`[property {[x true] x="fullName"}] "firstName"'this," ",("lastName"'this)` fügt die neue Eigenschaft `fullName` hinzu, die
`firstName` und `lastName` der Person zusammen gefügt zurück gibt.
