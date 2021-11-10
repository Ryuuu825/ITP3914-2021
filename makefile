FILE = \
		src/com/Main.java \
        src/com/Bingo/Player.java \
        src/com/Bingo/Card.java \
		src/com/Bingo/Host.java \



OUTPUT_PATH = "./build"

COMPILER = javac 

TEST = "com.Test.Test1"
MAIN = "com.Main"

excute: class
	java -cp $(OUTPUT_PATH) $(MAIN)

class: ./src/com/Main.java
	javac -d $(OUTPUT_PATH) $(FILE)


test: 
	javac -d $(OUTPUT_PATH) $(FILE) src/com/Test/Test1.java
	java -cp $(OUTPUT_PATH) $(TEST)

clean:
	find ./build -type f -name "*.class" -delete
