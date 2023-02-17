# to compile and create jar 
javac -d ./build -sourcepath src src/com/company/*.java
cd build
jar cfm ./triangles.jar ../META-INF/MANIFEST.MF com/company/*.class
cd ..

# to run jar
java -jar ./build triangles.jar

# to check contents
jar tvf triangles.jar

# to extract contents of jar
jar xf triangles.jar


