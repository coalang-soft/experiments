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
definiert sind.
#### Problematische Verhältnisse
WIP
