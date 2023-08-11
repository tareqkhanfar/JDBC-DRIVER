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
### Testing
Ensure to write appropriate tests to verify the functionality of the service.

### Conclusion
This project facilitates database operations and is designed to be flexible for different database vendors.
 It can be utilized as a foundational layer in various Java-based applications.




