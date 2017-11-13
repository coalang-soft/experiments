Makros in MyPy sind eine spezielle Art von Funktion, die den Programmcode als String ansieht.

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
natürlich auch in Klammern eingeschlossen sein und dann Lücken enthalten, a. `out [Hallo Welt]` und 
`m Hallo Welt` tun also nicht mehr das gleiche.

WIP
