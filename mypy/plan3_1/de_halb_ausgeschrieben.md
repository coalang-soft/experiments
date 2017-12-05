## Halb ausgeschriebene Funktionen
Normalerweise muss man Funktionsnamen immer vollständig und am Stück ausschreiben, um eine Funktion zu nutzen.
```
funktion parameter1 parameter2 parameter3
parameter1 funktion parameter2 parameter3

numbersFromTo 4 9
4 numbersFromTo 9
```

Das Problem ist: Es klingt ziemlich unnatürlich. Das Passiert besonders oft bei Funktionsnamen, die aus mehreren Wörtern bestehen.
Wie `fromTo`, `incrementBy` oder `copyFrom`.
Hier mal ein paar Beispiele mit besseren (verständlicheren) Varianten:
```
numbersFromTo 4 9
numbers from 4 to 9

writeTo ( url [ https://www.google.com ] ) ( file [ download.txt ] )
write ( url [ https://www.google.com ] ) to ( file [ download.txt ] )
```

Das klingt doch schon verständlicher - aber es hat einen anderen Effekt. Wir nutzen im Zweiten beispiel nämlich nicht die Funktion `writeTo`,
sondern `write` und `to`. Es kann also weder unterschieden werden ob wir jetzt einen Namens-Teil oder einen vollständigen Namen
angeben haben, noch können wir wissen ob das so gewollt war, oder ob wirklich mehrere einzelne Funktionen genutzt werden sollen.
Dieses Problem kann behoben werden, indem man ein Unterscheidungsmerkmal hinzufügt:
```
numbers: from: 4 to: 9
write: url [ https://www.google.com ] to: file [ download.txt ]
```

Zugegeben: Die Idee und die Umsetzung sind stark von Smalltalk inspiriert. Aber es ist eine gute Möglichkeit, um das oben beschriebene
Problem zu lösen. Die Deutung funktioniert so:

Wird ein Wort mit `:` am Ende gefunden, wird es als Namensbestandteil gedeutet. Wird ein weiterer Namensbestandteil gefunden, werden
die beiden aneinander gesetzt - aus `from: to:` wird `fromTo:`. Wenn zwischendurch etwas kommt, was kein Namensbestandteil ist, wird es
auf die Parameterliste gesetzt. Wichtig hierbei: Nur Code der nicht von Namensbestandteilen unterbrochen wird, wird "normal" ausgeführt.
Bei `write: url [ https://www.google.com ] to: file [ download.txt ]` wird also die Adresse an `url` gesendet. Aber `file` wird
nicht an das Ergebnis gesendet. Dieses Verhalten wirkt wie die bekannten Klammern `( )`.

Am Ende (Gekennzeichnet durch `code;`, `( code )` oder `[ code ] !`) werden die Namensbestandteile wie beschrieben zusammen gesetzt,
und es wird nach einer Variablen mit diesem Namen gesucht. Dann werden die Parameter nacheinander jeweils ausgewertet, und dann direkt
an die gefundene Variable gesendet.

Es gibt dann vom Sinn her keinen Unterschied mehr zwischen diesen Zeilen:
```
writeTo ( url [ https://www.google.com ] ) ( file [ download.txt ] ) ;
write: url [ https://www.google.com ] to: file [ download.txt ] ;
```
