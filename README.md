Planets Game - the exam
=======================

Llegeix l'enunciat en paper detingudament. 
Escriu el teu nom, cognoms i DNI en el paper. 
Entregar el paper en acabat l'examen.

Recorda commitejar i pushejar amb freqüencia.
No s'acceptaràn commits pushejats després d'acabar o entregar l'examen.

### 0) Setup

Clona el repositori en el teu ordinador.

**Backend**:

- Obre el repositori clonat amb el IntelliJ
- Executa tots els tests per verificar que tot funciona.

**Frontend**

- Executa `yarn install`
- Executa tots els tests amb `yarn test` per verificar que tot funciona.


### 1) Tu i el teu grup  (0.5pt)

- Escriu el teu nom, cognoms i DNI a continuació:

Nom: ____________________  
Cognoms: ________________  
DNI: ____________________  

- Escriu quina és l'URL del repositori de la pràctica del teu grup:

Url: https://github.com/TC-LS2/planets-game-______________  

- Escriu quina és l'URL de heroku el teu grup ha fet release de master:

Url: https://http://planets-game-________________.herokuapp.com/  

- Has fet algun release? Quants?

He fet ________________ releases.

- Sense considerar-te a tu mateix, escriu el nom de qui consideris:

Millor Scrum Master del grup: ______________________________  
Pitjor Scrum Master del grup: ______________________________  

- Escriu el nom i cognoms de tots i cada un dels participants del teu grup, i 
  per cada un d'ells escriut quin ha sigut el tant per cent de participació 
  segons el teu criteri (tots els % cal que sumin 100%).

Participant: ________________________________, participació: ___ %  
Participant: ________________________________, participació: ___ %  
Participant: ________________________________, participació: ___ %  
Participant: ________________________________, participació: ___ %  
Participant: ________________________________, participació: ___ %  
Participant: ________________________________, participació: ___ %  


### 2) FASE 1: Escriu el post del blog. (2.5pt)

Escriu el post de la nova funcionalitat que es demana a:

- `src/main/resources/blog/2019-12-20_examen`.

El post hi ha de reflectir l'addició d'un nou tipus de comanda de creació, la impossibilitat d'executar-se si falta mineral, la visualització del que s'ha creat, els efectes que té, que succeeix quan s'arriba al límit, i la restricció a una sola raça.

Aquest mateix post és el que s'usa per fer passar els tests de front i back. 

Hi ha una nova frase especial "Skip turns from _8_ to _20_." que permet saltar múltiples torns i accelerar els esdeveniments (ex: mirar el post de droids).


### 3) FASE 1: Implementa el backend. (2.5pt)

Per això cal:

- Crear un CommandRunner per crear el nou recurs.

- Modificar o bé el StarController o bé el StarbaseController.

- Modificar o bé el Star o bé el Starbase.

- Si s'escau modificar una de les següents classes CR100Reproduce, CR200LoadShip, CR600DigMinerals o CR600ProduceFuel.

- Si s'escau afegir un o més matchers.

En aquesta fase no cal crear cap nou tipus d'entitat.

Cal tenir en compte el Code Coverage. Assegureu-vos que useu JaCoCo i que el branch coverage és correcte.

Resultat Commit Inicial:

```
---------------------------------------|----------|----------|----------|----------|
File                                   |  % Class | % Branch |  % Meths |  % Lines |
---------------------------------------|----------|----------|----------|----------|
com.drpicox.game                       |   100.00 |    99.09 |    99.64 |    99.76 |
---------------------------------------|----------|----------|----------|----------|

Test Suites: 20 passed, 20 total
Tests:       22 passed, 22 total
Snapshots:   0 total
Time:        25.299s
Ran all test suites.
```

### 4) FASE 1: Implementa el frontend (1.5pt)

Per això cal:

- Modificar o bé `src/www/entities/star/StarDescription` 
  o bé `src/www/entities/starbase/StarbaseDescription`

No cal afegir cap matcher.

Cal tenir en compte el Code Coverage. Podeu usar la comanda:

- `CI=1 yarn test -i --coverage --coveragePathIgnorePatterns 'src/www/(__test__|lib|index|serviceWorker)'`

Resultat Commit Inicial:

```
---------------------------------------|----------|----------|----------|----------|
File                                   |  % Stmts | % Branch |  % Funcs |  % Lines |
---------------------------------------|----------|----------|----------|----------|
All files                              |    98.21 |    95.04 |    98.68 |    99.17 |
---------------------------------------|----------|----------|----------|----------|

Test Suites: 21 passed, 21 total
Tests:       23 passed, 23 total
Snapshots:   0 total
Time:        25.299s
Ran all test suites.
```


### 5) FASE 2 (3pt)

Abans de continuar, assegurat que la Fase 1 funciona, i fes un commit i push que es digui: "FASE 1: Acabada".

Implementa la Fase 2 de l'enunciat:

- Crea un blog post per la fase 2 anomenat `2019-12-20_examen_phase_2`.

- Crea els testos de front i back per la fase 2.

- Crea un nou tipus d'entitat a back (cal crear entitat, controlador i repositori).

- Crea i modifica els CommandRunners que creguis convenients.

- Crea un nou tipus d'entitat al frontend (cal afegir la descripció i la comanda)

- Crea els matchers de back i front que creguis convenients.

Cal que aquesta implementació sigui 100% compatible amb el test de la FASE 1.
