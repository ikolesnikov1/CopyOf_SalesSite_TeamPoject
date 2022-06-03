GET
---
http://localhost:8081/rest/user/authenticate
---
Requests
---
{
	"email":"test@user.com",
	"password":"testuser"
}
or
{
	"email":"test@admin.com",
	"password":"testadmin"
}
---
GET
http://localhost:8081/rest/sales
---
GET By ID
http://localhost:8081/rest/sales/1
---
POST
http://localhost:8081/rest/sales
---
PUT
http://localhost:8081/rest/sales
---
DELETE
http://localhost:8081/rest/sales/1
---
Requests
{
    "title": "Spring in Action",
    "type_product": "Овощь",
    "coverPhotoURL": "https://images-na.ssl-images-amazon.com/images/I/51gHy16h5TL.jpg",
    "old_price": 9789351197997,
    "new_price": 630,
    "date_start": "06.04.2022"
    "date_end": "10.05.2022"
}
{
    "title": "Java Persistence with Hibernate",
    "type_product": "Овощь",
    "coverPhotoURL": "https://images.manning.com/720/960/resize/book/d/2ea186d-c683-4d54-95f9-cca25b6fe49e/bauer2.png",
    "old_price": 9351199193,
    "new_price": 771,
    "date_start": "06.04.2022"
    "date_end": "10.05.2022"
}
{
    "title": "Grails in Action",
    "type_product": "Овощь",
    "coverPhotoURL": "https://images.manning.com/720/960/resize/book/6/3e9d5ed-4155-466d-ab46-538bb355948d/gsmith2.png",
    "old_price": 1617290963,
    "new_price": 2907,
    "date_start": "06.04.2022"
    "date_end": "10.05.2022"
}
{
    "title": "Spring Boot in Action",
    "type_product": "Овощь",
    "coverPhotoURL": "https://images.manning.com/720/960/resize/book/6/bb80688-f898-4df7-838a-253b1de123c4/Walls-SpringBoot-HI.png",
    "old_price": 1617292540,
    "new_price": 3149,
    "date_start": "06.04.2022"
    "date_end": "10.05.2022"
}
{
    "title": "Head First Java: A Brain-Friendly Guide",
    "type_product": "Овощь",
    "coverPhotoURL": "https://covers.oreillystatic.com/images/9780596004651/lrg.jpg",
    "old_price": 8173666024,
    "new_price": 498,
    "date_start": "06.04.2022"
    "date_end": "10.05.2022"
}
---
