##.SUFFIXES: .java .class
FILE = \
        src/com/Main.java \
        src/com/Bingo/Player.java \
        src/com/Bingo/Card.java \
		src/com/Bingo/Host.java \



OUTPUT_PATH = "./build"

#TARGET = "com.Test"
TARGET = "com.Main"

default: class
	java -cp $(OUTPUT_PATH) $(TARGET)

class:
	javac -d $(OUTPUT_PATH) $(FILE)

excute:
	java -cp $(OUTPUT_PATH) $(TARGET)
clean:
	rm -r ./build/*
