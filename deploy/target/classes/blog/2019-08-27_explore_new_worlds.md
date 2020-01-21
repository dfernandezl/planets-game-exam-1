# Explore new worlds

All I want is a a tall ship and a star to sail her by.
And now we can sail the sky like it was the ocean.

## Sailing the sky

### Setup

Before, start, we need to create a 
universe:

 > Click _New_ in the main header.
 > Type _TwoStars_ into the _map code_.
 > Click the _Create_ button. 
 <!-- SNAPSHOT newUniverse status=200 -->
 > Click _Play_ in the main header.
 > Type your username.
 > Click the _Log in_ button. 
 <!-- SNAPSHOT loginGame status=200 -->
 > Now you see the _map of the game_.

### Far visibility

You only see distant stars, 
you cannot see details about those
stars, just few details.

From your own stars you see a lot
of details.

 Click at coordinates _3,3_,
 You see the _star_ _Bajor_.
 It has a _population_ of _100_.
 And it is of _yours_.
 
But, if it is far away...

 Click the _Back_ button to return to the map.
 Click at coordinates _3,4_.
 You see the _star_ _Cardassia_.
 It has no _population_.
 And it has no _owner_.
 
### Far ships are not visible

First build one ship:

 Click the _Back_ button to return to the map.
 Click at coordinates _3,3_.
 You see the _star_ _Bajor_.
 Type _Defiant_ into its _new ship name_.
 Click _Game_ in the main header.
 Click the _Save game_ button.
 <!-- SNAPSHOT save1 status=200 -->
 Wait for an alert saying _game saved_.
 Click _Game_ in the main header.
 Click the _Compile game_ button.
 <!-- SNAPSHOT compile1 status=200 --> 
 Wait for an alert saying _game compiled_.
 
Login as _garak_ and look to Bajor.
 
 Click _Game_ in the main header.
 Click the _Logout_ button.
 Click _Play_ in the main header.
 Type _garak_ into the _username_.
 Click the _Log in_ button.
 <!-- SNAPSHOT garak1 status=200 --> 
 Now you see the _map of the game_.
 There is a _star_ at coordinates _3,3_.
 Click at coordinates _3,3_.
 You see the _star_ _Bajor_.
 It has no _population_.
 And it has no _owner_.
 You see no _ships_.
 
### Sail to Cardassia

Go back to your user.
 
 Click _Game_ in the main header.
 Click the _Logout_ button.
 Click _Play_ in the main header.
 Type your username.
 Click the _Log in_ button.
 <!-- SNAPSHOT yours1 status=200 --> 
 Now you see the _map of the game_.
 Click at coordinates _3,3_.
 You see the _ship_ _Defiant_.
 Click its button to _go right_.
 Click _Game_ in the main header.
 Click the _Save game_ button.
 <!-- SNAPSHOT save2 status=200 -->
 Click _Game_ in the main header.
 Click the _Compile game_ button.
 <!-- SNAPSHOT compile2 status=200 --> 
  
### Look again to Cardassia

 Click at coordinates _3,4_.
 You see the _star_ _Cardassia_.
 It has a _population_ of _100_.
 And it is of _garak_.

### But planet owner can see you too

 Click _Game_ in the main header.
 Click the _Logout_ button.
 Click _Play_ in the main header.
 Type _garak_ into the _username_.
 Click the _Log in_ button.
 <!-- SNAPSHOT garak2 status=200 --> 
 Now you see the _map of the game_.
 Click at coordinates _3,4_.
 You see the _star_ _Cardassia_, and
 you see the _ship_ _Defiant_.
