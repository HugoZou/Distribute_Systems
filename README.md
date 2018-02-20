# Distribute_Systems
+ EX9.1 Word Guess Game
    + The server waits for the incoming client connection. When such a connection is established, the server begins the game. It selects a random word Wfrom the file w09_words.txtand sends to the client a string that consists of length(W)’star’ symbols (\*). The client shows the received string, reads one character from the keyboard and sends it to the server. If the given character is found in the word, the server shows its position(s). The characters guessed during the previous steps are also shown.The game ends when the client has guessed the whole word. The client shuts down, and the server waits for the next incoming connection.

+ EX9.2 Improve chat
  + Add nickname
  + Add funcion which client can close the connection and leave the chat

+ OpenMP in java
  + Directives
    + omp for
      + The work in a for loop inside a parallel region will be divided among threads.
    + omp single
      + ONly one thread will run a setion of code.
    + omp parallel
      + Defines a region, where the code will be executed by multiple threads in parallel.
    + omp section
      + Code sections will be divided among all threads.
    + omp barrier
      + The code will pause until all threads arrive at this point.
    + omp master
      + Only master thread will execute the specified regioin.
    + omp ordered
      + Specifies a region inside a for0loop that will be executed in the same order as if the loop is non-parallel. For-loop must be declared with the ordered clause.
  + Function
    + OMP.setNUmThreads()
      + sets the number of threads for the next parallel region.
    + OMP.tetThreadNum()
      + Return the current thread ID

+ Lecture10 RMI in Java
  +  RMI Remote Method invocation
    + A competing Java only techology. assist building client-server systems. Instead of “clients” and “servers” there are objects with callable procedures.
    + Architecture in RMI
      + 1. Server registers a name for its inner objects in The Registry.
      + 2. Client obtains a reference to the object from the Registry.
      + 3. Client calls object's functions via the obtained reference.

   +  Architecture
    + RMIGenRand
    + RMIGeninterface
    + RmiGRClient
      + initialize a new RMIGeninterface object.
    + RmiGRServer
      + Naming.rebind(RmiServiceName, new ClassName(…));
  +  Class RMIGenRand proides a method GenRand() that returens an integer random number.
  + The server creates an object of type  RMIGenRand and registers it in the RMI Registry.
  + The client can obtain a reference to the remote object(using the RMI Registry) and call GenRand() to receive random numbers.
