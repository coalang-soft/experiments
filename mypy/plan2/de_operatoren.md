Jeder Operator erwartet zwei Operanden.
* `+` addition
* `\` subtraktion (nicht `-`, das ist das negative Vorzeichen)
* `*` multiplikation
* `%` division (nicht `/`, das steht für da Anwenden eines Operators für alle Elemente eines Arrays, siehe unten)
* `%%` modulo / rest
* `^` hoch
* `,` verketten / concat
* `|` oder / größtes
* `||` oder auf Listen / Ergebnis sind alle Elemente, die in mindestens einer der Operandenlisten vorkommen. `(1,2,3)||(2,3,4)` wäre `1,2,3,4`
* `&` und / kleinstes
* `&&` und auf Listen / Ergebnis sind alle Elemente, die in beiden der Operandenlisten vorkommen. `(1,2,3)&&(2,3,4)` wäre `2,3`
* `<` kleiner als
* `>` größer als
* `=` ist gleich
* `!` ist nicht gleich
* `..` Array von...bis
* `?` Zufällige Einträge aus Array auswählen. `4,7?3` wählt 3 mal einen Eintrag aus (entweder 4 oder 7)
* `>'` Nachricht (im Falle einer Liste die Liste; links) an Objekt (rechts) senden. `"xy">'8` sendet die Nachricht `"xy"` an das Objekt `8`.
* `<'` Nachricht (im Falle einer Liste die Liste; rechts) an Objekt senden (links). `"xy"<'8` sendet die Nachricht `8` an das Objekt `"xy"`.
* `>>` Nachricht (im Falle einer Liste jedes Element einzeln; links) an Objekt (rechts) senden.
* `<<` Nachricht (im Falle einer Liste jedes Element einzeln; rechts) an Objekt (links) senden.

* `/+` `/-` `/*` `/%` usw: Anwenden eines Operators für alle Elemente eines Arrays. `1,2,3/+0` wäre `6`, `1,2,3/,_` wäre weiterhin `1,2,3`. Der rechte Operand ist ein Wert, der quasi an das Array angefügt wird - so kann z.B. im Fall eines leeren eingabe-Arrays das
Ergebnis bestimmt werden.
* `~` runden. Mit einer Zahl kleiner 0 als rechter Operator wird abgerundet, bei größer 0 wird aufgerundet, und bei 0 wird aufgerundet
sobald der "komma-Wert" größer oder gleich `0.5` ist; sonst wird abgerundet.

## Rangfolge und Klammern
Grundsätzlich werden Operatoren von links nach rechts ausgewertet. `1+2+3` ist also `6`, aber `1+2*3` ist `9`, da `1+2` zuerst ausgewertet wird.
Eine Ausnahme bilden runde Klammern `()`.
```
1,2,3+4,5,6

1,2,3+(4,5,6)
```
Diese Beispiele haben verschiedene Ergebnisse. Beim ersten Beispiel entsteht zuerst eine Liste `1,2,3`, und auf diese Liste wird 4 addiert, also kommt bei diesem Schritt `5,6,7` heraus. Hierzu werden die verbleibenden Zahlen hinzugefügt, so dass am ende `5,6,7,5,6` heraus kommt.

Bei Ausdrücken mit Klammern wird der Klammerninhalt zuerst ausgewertet - weiterhin von links nach rechts. Beim zweiten Beispiel käme - gemäß den unten stehenden Regeln - `5,7,9` heraus.
## Spezialfälle und Typumwandlung
Die oben genannten Operatoren ergeben zwar hoffentlich für sich Sinn, aber können auf Spezialfälle stoßen. Was passiert zum Beispiel, wenn eine Funktion zu einer Zahl addiert wird? Folgende Regeln gelten, um die Operatoren einheitlich funktionieren zu lassen:
* Strings werden als Listen von Zahlen angesehen. Die Listeneinträge sind die UTF-8 codes der Buchstaben.
* Erwartet ein Operator eine Liste als Operand und erhält keine, wird der Operand als Liste mit einem Element angesehen.
* Ist ein Operand eine Liste und der andere nicht, wird der andere als Liste mit einem Element angesehen.
* Sind beide Operanden eine Liste, wird bei ungleicher Länge die kürzere von beiden auf die Länge der längeren gebracht, indem ihre Elemente wiederholt werden.
* Wird ein Operator, der keine Liste erwartet, mit Listen als Operanden genutzt, wird er für jedes Paar aus Listeneinträgen angewendet. Der n-te Wert aus der ersten Operandenliste und der n-te Wert aus der zweiten Oparandenliste werden dafür als Operanden verwendet. `1,2,3*(4,5,6)` wäre `(1*4),(2*5),(3*6)`. Das Ergebnis ist immer eine Liste mit der Länge der längeren Operanden-Liste.
* Wird ein Operator mit mindestens einer Funktion `in` genutzt, obwohl an dieser Stelle keine Funktion erwartet wird, ist das Ergebnis ebenfalls eine Funktion. Diese wandelt die Funktionen `in` um, indem sie sie mit ihren eigenen Parametern aufruft. Auf die Ergebniswerte wird der ursprüngliche Oparator angewendet. Sinngemäß ist also `function f+function x` `function(args) = f(args)+x(args)`, und `function l/8` `function(args) = l(args)/8`.
