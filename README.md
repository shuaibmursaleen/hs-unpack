# HS Unpack – HS Code Tax Breakdown API

**HS Unpack** is a Spring Boot-based RESTful API that provides detailed tax breakdowns for Sri Lankan import HS codes. Built with MongoDB for persistent storage and secured using JWT authentication, this service enables users to search and retrieve tax-related information associated with specific HS codes.

---

## Features

- **JWT Authentication**: Secure login and user management
- **HS Code Search**: Retrieve tax breakdowns by HS code
- **Modular MVC Structure**: Organized services for retrieval and search
- **MongoDB Integration**: Stores and serves tax breakdown data
- **CORS Configurable**: Frontend-safe with environment-based CORS support

---

## Endpoints

###  Authentication
| Method | Endpoint     | Description                              |
|--------|--------------|------------------------------------------|
| POST   | `/login`     | Authenticates user and returns a JWT     |
| GET    | `/me`        | Returns current authenticated user       |
| POST   | `/createuser`| Creates a new user account               |

###  Tax Breakdown
| Method | Endpoint              | Description                                  |
|--------|------------------------|----------------------------------------------|
| GET    | `/`                    | Retrieves all stored HS tax breakdowns (**Purely for testing purposes**)       |
| GET    | `/search?hsCode=XXXX` | Retrieves tax breakdown for a given HS code |

---

##  Setup Instructions (Requires a mongodb database with hs codes already set up)

### 1. Clone the Repository
```bash
git clone https://github.com/shuaibmursaleen/hs-unpack.git
cd hs-unpack
```

### 2. Configure Environment Variables

Create a `.env` file in the root directory:

```env
JWT_SECRET=your_jwt_secret
MONGODB_URI=your_mongodb_uri
MONGODB_DATABASE=your_mongodb_database_name
ALLOWED_ORIGIN=http://localhost:3000
```

You can refer to the provided `.env.example`.

### 3. Configure Spring Boot Properties

Create a file named `application.properties` inside `src/main/resources`:

```bash
cp application.properties.example src/main/resources/application.properties
```

Then, **fill in the missing values** like:

```application.properties
spring.application.name=hscodes
spring.config.import=optional:file:.env[.properties]
spring.data.mongodb.uri=${MONGODB_URI}
spring.data.mongodb.database=${MONGO_DATABASE}
jwtSecret=${JWT_SECRET}
allowedOrigin=${ALLOWED_ORIGIN}
```

This links your environment variables and prepares the app for execution.

### 4. Run the Application

Use Maven to build and run:

```bash
./mvnw spring-boot:run
```

---

## Testing the API

Use tools like **Postman** or **curl** to test endpoints.

1. **Register User**:

   ```http
   POST /createuser
   {
     "username": "testuser",
     "password": "testpass"
   }
   ```

2. **Login**:

   ```http
   POST /login
   {
     "username": "testuser",
     "password": "testpass"
   }
   ```

   Response will include a JWT token.

3. **Search by HS Code**:

   ```http
   GET /search?hsCode=1101.00.00
   Authorization: Bearer <your_jwt_token>
   ```

---

## Environment Variables

| Variable              | Description                       |
| --------------------- | --------------------------------- |
| `JWT_SECRET`          | Secret key for signing JWT tokens |
| `MONGODB_URI`         | MongoDB connection string         |
| `MONGODB_DATABASE`    | MongoDB database name         |
| `ALLOWED_ORIGIN`      | Allowed origin for CORS           |

---

## License

This project is open source and available under the [MIT License](LICENSE).

---