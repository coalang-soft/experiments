## Veränderung ist schlecht
Das ist zwar keine Einstellung die immer richtig ist, aber doch sehr zutreffend auf Programme, die mehrere Dinge gleichzeitig tun.
Wenn wir nämlich einmal erlauben, dass etwas verändert wird - dann kann es immer dazu kommen, dass mehrere Programmteile versuchen,
zur gleichen Zeit eine Änderung durchzuführen. Das endet im besten Fall in einem Crash, im schlimmsten Fall verhält sich das Programm
ohne Vorwarnung anders als es soll.
## Definieren und gleich lassen
Die Lösung des Problems: Was einmal definiert ist, kann nicht umdefiniert werden. Funktionen können nicht umdefiniert werden. Variablen
existieren nicht. Felder können nicht umdefiniert werden. Wenn doch etwas geändert werden muss, wird eine neue Instanz erstellt.
### Funktionen
Funktionen werden zusammen gebaut, bevor das Programm irgendwas machen kann. Bevor also das Programm richtig startet, sind die Funktionen
schon fertig und nutzbar. Mit einer Ausnahme, die jetzt erklärt wird.
### Konstanten
Konstanten sind da schon etwas schwieriger. Wie Funktionen können sie einmalig gesetzt werden - Aber anders als Funktionen werten sie den
zugewiesenen Wert vor der eigentlichen Zuweisung aus. Wann soll die Konstante zugewiesen werden - wie Funktionen vor dem eigentlichen Start
des Programmes, oder an der Stelle im Programm, wo die zuweisung steht? Die sinnvollste Möglichkeit ist zweiteres - denn bei ersterem wäre
ein zwischenspeichern von Nutzereingaben oder verarbeiteten Werten unmöglich. Das bedeutet also, dass Funktionen aufgerufen werden können,
bevor alle Konstanten gesetzt wurden. Was passiert also, wenn eine Funktion genutzt wird, in der eine noch nicht gesetzte Konstante
vorkommt? Nun, die Funktion ist zu diesem Zeitpunkt noch nicht definiert. Sie wird erst dann definiert, wenn alle gebrauchten Konstanten
und Funktionen definiert sind. Sonst könnte es unfertige / unbrauchbare Funktionen geben.
#### Problematische Verhältnisse
Dieses Verhalten kann zu einigen Problemen führen. Was passiert zum Beispiel, wenn wir folgendes tun:
```
def a:n:b:0
def b:n:a:0
```
Wir definieren hier die Funktion a, die b aufruft. Und b, die a aufruft. Wenn wir nach den Regeln von oben das Programm auswerten, sieht das so aus:
* Die Funktion a braucht die Funktion b. b ist nicht definiert. a kann also auch nicht definiert werden.
* Die Funktion b braucht die Funktion a. a ist nicht definiert (da b nicht definiert ist). b kann also auch nicht definiert werden.

Das bedeutet: Obwohl eigentlich beide Funktionen problemlos genutzt werden könnten, werden sie nicht definiert. Die Lösung dafür kennt
im Grunde jeder C++ Programmierer: Funktionsprototypen. Beschreibungen der Funktionen, die vor ihrer Definition erstellt werden. In MyPy
werden diese aber automatisch erstellt. Sie könnten folgende Bedeutung haben:
```
Funktion a braucht b und c
Funktion b braucht a und c
Funktion c braucht a und b
```
Die gebrauchten Funktionen und Konstanten kommen aus dem Code der Funktion. Und diese Definitionen können so aufgedröselt werden:
```
Funktion a braucht b und c
Funktion a braucht (wegen b) a und c und (wegen c) a und b
Funktion a braucht c und b (die Funktion selbst gibt es ja dann schon)
Funktion a braucht b und c (Das ganze nochmal, kommt auf das gleiche ergebnis wie am Anfang)
```
Das bedeutet: wenn nach dem Aufdröseln alle gebrauchten Konstanten und Funktionen bereits im Funktionsprototypen enthalten sind, funktioniert die Funktion und kann definiert werden. Durch diese Regel wird Rekursion ermöglicht. Wichtig dabei ist: die Funktion selbst kann, wenn sie in ihren Abhängigkeiten
auftaucht, sofort wieder aus ihnen entfernt werden.

Durch diese "gesicherten Abhängigkeiten" können Funktionen also nur genutzt werden, wenn sie auch garantiert funktionieren - aber bei
jeder definition einer Funktion oder Konstanten müssen die "ausstehenden" Definitionen nochmal überprüft und bei bedarf vorgenommen werden

---
