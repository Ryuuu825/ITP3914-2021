##.SUFFIXES: .java .class
FILE = \
        src/HelloWorld.java


SOURCE_PATH = "./src/"
OUTPUT_PATH = "./bin"

EXCUTE_FILE = "HelloWorld"

excute:
	java -cp $(OUTPUT_PATH) $(EXCUTE_FILE)

class: src/HelloWorld.java
	javac -d $(OUTPUT_PATH) $(FILE)

clean:
	rm ./bin/*.class



	
