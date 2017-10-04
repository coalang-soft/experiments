Schlüsselwörter gibt es in MyPy zwar, aber nur wenige. Genauer gesagt zwei, die hier beschrieben werden.
## def
`def` definiert etwas. Damit können Funktionen, Konstanten oder Datentypen definiert werden:
```
def lowerCamelCase
  parameter
  second
    parameter+second

def writtenAsYouWant=value

def UpperCamelCase
  firstField
  secondField
```
Das erste Beispiel definiert die Funktion `lowerCamelCase`. Es ist dabei wichtig, dass der Name mit einem Kleinbuchstaben anfängt. Auf der
ersten "Einrückungsstufe" befinden sich Beschreibungen der Parameter. In dem Fall soll es zwei geben, `parameter` und `second`, ohne
spezielle Bedingungen. Es kann auch mehrere Parameterbeschreibungen geben, es wird immer die erste passende (von oben) ausgewählt.
Auf der zweiten Einrückungsstufe steht dann, was die Funktion in dem Fall, dass die Parameterbeschreibung mit den übergebenen Parametern
überein stimmt, tun soll. In diesem Fall hier ist das `parameter+second`, also die Parameter zusammen zählen.

Das zweite Beispiel definiert eine Konstante. Das ist einer der wenigen Fälle, wo keine Einrückungen nötig sind. Der Name ist 
`writtenAsYouWant`, der Wert ist `value`.

Das dritte Beispiel definiert einen Datentyp namens `UpperCamelCase`. Wichtig hier: der Name muss mit einem Großbuchstaben beginnen.
Auf der ersten Einrückungsstufe stehen Felder, in dem Fall `firstField` und `secondField`. Eine tiefere Einrückung ist hier nicht erlaubt.

WIP
