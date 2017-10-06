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
WIP
