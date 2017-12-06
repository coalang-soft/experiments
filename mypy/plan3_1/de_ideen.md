## 1
Es kommt relativ oft vor, dass ein Programm von der Syntax her zwar stimmt, aber dennoch irgendwas nicht funktioniert.
Beispiele hierfür sind nicht erstellte Variablen, oder das Senden einer Nachricht an ein Objekt, welches sie nicht versteht.

Für viele dieser Fälle gibt es keine optimale Lösung. Im Fall von nicht gefundenen Variablen erwarten einige direkt eine Fehlermeldung,
andere könnten die Variable jedoch bewusst nicht erstellt haben. Vielleicht wollen sie dass nicht erstellte Variablen automatisch erstellt
werden und einen Wert erhalten. Dieser Wert könnte zum Beispiel eine leere Liste sein, aber beispielsweise auch der Variablenname als
Text, um das Programm lesbarer zu halten - schließlich braucht es in diesem Fall keine Klammern `[ ]`.

Natürlich können nicht all diese Verhaltensweisen standardmäßig zutreffen, denn das funktioniert immer nur für eine Verhaltensweise.
Eine Variable kann nicht gleichzeitig ein leeres Array und ihr eigener Name zugewiesen sein.
Was aber eine Möglichkeit ist: Einen Weg einbauen, über den der Programmierer diese Verhaltensweisen selbst setzen und ändern kann.

## 2
Datentypen anzugeben kann durchaus sinnvoll sein. Durch sie weiß man sicher, welche Nachrichten ein Objekt versteht. 
Allerdings wirken Datentypen in vielen Sprachen auch einschränkend. Angenommen wir haben folgende Datentypen (`<` steht hier für "erbt von"):
```
Hund < Tier < Object
Katze < Tier < Object

Tier[] tiere := [new Hund, new Katze]
```

Das bedeutet: Hunde und Katzen werden als Tiere angesehen - aber nur, weil wir es quasi dran geschrieben haben. Wenn wir Hund und Katze
nicht von Tier erben lassen, werden sie nicht mehr als Tiere angesehen. Das ist genau umgekehrt zu dem, wie man normalerweise etwas
definieren würde:
```
A ist ein Tier, also lebt es und ist keine Pflanze.
B lebt und ist keine Pflanze, also ist es ein Tier (schon klar, nicht ganz treffend).
```

Die Sprache könnte also erkennen, dass `B` ein Tier ist, obwohl wir es nicht extra angegeben haben. Datentypen funktionieren hier also
eher wie Vorlagen, mit denen ein Objekt geprüft wird wenn ein bestimmter Typ erwartet wird.
