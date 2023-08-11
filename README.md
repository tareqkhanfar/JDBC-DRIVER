# JDBC Service Project

## Author

**[Tareq Khanfar ]**


## Introduction
This project provides a service layer to handle various database operations such as querying, inserting, updating, deleting, and more. It includes a transaction handling service and has support for different databases.

## Features

### 1. Query Execution
- Execute standard queries with `fetchByQuery`.
- Execute paginated queries with `fetchByQueryWithPaging`, supported for MySQL and Oracle databases.

### 2. CRUD Operations
- **Insert**: Add new records using `insert`.
- **Update**: Modify existing records using `Update`.
- **Delete**: Remove records using `Delete`.
- **Create Table**: Create a new table using `createTable`.

### 3. Transaction Management
- **Start**: Begin a new transaction with `startTransaction`.
- **Commit**: Commit a transaction with `commit`.
- **Rollback**: Rollback a transaction with `rollback`.
- **End**: End a transaction with `endTransaction`.

### 4. Connection Management
- Retrieve and manage connections with Agroal data sources.
- Auto-reconnection support within active transactions.

### 5. Pagination Support
- Implement pagination in query results for supported databases.

### 6. Exception Handling
- Includes custom exceptions like `NoMorePagesToFetchException`.

## Setup
Include the required dependencies for Jakarta EE and Agroal in your project.

## Usage

### Authentication
Use the `Authunticate` method with the proper credentials to get the database metadata.

### Query Execution
```java
// Example for fetching data
List<LinkedHashMap<String, Object>> data = fetchByQuery(token, query);

```
 ### Transaction Handling
    // Example of starting a transaction
    String transactionToken = startTransaction();
    // Commit
    commit(transactionToken);
    // Rollback
    rollback(transactionToken);

    ## Client and Server JAR Files

This project includes pre-compiled JAR files for both the client and server components. They can be found in the `jar` directory of the repository.

### Server JAR

To run the server, execute the following command:

```bash
java -jar server.jar
```
### Client JAR
To run the client, execute the following command:

```
java -jar client.jar

```
### Configuration
You may need to configure certain parameters for both the client and server. Examples of these configurations include database connections, server ports, etc. The configuration files can be found in the config directory and can be modified as per your requirements.

### Dependencies
Make sure you have the required dependencies installed in your system, including:

Java version 8 or higher
Any other dependencies required by the project

## Author
[Tareq khanfar , Email : tareqkhanfar29@gmail.com ]

### Testing
Ensure to write appropriate tests to verify the functionality of the service.

### Conclusion
This project facilitates database operations and is designed to be flexible for different database vendors.
 It can be utilized as a foundational layer in various Java-based applications.




