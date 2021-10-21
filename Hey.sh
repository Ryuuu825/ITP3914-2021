#! /bin/bash

# build date
# const info for each build
DATE=$(date)
JAVA_VERSION=$(java -version 2>&1 | grep 'version' | awk '{printf $3}' )

#----------------------------------------------

# which os that build it
case "$OSTYPE" in
  darwin*)  Paltform="MacOS" ;; 
  linux*)   Paltform="Linux" ;;
  msys*)    Paltform="Windows" ;;
  cygwin*)  Paltform="Windows" ;;
esac

#----------------------------------------------

# clean up the last build before this build
  find ./build -type f -name "*.class" -delete

#----------------------------------------------

# The target file to place the log function
TESTFILE="./log/default_testcase.log"

# formatting
printf "\n" >> $TESTFILE
for ((i=0;i<30;i++)) do
    printf "-" >> $TESTFILE
done 
printf "\n" >> $TESTFILE

# Header information 
echo "Date" : $DATE >> $TESTFILE
printf "Platform : %s \n" $Paltform >> $TESTFILE
printf "JDK version : %s \n" $JAVA_VERSION >> $TESTFILE
printf "Result:\t" >> $TESTFILE

#----------------------------------------------

printf "[Compiling...]\n" 

# redirect the error raised by javac to the temp.log
javac -d "./build"  src/com/Bingo/Player.java src/com/Bingo/Card.java src/com/Bingo/Host.java src/com/Main.java 2> temp.log

# check javac's exit code 
if [[ $? != 0 ]] 
then 
  # which mean javac throw a error
  printf "[Compiling Fail]\n" >> $TESTFILE
  printf "[Compiling Fail]\n"

  # copy error message to log file
  error_message=$(cat temp.log |  grep 'error')
  printf  "\noutput :\n\t" >> $TESTFILE
  printf $error_message >> $TESTFILE 

  # remove the temp file
  rm temp.log

  # clean up before terminate the script
  find ./build -type f -name "*.class" -delete

  # put javac's exit code to the log file
  printf "[EXIT CODE : %d] \n" $? >> $TESTFILE 
  exit -1

else 
  printf "[Compiling Success]\n" >> $TESTFILE
fi




#----------------------------------------------



printf "[ Logging ...]\n\tAll output directed to -> %s\n"  $TESTFILE

for ((i=0;i<10;i++)) do
    printf "-" 
done 
printf "[Running]"
for ((i=0;i<10;i++)) do
    printf "-" 
done 
printf "\n"

printf "\nOutput : \n" >> $TESTFILE

# redirect the error raised to the file (if have)
# run the .class run
java -cp "./build" "com.Main" 2>> $TESTFILE >> $TESTFILE

# place the exit code of this excution
printf "[EXIT CODE : %d] \n" $? >> $TESTFILE

# prompt user that script terminate
for ((i=0;i<10;i++)) do
    printf "-" 
done 
printf "[Finish]"
for ((i=0;i<10;i++)) do
    printf "-" 
done 
printf "\n"

