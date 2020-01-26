# Examen Phase 2

## Satellites can be upgraded

It is better to upgrade satellites than create more.

### Let's create a game

Create a map with two player:

 > Click _New_ in the main header.  
 > Type _TwoStars_ into the _map code_.    
 > Click the _Add player_ button.  
 > Type _garak_ into the _Player 1_.  
 > Select _Reptilian_ into the _Race 1_.  
 > Click the _Create_ button.   
 <!-- SNAPSHOT create status=200 -->
 
### Population Satellites require minerals

Go to your solar system and check the amount of minerals.
Also ask to the star to create satellite.

 > It is the turn number _1_.  
 > The current player is _garak_.  
 > The current race is _reptilian_.  
 > Click at coordinates _3,3_.  
 > You see the _star_ _Bajor_.  
 > it has a _minerals availability_ of _5_.
 > It has a _population boost_ of _0_.

We wait to have enough minerals.

 > Click the _Compile_ button. 
 <!-- SNAPSHOT turn2 status=200 -->
 > It is the turn number _2_.  
 > Click at coordinates _3,3_.  
 > You see the _star_ _Bajor_.  
 > It has a _minerals availability_ of _7_.
 > Type _Enzime_ into its _new satellite name_.
 > Click the _Compile_ button. 
 <!-- SNAPSHOT turn3 status=200 -->
 > It is the turn number _3_.  

 
It has consumed 7 of minerals.
And now we have a population boost.

 > Click at coordinates _3,3_.  
 > You see the _star_ _Bajor_.
 > It has a _minerals availability_ of _2_.
 > It has a _population boost_ of _1_.

We also can see that we have a satellite:

 > You see the _satellite_ _Enzime_.
 > It has a _level_ of _1_.

### Upgrade levels

Upgrade is two of minerals.

 > Type _yes_ into its _upgrade satellite_.
 > Click the _Compile_ button. 
 <!-- SNAPSHOT turn4 status=200 -->
 > It is the turn number _4_.
 > Click at coordinates _3,3_.  
 > You see the _star_ _Bajor_.
 > It has a _minerals availability_ of _2_.
 > It has a _population boost_ of _2_.
 > You see the _satellite_ _Enzime_.
 > It has a _level_ of _2_.

### Upgrade is exponential

Next level upgrades more the population boost.

 > Type _yes_ into its _upgrade satellite_.
 > Click the _Compile_ button. 
 <!-- SNAPSHOT turn5 status=200 -->
 > It is the turn number _5_.
 > Click at coordinates _3,3_.  
 > You see the _star_ _Bajor_.
 > It has a _minerals availability_ of _2_.
 > It has a _population boost_ of _4_.
 > You see the _satellite_ _Enzime_.
 > It has a _level_ of _3_.
