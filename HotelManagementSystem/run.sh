#!/bin/bash
echo "Hotel Management System - Startup Script"
echo "=========================================="

# Check if MySQL JDBC driver exists
if [ ! -f "lib/mysql-connector-java-8.0.33.jar" ]; then
    echo "ERROR: MySQL JDBC driver not found!"
    echo "Please download mysql-connector-java-8.0.33.jar and place it in the lib folder"
    echo "Download from: https://dev.mysql.com/downloads/connector/j/"
    exit 1
fi

echo "Compiling Java files..."
javac -cp "lib/mysql-connector-java-8.0.33.jar" -d . src/hms/*.java

if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

echo "Starting Hotel Management System..."
java -cp ".:lib/mysql-connector-java-8.0.33.jar" hms.HMS
