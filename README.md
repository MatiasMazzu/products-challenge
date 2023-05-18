# App de productos

# REST API

Las REST APIs de esta app están desciptas debajo.


## GET una lista de productos

### Request

`GET /products/`

    curl -i -H 'Accept: application/json' http://localhost:8080/products/

### Response

    HTTP/1.1 200 OK
    Date: Thu, 18 May 2023 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 36

```
[
    {
        "id": 1,
        "name": "Campari",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 100.0
    },
    {
        "id": 2,
        "name": "Pepsi",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 30.0
    },
    {
        "id": 3,
        "name": "Coca",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 120.0
    },
    {
        "id": 4,
        "name": "Manaos",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 110.0
    },
    {
        "id": 5,
        "name": "7up",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 130.0
    }
]
```
## GET una lista de productos ordenada por precio

### Request

`GET /products/order/price/`

    curl -i -H 'Accept: application/json' http://localhost:8080/products/order/price/

### Response

    HTTP/1.1 200 OK
    Date: Thu, 18 May 2023 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 36

```
[
    {
        "id": 2,
        "name": "Pepsi",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 30.0
    },
    {
        "id": 1,
        "name": "Campari",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 100.0
    },
    {
        "id": 4,
        "name": "Manaos",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 110.0
    },
    {
        "id": 3,
        "name": "Coca",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 120.0
    },
    {
        "id": 5,
        "name": "Exe se la come",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 130.0
    }
]
```
## GET un producto por id

### Request

`GET /products/order/price/`

    curl -i -H 'Accept: application/json' http://localhost:8080/{id}

### Response

    HTTP/1.1 200 OK
    Date: Thu, 18 May 2023 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 36

```
[
    {
        "id": 2,
        "name": "Pepsi",
        "description": "Bebida alcoholica",
        "stock": 50,
        "price": 30.0
    }
]
```
## POST un producto

### Request

`POST /products/`

	curl --location --request POST 'localhost:8080/products/' \
	--header 'Content-Type: application/json' \
	--data-raw 
	'{
        	"name": "Coca",
        	"description": "Gaseosa",
        	"stock": 50,
        	"price": 130.0
	  }'

### Response

    HTTP/1.1 200 OK
    Date: Thu, 18 May 2023 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 36

## PUT o update un producto

### Request

`PUT /products/{id}`

	curl --location --request PUT 'localhost:8080/products/1' \
	--header 'Content-Type: application/json' \
	--data-raw 
	'{
        	"name": "Pepsi",
        	"description": "Bebida alcoholica",
        	"stock": 50,
        	"price": 130.0
	}'

### Response

    HTTP/1.1 200 OK
    Date: Thu, 18 May 2023 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 36

## DELETE un producto

### Request

`DELETE /products/{id}`

	curl -i -H 'Accept: application/json' http://localhost:8080/products/{id}

### Response

    HTTP/1.1 200 OK
    Date: Thu, 18 May 2023 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 36








