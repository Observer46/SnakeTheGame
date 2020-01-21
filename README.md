# SnakeTheGame
### Drugi projekt z przedmiotu Programowanie Obiektowe
Projekt jest aktualnie zwykłąd implementacją gry 'Snake'.  
Poniżej znajduje się wymyślona przeze mnie modyfikacja rozgrywki, której NIE uda się zrealizować przed sesją :(  
Cel - przeżyć jak najdłużej (jakoś powinno uwzględniać ilośc zjedzonych jabłek/robaków)  
  
Planowane sterowanie (góra, lewo, dół, prawo):
* Gracz 1 - W,A,S,D
* Gracz 2 - <strzałki>
* Gracz 3 - I,J,K,L
* Gracz 4 - Numpad: 5,1,2,3

Planowana rozgrywka:
* W każdym ruchu wąż każdego gracza wykonuje ruch
* Co X ruchów pojawia się Y robaków do zjedzenia
* Jeśli gracz zje robka to się wydłuża
* Jeśli gracz zje odgryzie kawałek innego węża to wydłuża się + reszta odgryziona staje się ścianą
* Wejście w ścianę zabija
* Last man standing - punktowane 4,3,2,1 - o ile jest 4 graczy, gdy mniej to odpowiednio redukowane
* Gra się do 30/20/10 punktów (w zależności od ilości graczy)
* Tryb solo...?

