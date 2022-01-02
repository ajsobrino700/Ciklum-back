## Ciklum - Lottoland

This is a little project for the interview test.
Ths main tecnology in the project is Java 8, maven and spring boot **2.6**.

If you want to compile and run the app, there are two option:
<pre>
    mvn -U clean install
</pre>
The other option if when you do not want to run the test.
<pre>
    mvn -U clean install -DskipTests
</pre>
This command must run in th root of the proyect, then generate a *.jar in the folder target. You can run the app with the next command.
<pre>
    java -jar *.jar
</pre>
The name by default of jar is **lottoland-1.0.0.jar**.

Also in the folder *docker* of project we can find a dockerfile then we can run the app in docker with this docket file for generate the image.
