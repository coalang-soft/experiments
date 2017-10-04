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
WIP
