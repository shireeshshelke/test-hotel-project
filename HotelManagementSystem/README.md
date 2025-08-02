# Hotel Management System

A comprehensive Hotel Management System built with Java Swing and MySQL database. This system allows hotel administrators to manage customer check-ins, check-outs, room allocation, and billing.

## Features

- **User Authentication**: Secure login system with admin credentials
- **Customer Management**: Add new customers with personal details
- **Room Management**: Track room availability and status
- **Check-in/Check-out**: Complete booking and checkout process
- **Billing System**: Generate customer bills and track payments
- **Admin Panel**: View all registered users and customers

## Technologies Used

- **Frontend**: Java Swing (GUI)
- **Backend**: Java
- **Database**: MySQL
- **IDE**: IntelliJ IDEA (recommended)
- **JDBC**: For database connectivity

## Prerequisites

Before running this application, make sure you have:

1. **Java Development Kit (JDK) 8 or higher**
2. **MySQL Server** installed and running
3. **MySQL JDBC Driver** (mysql-connector-java-8.0.33.jar or latest)
4. **IDE** like IntelliJ IDEA, Eclipse, or NetBeans

## Database Setup

1. Start your MySQL server
2. Run the SQL script located in `database/setup.sql`:
   ```sql
   mysql -u root -p < database/setup.sql
   ```
3. This will create:
   - Database named `hms`
   - Tables: `login`, `room`, `customer`
   - Default admin user (username: admin, password: admin123)
   - Sample room data

## Project Structure

```
HotelManagementSystem/
├── src/hms/
│   ├── HMS.java              # Main entry point
│   ├── Login.java            # Login form
│   ├── signup.java           # User registration
│   ├── Dashboard.java        # Main dashboard
│   ├── NewCustomer.java      # Customer registration
│   ├── Checkout.java         # Customer checkout
│   ├── Bills.java            # Customer information display
│   ├── admin.java            # Admin panel
│   └── conn.java             # Database connection
├── database/
│   └── setup.sql             # Database setup script
├── lib/
│   └── (MySQL JDBC driver should be placed here)
└── README.md
```

## Installation and Setup

### Step 1: Download MySQL JDBC Driver
1. Download `mysql-connector-java-8.0.33.jar` from [MySQL official website](https://dev.mysql.com/downloads/connector/j/)
2. Place the JAR file in the `lib/` directory

### Step 2: Database Configuration
1. Ensure MySQL is running on `localhost:3306`
2. Create database using the provided SQL script:
   ```bash
   mysql -u root -p < database/setup.sql
   ```
3. Verify the database is created with sample data

### Step 3: Compile and Run

#### Using Command Line:
```bash
# Navigate to project directory
cd HotelManagementSystem

# Compile all Java files
javac -cp "lib/mysql-connector-java-8.0.33.jar" -d . src/hms/*.java

# Run the application
java -cp ".:lib/mysql-connector-java-8.0.33.jar" hms.HMS
```

#### Using IntelliJ IDEA:
1. Open IntelliJ IDEA
2. Import the project folder
3. Add MySQL JDBC driver to project libraries:
   - File → Project Structure → Libraries → + → Java → Select the JAR file
4. Run `HMS.java`

#### Using Eclipse:
1. Import the project as "Existing Projects into Workspace"
2. Add MySQL connector to build path:
   - Right-click project → Properties → Java Build Path → Libraries → Add External JARs
3. Run `HMS.java`

## Usage

### Default Login Credentials
- **Username**: admin
- **Password**: admin123

### Main Features:

1. **Login**: Use admin credentials to access the system
2. **Sign Up**: Create new admin users
3. **New Customer Entry**: Register new customers and assign rooms
4. **Check-out**: Process customer checkout and update room status
5. **All Customer Info**: View all customer records
6. **Admin Panel**: View all registered admin users

### Workflow:
1. Start the application
2. Login with admin credentials
3. Use "New Customer Entry" to add customers
4. Assign available rooms to customers
5. Use "Check-out" to process departures
6. View customer information anytime

## Database Schema

### Tables:

1. **login**
   - username (VARCHAR) - Primary Key
   - password (VARCHAR)

2. **room**
   - room_number (INT) - Primary Key
   - status (VARCHAR) - 'empty' or 'booked'
   - price (INT)
   - bed_type (VARCHAR) - 'Single' or 'Double'
   - rtype (VARCHAR) - Room type

3. **customer**
   - id (VARCHAR) - ID type
   - number (VARCHAR) - Primary Key (ID number)
   - name (VARCHAR)
   - gender (VARCHAR)
   - country (VARCHAR)
   - room_number (INT)
   - room_price (INT)
   - mob1 (VARCHAR) - Mobile number
   - email (VARCHAR)
   - datein (VARCHAR) - Check-in date
   - dateout (VARCHAR) - Check-out date
   - status (VARCHAR) - 'check in' or 'check out'

## Troubleshooting

### Common Issues:

1. **Database Connection Error**:
   - Ensure MySQL is running
   - Check username/password in `conn.java`
   - Verify database name is correct

2. **ClassNotFoundException**:
   - Ensure MySQL JDBC driver is in classpath
   - Check if JAR file is properly added to project

3. **SQL Exception**:
   - Run the database setup script
   - Check if all tables are created
   - Verify table structure matches the code

### Configuration Changes:

If you need to modify database settings, edit the `conn.java` file:
```java
c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","your_password");
```

## Future Enhancements

- Room booking calendar
- Payment integration
- Report generation
- Customer history tracking
- Email notifications
- Multiple hotel support

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is created for educational purposes. Feel free to use and modify as needed.

## Support

For any issues or questions, please check the troubleshooting section above or create an issue in the repository.
