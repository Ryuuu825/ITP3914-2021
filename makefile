##.SUFFIXES: .java .class
FILE = \
        src/com/Bingo/Main.java \
        src/com/Bingo/Player.java \
        src/com/Bingo/Card.java



OUTPUT_PATH = "./build"

TARGET = "com.Bingo.Main"

excute:
	java -cp $(OUTPUT_PATH) $(TARGET)

class: 
	javac -d $(OUTPUT_PATH) $(FILE)

clean:
	rm -r ./build/*



	
