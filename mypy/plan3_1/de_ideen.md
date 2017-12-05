Es kommt relativ oft vor, dass ein Programm von der Syntax her zwar stimmt, aber dennoch irgendwas nicht funktioniert.
Beispiele hierfür sind nicht erstellte Variablen, oder das Senden einer Nachricht an ein Objekt, welches sie nicht versteht.

Für viele dieser Fälle gibt es keine optimale Lösung. Im Fall von nicht gefundenen Variablen erwarten einige direkt eine Fehlermeldung,
andere könnten die Variable jedoch bewusst nicht erstellt haben. Vielleicht wollen sie dass nicht erstellte Variablen automatisch erstellt
werden und einen Wert erhalten. Dieser Wert könnte zum Beispiel eine leere Liste sein, aber beispielsweise auch der Variablenname als
Text, um das Programm lesbarer zu halten - schließlich braucht es in diesem Fall keine Klammern `[ ]`.

Natürlich können nicht all diese Verhaltensweisen standardmäßig zutreffen, denn das funktioniert immer nur für eine Verhaltensweise.
Eine Variable kann nicht gleichzeitig ein leeres Array und ihr eigener Name zugewiesen sein.
Was aber eine Möglichkeit ist: Einen Weg einbauen, über den der Programmierer diese Verhaltensweisen selbst setzen und ändern kann.

WIP
