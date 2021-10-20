##.SUFFIXES: .java .class
FILE = \
        src/com/Bingo/Main.java \
        src/com/Bingo/Player.java \
        src/com/Bingo/Card.java \
		src/com/Bingo/Game.java \



OUTPUT_PATH = "./build"

TARGET = "com.Bingo.Main"

default: class
	java -cp $(OUTPUT_PATH) $(TARGET)

class: 
	javac -d $(OUTPUT_PATH) $(FILE)

excute: 
	java -cp $(OUTPUT_PATH) $(TARGET)
clean:
	rm -r ./build/*



	
