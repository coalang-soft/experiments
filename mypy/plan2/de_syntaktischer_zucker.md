Der Kern von MyPy ([hier](https://github.com/coalang-soft/experiments/blob/master/mypy/plan2/de_grundlagen.md) zu sehen) wirkt recht
kryptisch. Um dem entgegen zu wirken, soll es eine Erweiterung der Syntax geben, die zwar gleichbedeutend mit bereits vorhandenen
Features aber besser zu lesen und schreiben ist.
## Funktionen
```
{[x true] x*x}
{x*x}
```
Eine Funktion ohne Parameterbeschreibung(en) erhält automatisch die Beschreibung `[x true]`, und damit den Parameter x.
```
{[a true][b true]}
{[a][b] a+b}
```
Eine Parameterbeschreibung, die nur aus einem Namen besteht, wird automatisch mit der Bedingung `true` versehen - akzeptiert also jeden Wert.
`[alsdjk]` ist `[alsdjk true]`.
```
{
  [arg1 {x%3=0}] "Durch 3 teilbar"
  [arg2 {true}] "Nicht durch 3 teilbar"
}
{
  [{x%3=0}] "Durch 3 teilbar"
  [{true}] "Nicht durch 3 teilbar"
}
```
Eine Parameterbeschreibung, die nur aus einer Funktion besteht, wird mit einem automatisch erzeugten Namen versehen. Diese Namen sind
`arg1`, `arg2`, `arg3` usw.
```
{
  [arg1][arg2] "Zwei Parameter"
  [arg1] "Ein Parameter"
}
{
  [][] "Zwei Parameter"
  [] "Ein Parameter"
}
```
Eine leere Parameterbeschreibung erhält sowohl einen automatisch generierten Namen nach oben genanntem Muster als auch die Bedingung true.

WIP
