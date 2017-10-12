Schlüsselwörter gibt es in MyPy zwar, aber nur wenige. Sie werden hier beschrieben.
## def und let
`def` definiert Funktionen und Datentypen, `let` definiert Konstanten:
```
def lowerCamelCase
  parameter
  second
    parameter+second

let writtenAsYouWant
  value

def UpperCamelCase
  firstField
  secondField
```
Das erste Beispiel definiert die Funktion `lowerCamelCase`. Es ist dabei wichtig, dass der Name mit einem Kleinbuchstaben anfängt. Auf der
ersten "Einrückungsstufe" befinden sich Beschreibungen der Parameter. In dem Fall soll es zwei geben, `parameter` und `second`, ohne
spezielle Bedingungen. Es kann auch mehrere Parameterbeschreibungen geben, es wird immer die erste passende (von oben) ausgewählt.
Auf der zweiten Einrückungsstufe steht dann, was die Funktion in dem Fall, dass die Parameterbeschreibung mit den übergebenen Parametern
überein stimmt, tun soll. In diesem Fall hier ist das `parameter+second`, also die Parameter zusammen zählen.

Das zweite Beispiel definiert eine Konstante. Der Name ist 
`writtenAsYouWant`, der Wert ist `value`.

Das dritte Beispiel definiert einen Datentyp namens `UpperCamelCase`. Wichtig hier: der Name muss mit einem Großbuchstaben beginnen.
Auf der ersten Einrückungsstufe stehen Felder, in dem Fall `firstField` und `secondField`. Eine tiefere Einrückung ist hier nicht erlaubt.

### Anonyme Funktionen
Eine anonyme Funktion kann so erstellt werden:
```
def
    4
```
Das ist eine Funktion, die 4 zurück gibt. Der einzige Unterschied zu benannten Funktionen ist, dass kein Name angegeben ist. Zu beachten
ist, dass die 4 sich nicht auf der ersten Einrückungsstufe befindet - dann würde sie einen Parameter beschreiben - so ist sie der Rückgabewert. Die oben geschriebene Funktion ist gleichbedeutend mit `def::4`.
## where
`where` erweitert die Möglichkeiten, Parameter zu beschreiben. Folgende Möglichkeiten existieren dafür:
```
def f
  a
  <9
  b where a<b
    a+b
```
Der erste Parameter ist ein benannter Parameter ohne Bedingung, der zweite ist ein unbenannter Parameter mit Bedingung. Diese beiden
Fälle sind ohne `where` möglich. Aber wenn ein benannter Parameter mit Bedingung gebraucht wird, geht das nur mit `where`. Der Name
des Parameters steht davor, die Bedingung danach. In der Bedingung muss der Parameter nicht vorne stehen.

### Eigenschaften erwarten
```
def f
  a where #firstName,#lastName'a length=2
    a.firstName," ",a.lastName
```
Diese Funktion erwartet ein Objekt mit den Eigenschaften `firstName` und `lastName`. Sie fügt Vor- und Nachnamen der Person zum vollen
Namen zusammen.
