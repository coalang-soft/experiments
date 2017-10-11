Kommunikation zwischen Programmteilen (Objekten) ist die Grundlage von Objektorientierung, nicht Klassen usw.
## Ablauf der Kommunikation
Objekte (in MyPy ist jeder Wert ein Objekt) können Nachrichten (ein beliebiges Objekt kann eine Nachricht sein) empfangen. Ein Objekt
kann auf Grundlage der empfangenden Nachricht tun was es möchte. Die Reaktion auf eine Nachricht wird in MyPy 
durch die Methode `receive` eines Objektes beschrieben. `receive` bekommt beim Eingehen einer Nachricht auch mitgeteilt, wer die Nachricht
gesendet hat. Sollte es sinnvoll sein, kann diese Methode eine kurze Rückmeldung liefern, wie die Nachricht verarbeitet wurde.
Es kann natürlich vorkommen, dass ein Objekt mit einer Nachricht nicht sinnvoll
umgehen kann. Wenn das der Fall ist, kann man sich das Senden weiterer Nachrichten, die auf die vorherige aufbauen, sparen. Ob ein Objekt
mit einer Nachricht umgehen kann, kann über seine Methode `accepts` herausgefunden werden.

Die Kommunikation besteht also aus "kanst du ..." (ja/nein) und "mach ..." (zwischenbericht).
Da ein Objekt mit mehreren anderen Objekten gleichzetig kommunizieren kann, muss es sich merken, was wer gefragt hat, um sinnvoll antworten zu können. Am Ende der Kommunikation können diese germerkten Daten wieder vergessen werden. Über die Methode `disconnect` wird die aktuelle Kommunikation beendet.

## Abkapseln der Kommunikationsschritte
In der Praxis ist es nicht Sinnvoll, die oben beschriebenen für den Programmierer sichtbar zu machen. `receive` zum Beispiel sollte nur
genutzt werden, wenn das empfangende Objekt mit einer Nachricht umgehen kann - das wäre nicht mehr sicher gestellt.
Es ist also sinnvoll, den gesamten Kommunikations-Prozess abzukapseln. Über die Methode `broadcast` eines Objektes können beliebig viele Nachrichten an ein Objekt gesendet werden. Der Aufruf von `receive` und `accepts` passiert automatisch. Die
Rückmeldungen von `receive` können am Ende des Sendens als Liste zurück gegeben werden. Diese Liste hat maximal so viele elemente, wie es
Anfragen gab. Sollte jedoch eine Anfrage nicht akzeptiert worden sein, endet die Liste davor. `1,2>>>3` ist nur dann eine Liste mit 2
Elementen, wenn `3` die Nachrichten `1` und `2` akzeptiert. Wenn die 1 akzeptiert wird und die 2 nicht, hat die Ergebnisliste nur ein
Element, die Reaktion auf `1`. Wenn die 1 nicht akzeptiert wird hat die Ergebnisliste kein Element, auch nicht wenn `2` akzeptiert würde.

## Nachrichten-Objekte
Objekte können Eigenschaften haben. Es kann sinnvoll sein, Zugriff auf diese Eigenschaften zu haben. Dafür gibt es Nachrichten-Objekte.
Mit `#abc` hat man ein Nachrichten-Objekt, dass die Eigenschaft `abc` des Empfängers  anfragt. 
Mögliche schreibweisen sind `#xyz>>>7`, `7.xyz` und `7.broadcast:#xyz`, die alle die Eigenschaft `xyz` von `7` anfragen.

## Wer ist Sender?
* Wird nicht innerhalb einer Funktion gesendet, ist der Sender das globale Objekt. Das globale Objekt akzeptiert alle Nachrichten, zeigt
aber keine Reaktion auf eine Nachricht.
* Wird innerhalb einer Funktion gesendet, die nicht zu einem Objekt gehört, ist der Sender das globale Objekt.
* Wird innerhalb einer Funktion gesendet, die zu einem Objekt gehört, ist der Sender dieses Objekt.
