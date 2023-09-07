# Steps to run with H2 
1. Build and test the backend: `mvn clean install`
2. Start the backend api: `java -jar target/SuperPriceBackend-0.0.1-SNAPSHOT.jar`
3. Access API with curl:


GET request to retrieve all products:
```sh
curl -X GET http://localhost:8080/api/books
```
GET request to retrieve a product by ID (replace 1 with the actual ID):

```sh
curl -X GET http://localhost:8080/api/books/1
```

POST request to add a new product:
```sh
curl -X POST -H "Content-Type: application/json" -d '{"name": "New Book", "price": 123.45}' http://localhost:8080/api/books
```

PUT request to update a product (replace 1 with the actual ID):
```sh
curl -X PUT -H "Content-Type: application/json" -d '{"name": "Updated Book", "price": 100.50}' http://localhost:8080/api/books/1
```

DELETE request to remove a product (replace 1 with the actual ID):
```sh
curl -X DELETE http://localhost:8080/api/books/1
```

GET request to search products by name (replace "Book Name" with the actual name):
```sh
curl -X GET "http://localhost:8080/api/books/search/name?name=Book Name"
```

GET request to search products by price range (replace 100 and 200 with actual values):
```sh
curl -X GET "http://localhost:8080/api/books/search/price?minPrice=100&maxPrice=200"
```

# Steps if you want to use MySQL
1. Setup MySQL
2. Configure MySQL by running `sh mysql_config.sh`
3. Build the backend: `mvn clean install`
4. Start the backend: `java -jar target/SuperPriceBackend-0.0.1-SNAPSHOT.jar`
5. Install Flask with pip: `python -m pip install flask requests`
6. Start the front end: `cd frontend && python app.py`
7. Go to `http://127.0.0.1:5000`
