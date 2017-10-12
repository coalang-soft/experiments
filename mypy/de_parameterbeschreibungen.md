Parameterbeschreibungen sind in MyPy eine wichtige Sache. Sie ersetzen beispielsweise Überladungen und viele If-Abfragen.
Dieses Dokument beschreibt, wie Parameterbeschreibungen ausgewertet werden und wann sie einen Parameter zulassen.
Grundsätzlich gilt: Parameterbedingungen werden von oben nach unten geprüft, die erste passende wird ausgewählt.

## Name ohne Bedingung
Ein benannter Parameter ohne Bedingung (ein Name, dem nichts folgt) lässt alle Werte zu.
```
def f
  a
    a
```

## Bedingung ohne Name
Ein bedingter Parameter ohne Bedingung muss mit einem Operator beginnen. Wird ein Parameter geprüft, wird sein Wert sinngemäß vor den
Operator gesetzt und dann wird die Bedingung ausgewertet - wenn sie wahr ist, wird der Parameter zugelassen, sonst nicht.
```
def f
  <6
    "Kleiner als 6"
  n
    "Nicht kleiner als 6"
```

## Name mit Bedingung
Ein benannter Parameter mit Bedingung (Name where Bedingung) lässt einen Wert zu, wenn die Bedingung wahr ist. Dabei ist der Parameter
während der Auswertung der Bedingung bereits unter seinem Namen verfügbar.
```
def f
  a where a<8
```

WIP
