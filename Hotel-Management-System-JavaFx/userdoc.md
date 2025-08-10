#### Steps to start the project:
- Download and install Java 21 : https://builds.openlogic.com/downloadJDK/openlogic-openjdk/21.0.8+9/openlogic-openjdk-21.0.8+9-windows-x64.msi
- Download Java FX SDK: https://download2.gluonhq.com/openjfx/21.0.8/openjfx-21.0.8_windows-x64_bin-sdk.zip
- Download MySQL: https://dev.mysql.com/downloads/file/?id=544662
- Insert data into mysql : Script can be found in `mysql-init/` folder
- Download Maven and setup maven: https://dlcdn.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.zip
- Run command to generate a project `mvn clean install`
- Run command to start the project
  ```bash
  java --module-path "C:\Users\hp\Downloads\javafx-sdk-17.0.16\lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics --add-opens java.base/java.lang.reflect=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -jar Hotel-Management-System-JavaFx-1.0-SNAPSHOT.jar
  ```
