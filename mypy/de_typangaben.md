So praktisch und einfach es auch manchmal sein mag, auf Typangaben verzichten zu können, so nervig kann es auch sein. Dieses Dokument
listet einige Gründe dafür auf und versucht, die Vorteile der beiden Möglichkeiten zu vereinen.
Dabei wird hauptsächlich auf die komfortable Nutzung geachtet - der Technische Aspekt, Performance usw. werden kaum bis garnicht behandelt.

## Vorteile ohne Typangaben
Ohne Typangaben hat man zum einen oft weniger Schreibaufwand. Denn wo man sonst etwas wie `number s = 8` schreiben muss, reicht nun ein
`s = 8`. Je nach dem wie viele Zeichen die Typangabe erfordert, spart das einiges an Schreibaufwand. Zusätzlich kann man bei sehr
allgemeinen Definitionen oft garnicht sinnvoll beschreiben, was z.B. als Funktionsparameter passt - es funktioniert einfach alles.
Gerade für Anfänger kann der Sinn von Typangaben schwer ersichtlich sein, daher ist die Option, auf Typangaben zu verzichten, gerade
für Neulinge sehr sinnvoll.

## Vorteile mit Typangaben
Typangaben bieten eine gute Möglichkeit um den Überblick zu behalten, was man tun kann und was nicht. Denn Typangaben beinhalten oft,
welche Eigenschaften und Möglichkeiten etwas bietet. Darüber kann z.B. eine Funktion so definiert werden, dass sie nur mit sinnvollen
Daten funktioniert - und damit können Fehlerquellen minimiert werden.
Außerdem kann diese Angabe darüber, was funktioniert und was nicht, auch sehr einfach
von Interpretern, Compilern, IDEs und weiteren Entwicklungswerkzeugen genutzt werden, um sinnvolle Hinweise zu nicht funktionierendem oder
verbesserungswürdigem Code zu geben. Typangaben sind hier eine Angabe, die sich das Entwicklungswerkzeug nicht selbst "herleiten" muss.

## Ansätze
### Klassen
Klassen bieten eine Möglichkeit, Typen mit einem Namen und mehreren Eigenschaften zu definieren. Der Name kann dann als Typangabe
genutzt werden. Dieser Ansatz bietet alle Vorteile, die unter "Vorteile mit Typangaben" genannt werden, und eine recht gute Lesbarkeit, wenn die Klassen gut benannt sind - aber auch entscheidende
Nachteile. Folgendes Beispiel (in Java) funktioniert beispielsweise:

```
class A{
	void stuff(){}
}
class B{
	void stuff(){}
}
class C{
	static void act(A a){
		a.stuff();
	}
}
```
Aber wenn man im Programm dann folgendes tun will, gibt es einen Fehler:
```
C.act(new A());
C.act(new B());
```
WIP
