# Distribute_Systems
+ EX9.1 Word Guess Game
    + The server waits for the incoming client connection. When such a connection is established, the server begins the game. It selects a random word Wfrom the file w09_words.txtand sends to the client a string that consists of length(W)’star’ symbols (\*). The client shows the received string, reads one character from the keyboard and sends it to the server. If the given character is found in the word, the server shows its position(s). The characters guessed during the previous steps are also shown.The game ends when the client has guessed the whole word. The client shuts down, and the server waits for the next incoming connection.

+ EX9.2 Improve chat
  + Add nickname
  + Add funcion which client can close the connection and leave the chat
