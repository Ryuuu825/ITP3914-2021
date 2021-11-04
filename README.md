# BINGO

## Information

``` 

    Author      :       Lee Kai Pui
    Student ID  :       210339487
    Lanuage     :       Java

    Moudle      :       ITP 3914 - Programming
    Course      :       IT114105 - HP in Software Enginereeing
    Create Date :       19-10-2021

```

## Description 

A simple Bingo game run on the console. [Example](https://www.youtube.com/watch?v=dQw4w9WgXcQ)

The porgram will display two players' card on the screen. To meet the requirment of the assignment , the arrangememt of 25 numbers on the cards are ***fixed*** by default. Also , a game host need to input a number to program. According to the corresponding number on players' cards, the game will mark a "XX" to replace the number if the number are the same. The program will terminate when player / players win.


## How to win the game?

A player finds the selected numbers are arranged on their card in same row / column / diagonal .

<img src="./photo/win_example.png" style="width:200px;"/>

***
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

## How to compile?

### If you hava GNU's make


```
make class
```

### else

```
javac -d "./build" src/com/Main.java src/com/Bingo/*.java 
```

***




## TO-DO_LIST

- [] the array must be int[][]
- [] refactor the code
    -> (public method first)
- [] keep refactor 
- [] array need to be square matrix
- [] able to use register player after create instance of Host
- [] algoritrm about terminate winning

## Code quality
![adf](./photo/code_analyze.png)
