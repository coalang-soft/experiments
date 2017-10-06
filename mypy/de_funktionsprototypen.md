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
Programme sollen logischerweise nicht langsamer laufen als nötig. Das bedeutet - gerade in einer Sprache wie MyPy, wo Rekursion Schleifen komplett ersetzt - dass Rekursion optimiert werden sollte.
Eine einfach optimierbare Variante ist Endrekursion - das bedeutet, dass sich der rekursive Aufruf am Ende der Funktion befindet. Etwas wie das hier
```
def a:x:a:x+1
```
Könnte ohne Rekursion so ausgedrückt werden:
```
def a(x){
  while(true){
    x = x + 1;
  }
}
```
Das bewirkt in diesem Fall exakt das gleiche - aber auch das muss nicht immer so sein. Folgende Codestücke tun beispielsweise nicht das gleiche:
```
def a:x;y
  a:y;x
```
```
def a(x,y){
  while(true){
    x = y;
    y = x;
  }
}
```
Das Problem ist für Programmierer vermutlich offensichtlich: Der Wert von y ändert sich nie, obwohl er eigentlich mit dem von x getauscht werden sollte.
Das kann behoben werden, indem man sich die Parameter zwischenspeichert - etwa als Array:
```
def a(x,y){
  var _old = [x,y];
  while(true){
    var _new = _old.clone(); // Kopie des alten Arrays
    _new[0] = _old[1]; // neues x = altes y
    _new[1] = _old[0]; // neues y = altes x
    _old = _new;
  }
}
```
Eine auffällige Sache an diesen Übersetzungen: Es wird nie etwas zurück gegeben. Denn Endrekursive Funktionen in denen es keinen Fall gibt, wo die Rekursion abbricht, sind im Grunde Dauerschleifen. Am Beispiel einer Fakultät-Funktion kann man sehen, wie eine Übersetzung mit Rückgabewert funktioniert:
```
def f
  1:1
  n:f:n-1
```
```
def f(n){
  var _old = [n];
  while(true){
    //Parameterbedingung 1
    if(_old[0] == 1){
      return 1;
    }
    //Parameterbedingung 2
    if(true){
      //Optimierung wie oben
      var _new = _old.clone();
      _new[0] = _old[0]-1;
      _old = _new;
      continue;
    }
  }
}
```
Wichtige Dinge hierbei: Erstens wird der Klon des Parameter-Arrays nur erstellt, wenn er wirklich gebraucht wird, um Zeit zu sparen.
Zweitens endet jeder der Funktionsteile entweder mit einem `return`, oder mit `continue;`. Würde das continue fehlen, hätte die Funktion einen komplett anderen Effekt, wenn noch weitere Parameterbedingungen folgen die übereinstimmen.
