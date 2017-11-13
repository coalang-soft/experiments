Obwohl in MyPy das meiste ein Wert ist, gibt es ein paar Ausnahmen:

## Doppelpunkt :
Der Doppelpunkt erstellt eine Variable - und das ist auch der Grund, warum er weder Funktion noch Makro sein kann.
Wäre er eine Funktion, könnte er nur in seinem Funktions-Scope eine Variable erstellen. Aber in beiden Fällen gäbe es ein schwerwiegenderes
Problem: Was, wenn wir eine Funktion in eine Variable speichern wollen? Das ginge nur so:
```
: function [name]
```
Das lässt sich nicht gut in weiteren Code einbauen, und wenn man die "normale" Variante `value : [name]` nutzt, müsste man ständig
aufpassen, dass `value` keine Funktion ist - daher ist `:` ein Spezialzeichen und bedeutet immer "Variable mit Wert erstellen".
