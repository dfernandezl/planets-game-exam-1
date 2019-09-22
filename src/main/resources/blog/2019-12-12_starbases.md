# Starbases

Did you ever though how costly is to build a ship
in dry land and then launch it to the space? 
We introduce starbases, an orbital facility able to
reduce the cost of creating a starship, and able
to create more ships at the same time.

## Building Starbases

### Create one player map

Create a map with one player:

 > Click _New_ in the main header.  
 > Type _TwoStars_ into the _map code_.    
 > Click the _Add player_ button.  
 > Type _sisko_ into the _Player 1_.  
 > click the _Create_ button.   
 <!-- SNAPSHOT create status=200 -->
 
### Starbases are expensive

In the beginning, you have not enough minerals
to build a starbase. If you want to build one,
you should wait.
 
 > It is the turn number _1_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile2 status=200 -->
 > It is the turn number _2_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile3 status=200 -->
 > It is the turn number _3_.  

We are ready. Lets build a starbase.
 
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > it has a _minerals availability_ of _11_.  
 > Type _Deep Space 9_ into its _new starbase name_.  

Ok, we have requested it. Lets see the new starbase:

 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile4 status=200 -->
 > It is the turn number _4_.  
 > There are _starbases_ at coordinates _3,3_.  
 > Click at coordinates _3,3_,  
 > You see the _starbase_ _Deep Space 9_.  
 > You see the _star_ _Bajor_.  
 > it has a _minerals availability_ of _4_.  

### Create a ship in the starbase

Notice that you can create a ship on a star,
but also in a starbase. Lets create a ship
in the starbase. 

 > You see the _starbase_ _Deep Space 9_.  
 > Type _Defiant_ into its _new ship name_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile5 status=200 -->
 > It is the turn number _5_.  
 > Click at coordinates _3,3_,  
 > You see the _ship_ _Defiant_.  

The number of resources required are also less.

 > You see the _star_ _Bajor_.  
 > it has a _minerals availability_ of _4_,  

### Building two ships at once

You can build two ships at once. 
Lets wait until having enough minerals.

 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile6 status=200 -->
 > It is the turn number _6_.  
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > it has a _minerals availability_ of _7_,  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile7 status=200 -->
 > It is the turn number _7_.  
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > it has a _minerals availability_ of _10_,  

Ok, we have enough minerals.
First order a ship in the star.

 > You see the _star_ _Bajor_.  
 > Type _Rio Grande_ into its _new ship name_.   

Now order a ship in the starbase.

 > You see the _starbase_ _Deep Space 9_.  
 > Type _Ganges_ into its _new ship name_.  

And compile and see the result: 

 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile8 status=200 -->
 > It is the turn number _8_.  
 > Click at coordinates _3,3_,  
 > You see the _ship_ _Rio Grande_.  
 > You see the _ship_ _Ganges_.  

Ok. Now we have enough minerals
to build one ship, but not two.
Lets try build two at once.

 > You see the _star_ _Bajor_.  
 > It has a _minerals availability_ of _5_.  
 > Type _BajorShip_ into its _new ship name_.    
 > You see the _starbase_ _Deep Space 9_.  
 > Type _DeepShip_ into its _new ship name_.    

Lets see what happens.

 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile9 status=200 -->
 > It is the turn number _9_.  
 > Click at coordinates _3,3_.  
 > You see no _ship_ _BajorShip_.  
 > You see the _ship_ _DeepShip_.  
 > You see the _star_ _Bajor_.  
 > it has a _minerals availability_ of _5_.  

It builds first ships from the starbase. 
If there are not enough minerals for a second ship,
it stops. Also lok at available minerals, 
build the DeepShip was cheaper than the BajorShip.

### Building more starbases

You can build as many starbases as you want,
if you have enough minerals.

 Skip turns from _9_ to _12_
and build another starbase:

 > It is the turn number _12_.  
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > Type _Empok Nor_ into its _new starbase name_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile13 status=200 -->
 > It is the turn number _13_.  
 > Click at coordinates _3,3_.  
 > You see the _starbase_ _Deep Space 9_.    
 > You see the _starbase_ _Empok Nor_.    

But, if you do not have enough minerals you have to wait.

 > You see the _star_ _Bajor_.  
 > Type _Deep Space Station K-7_ into its _new starbase name_.      
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile14 status=200 -->
 > It is the turn number _14_.
 > There is a message telling _Cannot build starbase Deep Space Station K-7 due to a lack of available minerals_.    
 > Click that message.  
 > You see no _starbase_ _Deep Space Station K-7_.   
     

### All starbases are fully operational

If you have more than one starbase, you can 
build a ship into each starbase and star simultaneously.

Lets wait a little bit.
 Skip turns from _14_ to _15_.

 > It is the turn number _15_.  
 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_.  
 > Type _Enterprise-A_ into its _new ship name_.  
 > You see the _starbase_ _Deep Space 9_.  
 > Type _Enterprise-B_ into its _new ship name_.  
 > You see the _starbase_ _Empok Nor_.  
 > Type _Enterprise-C_ into its _new ship name_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile16 status=200 -->
 > It is the turn number _16_.  
 > Click at coordinates _3,3_,  
 > You see the _ship_ _Enterprise-A_.  
 > You see the _ship_ _Enterprise-B_.  
 > You see the _ship_ _Enterprise-C_.

### It tells you when you had not enough materials

Lets try to build two ships. One it is possible,
the second one will not be possible.
    
 > You see the _star_ _Bajor_.  
 > it has a _minerals availability_ of _5_.  
 > You see the _starbase_ _Deep Space 9_.  
 > Type _Lafayette-A_ into its _new ship name_.  
 > You see the _starbase_ _Empok Nor_.  
 > Type _Lafayette-B_ into its _new ship name_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile17 status=200 -->
 > It is the turn number _17_.  
 > There is a message telling _Cannot build ship Lafayette-B due to a lack of available minerals_.    
 > Click that message.
 > You see the _ship_ _Lafayette-A_.  
 > You see no _ship_ _Lafayette-B_.  

### Now is your turn

We hope that now you have better feedback of what is going on.
