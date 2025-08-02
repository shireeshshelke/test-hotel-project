@echo off
echo Hotel Management System - Startup Script
echo ==========================================

REM Check if MySQL JDBC driver exists
if not exist "lib\mysql-connector-java-8.0.33.jar" (
    echo ERROR: MySQL JDBC driver not found!
    echo Please download mysql-connector-java-8.0.33.jar and place it in the lib folder
    echo Download from: https://dev.mysql.com/downloads/connector/j/
    pause
    exit /b 1
)

echo Compiling Java files...
javac -cp "lib\mysql-connector-java-8.0.33.jar" -d . src\hms\*.java

if errorlevel 1 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo Starting Hotel Management System...
java -cp ".;lib\mysql-connector-java-8.0.33.jar" hms.HMS

pause
