### Hello World
```
[Hello World] out;
```
In `[]` eingeschlossener Text ist ein String. `[Hallo;Welt]` ist ein String-Array, da `;` die
Elemente `Hallo` und `Welt` trennt. `[Hallo\;Welt]` hingegen ist der String "Hallo;Welt".
### Arrays
```
[1;3;5;0] ! foreach out;
```
Gibt jede Zahl in dem Array `1,3,5,0` aus. Arrays werden durch `[] !` erstellt, wobei die Elemente im Array durch `;` getrennt werden.
`[1;3;5;0]` an sich ist ein String-Array, durch `!` wird jedes Element als Code ausgewertet.
```
[1;3;5;0] ! zip +;
```
Addiert alle Zahlen im Array.
```
[1;100] ! for out;
```
Gibt alle Zahlen von 1 bis 100 aus.
```
[1;2] / 1 out
```
Gibt 2 aus. `/` wählt ein Element aus dem Array aus, wie `array[1]` in anderen Sprachen. Arrays sind 0-basiert.
```
[1;2] / push 1 3
```
Das Ergebnis ist `[1;3;2]`. `push` erwartet einen Index (1) und einen Wert (3). Der Wert wird an die Stelle des Index gesetzt - alles dahinter wird "nach hinten" verschoben. `push 0` fügt also Werte an den Anfang des Arrays an.
### Variablen
```
1 + 5 : [a];
[1 + 5] ! : [a];
```
Speichert in beiden Fällen den Wert von `1 + 5` in der Variablen `a`.
```
[Hallo;Welt] : [a;b];
```
Speichert "Hallo" in `a` und "Welt" in `b`.
### Funktionen
```
[[Hello World] out] $ [];
```
Erstellt eine parameterlose Funktion, die "Hello World" ausgibt.
```
[x out] $ [x];
```
Erstellt eine Funktion mit Parameter x, die ihren Parameter ausgibt.
```
[x + y out] $ [x;y] : [sampleStuff];
sampleStuff 4 7
```
Erstellt eine Funktion mit zwei Parametern, die sie zusammenrechnet und das Ergebnis ausgibt. Diese Funktion wird unter dem Namen `sampleStuff` gespeichert und mit den Parametern `4` und `7` aufgerufen.
```
[1 +] ! : [increment];
increment 7
```
Erstellt eine Funktion increment, die ihren Parameter um 1 erhöht.
```
unknownFunction / 0;
unknownFunction / 3 [a] 2 [c]
```
Bestimmte Funktionen (etwa aus eingebundenen Bibliotheken) können verschieden viele Parameter erwarten. In diesem Fall kann mit `/`
angegeben werden, welche Version genutzt werden soll - denn solche Funktionen sind im ersten Moment auch eine art Array. In diesem Beispiel wird die Version mit keinem und drei Parametern verwendet.

WIP
