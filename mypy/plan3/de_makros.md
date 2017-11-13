Makros in MyPy sind eine spezielle Art von Funktion, die den Programmcode als String ansieht und in der erstellte Variablen nicht in einem eigenen Scope sind.

## Grundlagen
### Makro erstellen
Um ein Makro zu erstellen, wird die `macro`-Funktion verwendet. Sie erwartet als Argument eine andere Funktion, die zu einem Makro
gemacht werden soll.
```
macro out : [m]
```
Erzeugt ein Makro aus der Funktion `out`.
### Makro nutzen
```
m Hallo
out [Hallo]
```
Diese beiden Zeilen tun genau das Gleiche - "Hallo" ausgeben. Der wichtige Unterschied: Beim Makro wird das "Hallo" als String genutzt,
obwohl es nicht in eckigen Klammern steht. Stattdessen werden Parameter von Makros durch Leerzeichen abgegrenzt - sie können
natürlich auch in Klammern eingeschlossen sein und dann Lücken enthalten, aber dann sind die Klammern im String enthalten. `out [Hallo Welt]` und 
`m Hallo Welt` tun also nicht mehr das gleiche.

## Syntax erstellen
Angenommen wir wollen folgende Syntax ermöglichen:
```
var x = [Some Value]
```
Das geht mit Makros! Wir erstellen zuerst ein "Dummy"-Makro `var`:
```macro ([] $ [name;equals;value]) : [var]```
Dieses Makro erwartet 3 Parameter: Einen Namen, ein Gleichheitszeichen (werden wir erstmal ignorieren) und einen Wert.
Wenn wir diese Namen nutzen, können wir die gewünschte Wirkung so beschreiben:
```
value : [name]
```
Da aber `name` und `value` bei diesem Makro beide String-Werte haben, ergibt sich folgendes:
```
value ! : name
```
Und als letztes wird das noch in unser Makro eingebaut:
```
macro ([value ! : [name]] $ [name;equals;value]) : [var]
```

WIP
