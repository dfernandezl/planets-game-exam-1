# Maximum Population

May you have noticed that there area a maximum allowed
population in stars, and a maximum population allowed in ships.
But we told you nothing about this maximums. Now you will learn
all the true about them.

## Lets go for the example

### Create one player map

Create a map with one player:

 > Click _New_ in the main header. 
 > Type _TwoStars_ into the _map code_.  
 > Click the _Add player_ button.  
 > Type _sisko_ into the _Player 1_.  
 > click the _Create_ button.   
 <!-- SNAPSHOT create status=200 -->
 
### Stars maximum population

Lets see how the maximum population works in planets.
 Now you see the _map of the game_.
 
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > it has a _population_ of _100_, and 
 > it has a _maximum population_ of _100_.

Lets see it grow.
First create a ship and move some population to the ship.

 > Type _Defiant_ into its _new ship name_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile2 status=200 -->
 
Load some population into the ship.

 > It is the turn number _2_.  
 > Click at coordinates _3,3_,  
 > You see the _ship_ _Defiant_.  
 > Type _10_ into its _load_.  
 > Click the _Compile_ button.   
 <!-- SNAPSHOT compile3 status=200 -->
 > It is the turn number _3_.  
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > it has a _population_ of _90_.  
 > You see the _ship_ _Defiant_.  
 > it has a _population_ of _10_.  

Let the population grow. 

 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile4 status=200 -->
 > It is the turn number _4_.  
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > it has a _population_ of _99_.  
 > it has a _maximum population_ of _100_.  
 
It did not reached the maximum yet.
Let's give one more shot.

 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile5 status=200 -->
 > It is the turn number _5_.  
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > it has a _population_ of _100_.  
 > it has a _maximum population_ of _100_.  

It has reached the maximum of population. 
The population will grow no any more.

### Ships maximum population

Ships also have maximum population.
That determines how many people you can move in
a single ship from one star to other.

Lets see which is the maximum population
of the ship.

 > You see the _ship_ _Defiant_.
 > It has a _population_ of _10_, and  
 > it has a _maximum population_ of _100_.  

We are long way below the maximum of population.
Lets load all population from the planet.

 > Type _100_ into its _load_.

Lets see what happened.

 > Click the _Compile_ button.
 <!-- SNAPSHOT compile6 status=200 -->
 > It is the turn number _6_, and
 > there is a message telling _Loaded 90 of 100 to the Defiant ship_.
 > Click that message.
 > You see the _ship_ _Defiant_.
 > It has a _population_ of _100_, and  
 > it has a _maximum population_ of _100_.  

It has reached the maximum of population. 
It will not be able to load more population. 
 
### Now is your turn

We hope that now you have better feedback of what is going on.
