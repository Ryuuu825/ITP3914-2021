FILE = \
		src/com/Main.java \
        src/com/Bingo/Player.java \
        src/com/Bingo/Card.java \
		src/com/Bingo/Host.java \



OUTPUT_PATH = "./build"

COMPILER = javac 

TEST_DIR = "com.Test."
MAIN = "com.Main"

excute: class
	java -cp $(OUTPUT_PATH) $(MAIN)

class: ./src/com/Main.java
	javac -d $(OUTPUT_PATH) $(FILE)


test: 
	javac -d $(OUTPUT_PATH) $(FILE) src/com/Test/*.java
	java -cp $(OUTPUT_PATH) $(TEST_DIR)Test1
	java -cp $(OUTPUT_PATH) $(TEST_DIR)Test2
	java -cp $(OUTPUT_PATH) $(TEST_DIR)Test3


clean:
	find ./build -type f -name "*.class" -delete
