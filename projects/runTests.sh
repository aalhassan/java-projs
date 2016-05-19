#! /bin/sh
  
java -classpath lib/analyzer.jar:config java112.analyzer.LexicalDensityTester src/java112/analyzer/lexicalTestFile.txt TEST_Java112_test.LexicalDensityOutput.txt
