Es gibt zwei Arten von Operatoren, die die einen operanden und die die zwei operanden erwarten.
## Zweier-Operatoren
* `+` addition
* `\` subtraktion (nicht `-`, das ist das negative Vorzeichen)
* `*` multiplikation
* `/` division
* `^` hoch
* `,` verketten / concat
* `|` oder / größtes
* `&` und / kleinstes
* `%` modulo / rest
* `<` kleiner als
* `>` größer als
* `=` ist gleich
* `!` ist nicht gleich
* `...` Array von...bis
* `?` Zufällige Einträge aus Array auswählen. `4,7?3` wählt 3 mal einen Eintrag aus (entweder 4 oder 7)
* ` ` (Leerzeichen) Funktion mit Parameter aufrufen. `3 f` ruft `f` mit dem Parameter `3` auf.
## Einer-Operatoren
* `+/` `-/` `*/` `//` usw: Anwenden eines Zweier-Operators für alle Elemente eines Arrays. `1,2,3+/` wäre `6`, `1,2,3,/` wäre weiterhin `1,2,3`.
* `~-` abrunden / integer-cast
* `~+` aufrunden
* `~~` runden

Steht nach einem Einer-Operator ein Wert, wird dieser als neuer Ausdruck angesehen. Diese Werte werden mit `,` zusammen gefügt.
`1,2,3+/7` ist also `6,7`.
## Rangfolge und mehrzeilige Ausdrücke
Grundsätzlich werden Operatoren von links nach rechts ausgewertet. `1+2+3` ist also `6`, aber `1+2*3` ist `9`, da `1+2` zuerst ausgewertet wird.
Eine Ausnahme bilden mehrzeilige Ausdrücke.
```
1,2,3+4,5,6

1,2,3+
4,5,6
```
Diese Beispiele haben verschiedene Ergebnisse. Beim ersten Beispiel entsteht zuerst eine Liste `1,2,3`, und auf diese Liste wird 4 addiert, also kommt bei diesem Schritt `5,6,7` heraus. Hierzu werden die verbleibenden Zahlen hinzugefügt, so dass am ende `5,6,7,5,6` heraus kommt.

Mehrzeilige Ausdrücke hingegen bestehen aus mehreren Zeilen, die mit einem Operator am ende einer Zeile (hier das `+`) verbunden sind.
Sie werden ausgewertet indem die einzelnen Zeilen zuerst sinngemäß in Klammern gesetzt, also zuerst ausgewertet werden. Diese Auswertung geschieht von oben nach unten. Man kann sich das zweite Beispiel also als `(1,2,3)+(4,5,6)` vorstellen. Hierbei käme - gemäß den unten stehenden Regeln - `5,7,9` heraus.
## Spezialfälle und Typumwandlung
Die oben genannten Operatoren ergeben zwar hoffentlich für sich Sinn, aber können auf Spezialfälle stoßen. Was passiert zum Beispiel, wenn eine Funktion zu einer Zahl addiert wird? Folgende Regeln gelten, um die Operatoren einheitlich funktionieren zu lassen:
* Strings werden als Listen von Zahlen angesehen. Die Listeneinträge sind die UTF-8 codes der Buchstaben.
* Erwartet ein Operator eine Liste als Operand und erhält keine, wird der Operand als Liste mit einem Element angesehen.
* Ist ein Operand eines Zweier-Operators eine Liste und der andere nicht, wird der andere als Liste mit einem Element angesehen.
* Sind beide Operanden eines Zweier-Operators eine Liste, wird bei ungleicher Länge die kürzere von beiden auf die Länge der längeren gebracht, indem ihre Elemente wiederholt werden.
* Wird ein Operator, der keine Liste erwartet, mit Listen als Operanden genutzt, wird er für jedes Paar aus Listeneinträgen angewendet. Der n-te Wert aus der ersten Operandenliste und der n-te Wert aus der zweiten Oparandenliste werden dafür als Operanden verwendet. `[1,2,3]*[4,5,6]` wäre `[1*4,2*5,3*6]`. Das Ergebnis ist immer eine Liste mit der Länge der längeren Operanden-Liste.
* Wird ein Operator mit mindestens einer Funktion `in` genutzt, obwohl an dieser Stelle keine Funktion erwartet wird, ist das Ergebnis ebenfalls eine Funktion. Diese wandelt falls nötig die Funktionen `in` um, indem sie sie mit ihren eigenen Parametern aufruft. Auf die Ergebniswerte wird der ursprüngliche Oparator angewendet. Sinngemäß ist also `function f+function x` `function(args) = f(args)+x(args)`, und `function l/8` `function(args) = l(args)/8`.
