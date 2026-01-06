## Initial Setup:
### Do following steps on windows: (only needed once)
- Download and install Java 21 : https://builds.openlogic.com/downloadJDK/openlogic-openjdk/21.0.8+9/openlogic-openjdk-21.0.8+9-windows-x64.msi
- Download Java FX SDK: https://download2.gluonhq.com/openjfx/21.0.8/openjfx-21.0.8_windows-x64_bin-sdk.zip

## Commands to run in Codespace
### 1. update java version (Only execute once for a codespace)
```bash
sudo apt-get update -y && \
sudo apt-get install -y openjdk-21-jdk maven && \
sudo update-alternatives --set java /usr/lib/jvm/java-21-openjdk-amd64/bin/java || true && \
sudo update-alternatives --set javac /usr/lib/jvm/java-21-openjdk-amd64/bin/javac || true &&
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
```

### 2. Build the project
```bash
cd /workspaces/test-hotel-project/Hotel-Management-System-JavaFx && 
JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64 mvn -B clean install
```
### 3. Download the jar file at :
`Hotel-Management-System-JavaFx/target/Hotel-Management-System-JavaFx-1.0-SNAPSHOT.jar`
To download, right click on the file and download

### 4. Start database
Run following command in terminal
```bash
docker run --name mysql-server \
  -e MYSQL_ROOT_PASSWORD=yourpassword \
  -e MYSQL_DATABASE=mydatabase \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=myuserpassword \
  -p 3306:3306 \
  -v "$(pwd)/mysql-init:/docker-entrypoint-initdb.d" \
  -d mysql:latest \
  --lower_case_table_names=1
```

## Start the application
1. Once the database is up, run following command in windows:
  ```bash
  java --module-path "C:\Users\hp\Downloads\javafx-sdk-17.0.16\lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics --add-opens java.base/java.lang.reflect=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -jar Hotel-Management-System-JavaFx-1.0-SNAPSHOT.jar
  ```