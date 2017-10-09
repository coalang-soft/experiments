## Sinn
In MyPy kann eine Funktion (in der Theorie) nur dann definiert werden, wenn alle von ihr gebrauchten Funktionen und Konstanten ebenfalls
bereits definiert sind. Dass kann zu folgendem Problem führen:
```
def a:n:b:0
def b:n:a:0
```
Dieser Code nutzt rekursion - und darum kann er eigentlich nicht funktionieren. a braucht b und kann nicht definiert werden; b braucht a
und kann nicht definiert werden. Wie dieses Problem gelöst werden kann, ist
[hier](https://github.com/coalang-soft/experiments/blob/master/mypy/de_veraenderung.md#problematische-verhältnisse) beschrieben.

## Informationsgehalt
Das oben beschriebene / verlinkte Beispiel stellt automatisch erzeugte Funktionsprototypen vor, die folgende Informationen beinhalten:
* Name der Funktion
* In der Funktion genutzte Funktionen und Konstanten als Abhängigkeiten.

Diese Informationen reichen aber nicht immer aus, oder sind teilweise unsinnig.

### Mehrere Parameterbeschreibungen und halb-definierte Funktionen
Beispielsweise können Funktionen in MyPy ja mehrere
Parameterbeschreibungen haben. Und wenn der Code unter der einen Parameterbeschreibung bereits "definierbar" ist und der unter der
zweiten nicht - dann könnte die Funktion trotzdem garnicht genutzt werden, ob wohl die eine Hälfte bereits definiert sein könnte.
Das bedeutet, dass jeder der (durch Parameterbeschreibungen getrennten) Funktionsteile einen eigenen Prototypen haben sollte.

### Optimierbarkeit
In [diesem](https://github.com/coalang-soft/experiments/blob/master/mypy/de_rekursionsoptimierung.md) Dokument wird erklärt, wie Rekursion optimiert werden kann.
Entsprechend würde es Sinn ergeben in den Funktionsprototypen festzuhalten, mit welchem Funktionsaufruf ein Funktionsteil endet (falls das so ist). Dadurch können auch mehrere Funktionsteile zu einem zusammen gefasst werden, falls das dann besser optimierbar ist.
```
def x::y:
def y::x:
```
Das könnte zu einer Funktion optimiert werden, die dann mit einem Aufruf von x (bzw. y) enden würde.

Am Ende würden die Funktionsprototypen vom aller ersten Beispiel dann also folgenden Inhalt haben:
```
1. Funktionsteil von a nutzt (b) und endet mit Aufruf von b
1. Funktionsteil von b nutzt (a) und endet mit Aufruf von a
```
