# Get feedback

Until today, the only way to know if an action
was success or not was to look the result.
No hint or no explanation if things are not possible.

We introduce messages. A list of everything that happened,
where happened and what happened.

## Lets get feedback

### Creating the map

As example, create a map with two players:

 > Click _New_ in the main header. 
 > Type _TwoStars_ into the _map code_.  
 > Click the _Add player_ button.  
 > Type _sisko_ into the _Player 1_.  
 > Click the _Add player_ button.  
 > Type _garak_ into the _Player 2_, and  
 > click the _Create_ button.   
 <!-- SNAPSHOT create status=200 -->
 
### Welcome to the Play game.

The first thing that you see is a welcome message.

 Now you see the _map of the game_.
Look at the right, messages are there
 there is a message telling _Welcome_.  

Messages are hidden by coordinates details,  
 > Click at coordinates _3,3_,  
 > there is no message telling _Welcome_.  
 > Click the _Back_ button and messages appear again  
 > there is a message telling _Welcome_.  
 
Messages dissapears when compiling the game,  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile2 status=200 -->
 > It is the turn number _2_, and  
 > there is no message telling _Welcome_.

### Messages with coordinates

Some times, some messages have relevant information
about something that happened in a special case.
That is the case when a ship is created. You are
able to click to the message and see what happened:

 > Click at coordinates _3,3_,  
 > You see the _star_ _Bajor_ in the side view.  
 > type _Defiant_ into its _new ship name_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile3 status=200 -->
 > It is the turn number _3_, and  
 > there is a message telling _Created the Defiant ship_.  
 > Click that message, now  
 > cell _3,3_ is highlighted,  
 > you see the _star_ _Bajor_ in the side view and  
 > you see the _ship_ _Defiant_ in the side view.  
 
### Messages are not shared between players

Messages are only for one player, other
players cannot see them.

 > Click the _Back_ button, 
 > there is a message telling _Created the Defiant ship_.
 > Click the _Next_ button.
 <!-- SNAPSHOT next3g status=200 -->
 > the current player is _garak_
 > there is no message telling _Created the Defiant ship_.
 
### Limits in ships

In the pas we did a bad job with ships,
we have fixed the logic of the ships
and at the same time we have added messages
when something goes wrong.

You cannot unload more population that
the ship is carrying.

 > Click the _Next_ button.
 <!-- SNAPSHOT next3s status=200 -->
 > the current player is _sisko_.
 >
 > Click at coordinates _3,3_,
 > You see the _ship_ _Defiant_.
 > Type _-10_ into its _load_.
 > 
 > Click the _Compile_ button.
 <!-- SNAPSHOT compile4 status=200 -->
 > It is the turn number _4_, and
 > there is a message telling _Unloaded 0 of 10 from the Defiant ship_.
 > Click that message,
 > you see the _star_ _Bajor_,
 > it has a _population_ of _100_,
 > you see the _ship_ _Defiant_,
 > it has a _population_ of _0_.
 
You cannot load more population that
the population available in the planet.
 
 > You see the _ship_ _Defiant_.
 > Type _200_ into its _load_.
 > Click the _Compile_ button.
 <!-- SNAPSHOT compile5 status=200 -->
 > It is the turn number _5_, and
 > there is a message telling _Loaded 100 of 200 to the Defiant ship_.
 > Click that message,
 > you see the _star_ _Bajor_,
 > it has a _population_ of _0_,
 > you see the _ship_ _Defiant_,
 > it has a _population_ of _100_.

You cannot load from a planet that it is not yours.

 > Click its button to _go right_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile6 status=200 -->
 > It is the turn number _6_.  
 > Click at coordinates _3,4_.  
 > You see the _ship_ _Defiant_.  
 > Type _5_ into its _load_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile7 status=200 -->
 > It is the turn number _7_.  
 > There is a message telling _Cannot load the Defiant ship from an alien planet_.

Neither can load from empty space.

 > Click that message,
 > you see the _ship_ _Defiant_,
 > Click its button to _go up_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile8 status=200 -->
 > It is the turn number _8_.  
 > Click at coordinates _2,4_.  
 > You see the _ship_ _Defiant_.  
 > Type _5_ into its _load_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile9 status=200 -->
 > It is the turn number _9_.  
 > There is a message telling _Cannot load the Defiant ship from an empty space_.

But of course you can not jettison people into the space.

 > Click at coordinates _2,4_.  
 > You see the _ship_ _Defiant_.  
 > Type _-5_ into its _load_.  
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile10 status=200 -->
 > It is the turn number _10_.  
 > There is a message telling _Cannot unload the Defiant ship into an empty space_.
 > Click that message.  
 > You see the _ship_ _Defiant_.  
 > it has a _population_ of _100_.

If everything works well, there is no message.
 
 > Click its button to _go left_.   
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile11 status=200 -->
 > It is the turn number _11_.  
 > Click at coordinates _2,3_.  
 > You see the _ship_ _Defiant_.  
 > Click its button to _go down_.    
 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile12 status=200 -->
 > It is the turn number _12_.   
 > Click at coordinates _3,3_   
 > You see the _star_ _Bajor_,  
 > it has a _population_ of _0_,  
 > You see the _ship_ _Defiant_,  
 > it has a _population_ of _100_.  
 > Type _-100_ into its _load_.   

 > Click the _Compile_ button.  
 <!-- SNAPSHOT compile13 status=200 -->
 > It is the turn number _13_, and
 > there is no message telling _Unloaded 100 of 100 from the Defiant ship_.
 > Click at coordinates _3,3_.  
 > You see the _star_ _Bajor_,  
 > it has a _population_ of _100_,  
 > You see the _ship_ _Defiant_,  
 > it has a _population_ of _0_.  
 
### Now is your turn

We hope that now you have better feedback of what is going on.
