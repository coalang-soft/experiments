Einrückungen sind in MyPy sehr wichtig, da sie wesentliche Zusammenhänge beschreiben. Was ist der Parameter einer Funktion, und was ist
ihr eigentlicher Inhalt? Wie viele Parameter hat eine Funktion? Solche Dinge können Einrückungen beschreiben.
## Funktionen definieren
Ein gutes Beispiel für die Nutzung von Einrückungen sind Funktionen. Man kann sie in MyPy so definieren:
```
def f
	n
		n*2
```
Das definiert eine Funktion f mit einem Parameter, die immer das doppelte des Parameters zurück gibt. Alles durch Einrückungen beschrieben.
Hätten wir folgendes
```
def f
	n
	n*2
		n
```
würden wir eine Funktion mit zwei Parametern definieren. Ob die Funktion allerdings funktioniert, hängt von den Parameter-Werten ab: der
zweite Parameter muss doppelt so groß sein wie der erste. Auf diese Art können Abfragen einfach umgesetzt werden:
```
def f
	<18
		"Nicht volljährig"
	=18
		"Gerade volljährig"
	n
		"Volljährig"
```
Diese Funktion testet, ob ein angegebenes Alter volljährig ist. Sie unterscheidet 3 Fälle: Nicht volljährig, Gerade volljährig, und
Volljährig - ohne Zusatz. Es wird immer der erste passende Fall genommen. Wenn der Parameter also 19 ist, ist er nicht kleiner und nicht
gleich 18, die ersten beiden Fälle können nicht angewendet werden. Der dritte Fall stellt aber keine Bedingung - n ist der Name, unter dem
wir den Parameter ansprechen könnten. Also können Zahlen über 18 - und nur Zahlen über 18, der Rest wird durch die ersten beiden Fälle
behandelt - durch den dritten Fall abgefragt werden, obwohl er keine Bedingung stellt.
## Funktionen aufrufen
Wenn wir unsere Funktion nutzen wollen, können wir das so machen:
```
f
	8
```
So rufen wir die Funktion f mit dem Parameter 8 auf. Es können auch mehrere Parameter genutzt werden:
```
f
	1
	"Test"
	true
```
Hier wird f mit 3 Parametern aufgerufen. Und Funktionsaufrufe als Parameter sind natürlich auch möglich:
```
f
	read
		"Gib was ein"
	true
```
So wird wieder die Funktion f aufgerufen, dieses Mal mit 2 Parametern - wobei der Nutzer den ersten eingeben kann.
## Einrückungen umgehen
Während Einrückungen in den gezeigten Fällen ihren Zweck erfüllen, sieht der Code durch sie - vor allem bei kleinen Funktionen -
gestreckt und oft nicht schön aus. Daher gibt es zwei spezielle Zeichen, die als Ersatz für Einrückungen sinnvoll sein können.
### : - eine Stufe weiter
Der Doppelpunkt `:` rückt alles eine Stufe weiter ein, was direkt hinter ihm steht oder unter ihn eingerückt ist. Folgende Codestücke
machen genau das gleiche:
```
def f
	n
		n
```
```
def f:n
	n
```
```
def f
	n:n
```
```
def f:n:n
```
### ; - gleiche Stufe
Das Semikolon `;` stellt alles auf seine eigene "Einrück-Stufe", was direkt hinter ihm steht. Folgende Codestücke machen das gleiche:
```
def f
	x
	x*2
		x*3
	a
	b
		a+b
```
```
def f
	x;x*2
		x*3
	a;b
		a+b
```
```
def f
	x;x*2:x*3
	a;b:a+b
```
### Eine Stufe zurück?
Es gibt kein Zeichen für "Eine Stufe zurück". Das bedeutet, wenn du eine Einrückungs-Stufe zurück willst, musst du eine neue Zeile
anfangen. Das mag auf den ersten Blick nervig wirken, zwingt dich aber größeren Code übersichtlich zu halten. Und wenn du alle Möglichkeiten nutzt, um einrückungen zu vermeiden, ist dein Code normalerweise beides - kompakt und übersichtlich.
Ein Beispiel für etwas, was nicht funktioniert wie man es erwarten könnte, ist folgendes:
```
def f:x;x*2:x*3;a;b:a+b
```
Das soll eigentlich das gleiche machen, wie das letzte Beispiel - tut es aber nicht. Wenn wir von links nach rechts aufdröseln, ergeben
sich folgende Schritte:
```
def f
	x;x*2:x*3;a;b:a+b
```
```
def f
	x
	x*2:x*3;a;b:a+b
```
```
def f
	x
	x*2
		x*3;a;b:a+b
```
Und so weiter. Man sieht: Die zweite Parameterliste `a;b` ist bereits so tief eingerückt, dass sie als "Funktionscode" gilt - der Sinn
ist also nicht mehr der gleiche.
