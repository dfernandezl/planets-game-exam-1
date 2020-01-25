# Examen

Implement here your blog post solution for the exam.

## New Satellites boost population

Humans have been very busy and they have discovered amazing ways to increase the population. 
They have discovered that special enzimes placed in orbit boost the fertilty of the population.

### Let's create a game

Create a map with two player:

 > Click _New_ in the main header.  
 > Type _TwoStars_ into the _map code_.    
 > Click the _Add player_ button.  
 > Type _garak_ into the _Player 1_.  
 > Select _Reptilian_ into the _Race 1_.  
 > Click the _Add player_ button.  
 > Type _seven_ into the _Player 2_.  
 > Select _Droid_ into the _Race 2_.  
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

With no population boost.
Ask to the star to create the satelite.

 > Type _Enzime Satellite_ into its _new satellite name_.
 > Click the _Compile_ button. 
 <!-- SNAPSHOT turn2 status=200 -->
 > It is the turn number _2_.  

 
But nothing happens because you have not enough materials.
 
 > Click at coordinates _3,3_.  
 > You see the _star_ _Bajor_.  
 > It has a _population boost_ of _0_.

But minerals have increased:

 > It has a _minerals availability_ of _7_.

Now we have enough minerals to build the satelite

 > Type _Enzime Satellite_ into its _new satellite name_.
 > Click the _Compile_ button. 
 <!-- SNAPSHOT turn3 status=200 -->
 > It is the turn number _3_.  

 
It has consumed 7 of minerals:

 > Click at coordinates _3,3_.  
 > You see the _star_ _Bajor_.
 > It has a _minerals availability_ of _2_.

And now we have a population boost:

 > It has a _population boost_ of _1_.

And the population will grow faster.

 > it has a _population_ of _100_, and 
 > it has a _maximum population_ of _100_.

We will create a ship to load some people.
We will wait one turn and then upload people.

 > Click the _Compile_ button. 
 <!-- SNAPSHOT turn4 status=200 -->
 > It is the turn number _4_.  
 > Click the _Compile_ button., again.
 <!-- SNAPSHOT turn5 status=200 -->
 > It is the turn number _5_.  
 > Click at coordinates _3,3_.  
 > You see the _star_ _Bajor_.
 > It has a _population_ of _100_, and 
 > it has a _maximum population_ of _100_.

First create a ship and move some population to the ship.

 > Type _Defiant_ into its _new ship name_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT turn6 status=200 -->
 > It is the turn number _6_.  

Load some population into the ship.

 > Click at coordinates _3,3_,  
 > You see the _ship_ _Defiant_.  
 > Type _10_ into its _load_.  
 > Click the _Compile_ button.   
 <!-- SNAPSHOT turn7 status=200 -->
 > It is the turn number _7_.  
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > it has a _population_ of _90_.  
 > You see the _ship_ _Defiant_.  
 > it has a _population_ of _10_.  

Let the population grow.
 > Click the _Compile_ button.  
 <!-- SNAPSHOT turn8 status=200 -->
 > It is the turn number _8_.  
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > it has a _population_ of _95_, it was _94_ without the boost.
 > it has a _maximum population_ of _100_.

And the population will grow no more.

 > Click the _Compile_ button.  
 <!-- SNAPSHOT turn9 status=200 -->
 > It is the turn number _9_.  
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > it has a _population_ of _100_.
 > it has a _maximum population_ of _100_.

### Other races cannot build satellites

They are enough smart to know that droids will conquer
them as soon as they leave the factory.

 > Click the _Next_ button.
 <!-- SNAPSHOT droid status=200 -->
 > The current player is _seven_.  
 > The current race is _droid_.  
 > Click at coordinates _3,3_.  
 > You see the _star_ _Bajor_.  
 > You cannot type into its _new satellite name_.


That is the end of the post.
