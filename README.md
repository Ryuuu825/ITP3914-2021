# BINGO

## Information

``` 

    Author      :       Lee Kai Pui
    Student ID  :       210339487
    Lanuage     :       Java

    Module      :       ITP 3914 - Programming
    Course      :       IT114105 - HD in Software Enginereeing
    Create Date :       19-10-2021

```

## Description 

A simple Bingo game run on the console. [Example](https://youtu.be/ANwucID0vAo)

The porgram will display two players' card on the screen. To meet the requirment of the assignment , the arrangememt of 25 numbers on the cards are ***fixed*** by default. Also , a game host need to input a number to program. According to the corresponding number on players' cards, the game will mark a "XX" to replace the number if the number are the same. The program will terminate when player / players win.


## How to win the game?

A player finds the selected numbers are arranged on their card in same row / column / diagonal .

<img src="./photo/win_example.png" style="width:200px;"/>

***
# Get Start (**Make sure you compile first**)

## How to compile?

### If you hava GNU's make

```
make class
```

### else

```
javac -d "./build" src/com/Main.java src/com/Bingo/*.java 
```

## How to run ?

### If you hava GNU's make

```
make excute
```

### else

``` 
java -cp "./build" com.Main
```

***


# What inside the directory?

```
.
├── README.md
├── build
│   └── com
│       ├── Bingo
│       │   ├── Card.class
│       │   ├── Host.class
│       │   └── Player.class
│       ├── Main.class
│       └── Test
├── docs
│   ├── Abstract_idea.txt
│   └── Assignment2122_v1.pdf
├── log
│   └── default_testcase.log
├── makefile
├── photo
│   └── win_example.png
└── src
    └── com
        ├── Bingo -> (Structure of the Bingo)
        │   ├── Card.java <- (Here is something you may want to take a look)
        │   ├── Host.java
        │   └── Player.java
        ├── Main.java -> (The Game)
        └── Test
            ├── Test1.java
            ├── Test2.java
            └── Test3.java
```


