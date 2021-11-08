FILE = \
        src/com/Main.java \
        src/com/Bingo/Player.java \
        src/com/Bingo/Card.java \
		src/com/Bingo/Host.java \



OUTPUT_PATH = "./build"

COMPILER = javac 

#TARGET = "com.Test"
TARGET = "com.Main"

excute: class
	java -cp $(OUTPUT_PATH) $(TARGET)

class: ./src/com/Main.java
	javac -d $(OUTPUT_PATH) $(FILE)



clean:
	rm -r ./build/*
