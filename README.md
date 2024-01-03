# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Create a Spring Boot application with Spring Web & Spring Data MongoDB dependencies](https://start.spring.io/)
* [Download MongoDB](https://www.mongodb.com/try/download/community)
* Install MongoDB
* Create `empdb` using the following steps:
    1. Click on the plus icon next to the database.
    2. Give the database name as `empdb`.
    3. Give the collection name as 'EMPLOYEE'.
    4. Click on CREATE DATABASE.
    5. Click on the top menu CONNECT.
    6. Click on NEW CONNECTION.
    7. Click on ADVANCED OPTIONS.
    8. Click on AUTHENTICATION.
    9. Click on USERNAME/PASSWORD.
    10. Provide the username and password as ROOT ROOT.
    11. Give the authentication database name as `empdb`.
    12. Click on SAVE AND CONNECT.

Run the Spring Boot application.

Execute the following APIs:

1. **Create Employee:**
    - Endpoint: [http://localhost:8080/api/employee/v1/create](http://localhost:8080/api/employee/v1/create)
    - Request:
      ```json
      {
        "id": 100,
        "employeeId": "a53bdc39-db0d-4e56-87a2-c80476e5994f",
        "isActive": false,
        "age": 40,
        "firstName": "WORKMAN",
        "lastName": "BLANKENSHIP",
        "gender": "MALE",
        "createdOn": "2023-06-17 19:04:58",
        "email": "workmanblankenship@printspan.com",
        "phone": "+1 (882) 458-2315",
        "address": "273 Oxford Street, Galesville, Guam, 1424"
      }
      ```

2. **Create All Employees:**
    - Endpoint: [http://localhost:8080/api/employee/v1/createAll](http://localhost:8080/api/employee/v1/createAll)
    - Request:
      ```json
      [
        {
          "id": 0,
          "employeeId": "4b6eb9cd-519b-4ad9-b636-7996f86549b9",
          "picture": "http://placehold.it/32x32",
          "age": 29,
          "firstName": "STEPHANIE",
          "lastName": "WYNN",
          "gender": "FEMALE",
          "createdOn": "2023-12-10 09:16:46",
          "email": "stephaniewynn@sequitur.com",
          "phone": "+1 (851) 507-3668",
          "address": "701 Crystal Street, Dunlo, Florida, 4535"
        } 
      ]
      ```

3. **Generate Data Using:**
    - [JSON Generator](https://json-generator.com/)
    - Properties:
      ```json
      [
        '{{repeat(5, 5)}}',
        {
          id: '{{index()}}',
          employeeId: '{{guid()}}',
          age: '{{integer(20, 40)}}',
          firstName: '{{firstName().toUpperCase()}}',
          lastName: '{{surname().toUpperCase()}}',
          gender: '{{gender().toUpperCase()}}',
          createdOn: '{{date(new Date(2023, 0, 1), new Date(), "YYYY-MM-dd HH:mm:ss")}}',
          email: '{{email()}}',
          phone: '+1 {{phone()}}',
          address: '{{integer(100, 999)}} {{street()}}, {{city()}}, {{state()}}, {{integer(100, 10000)}}'
        }
      ]
      ```

4. **Get All Employees:**
    - Endpoint: [http://localhost:8080/api/employee/v1/allEmployee](http://localhost:8080/api/employee/v1/allEmployee)

5. **Find Employee by Last Name:**
    - Endpoint: [http://localhost:8080/api/employee/v1/findByLastName/TERRELL](http://localhost:8080/api/employee/v1/findByLastName/TERRELL)

6. **Get Paginated Employees:**
    - Endpoint: [http://localhost:8080/api/employee/v1/allEmployee/3/5](http://localhost:8080/api/employee/v1/allEmployee/3/5)

7. **Get Employees by Age Range:**
    - Endpoint: [http://localhost:8080/api/employee/v1/allEmployeeByAge/20/32](http://localhost:8080/api/employee/v1/allEmployeeByAge/20/32)

8. **Search Employee by Name:**
    - Endpoint: [http://localhost:8080/api/employee/v1/searchEmployee/ha](http://localhost:8080/api/employee/v1/searchEmployee/ha)
