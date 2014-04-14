baseballProcesses-scala
=======================

Scala/Akka implementation of the baseball throwing processes kata for elixir. http://variousandsundry.com/cs/blog/2014/02/20/baseball-processes/  Make sure that sbt and scala are installed. 

The current implementation has two players (us and them).  "Us" will direct "Them" where to stand and what type of ball to throw.   "Us" has two friends as of now, a line drive thrower and a ground ball thrower.  All three throw forever.  It is currently possible to have the third player "La Lob" start based off the defined messages (Lobs and defining where to stand), although that "Them" player has not been added to the list of created friends/players of "Us". 
