# ITP 3914 - BINGO

## Description 

A simple Bingo game run on the console. 

The porgram will display two players' card on the screen. To meet the requirment of the assignment , the arrangememt of 25 numbers on the cards are ***fixed*** by default. Also , a game host need to input a number to program. According to the corresponding number on players' cards, the game will mark a "XX" to replace the number if the number are the same. The program will terminate when player / players win.


## How to win the game?

A player finds the selected numbers are arranged on their card in same row / column / diagonal .

<img src="./photo/win_example.png" style="width:200px;"/>

***
# Get Started

```
javac -d "./build" src/com/Main.java src/com/Bingo/*.java;
java -cp "./build" com.Main
```

***


