package com.abhishek.em.domain.model

data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

data class UserRequest(
    val name: String,
    val email: String,
    val password: String
)

data class UserResponse(
    val token: String?,
    val user: User?
)

data class User(
    val id: String?,
    val name: String?,
    val email: String?
)

/*
* {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY4ODcxZDYzOWRiY2ZiYzBjZDdlMzRmNyIsImlhdCI6MTc1MzY4NTM0NywiZXhwIjoxNzU0MjkwMTQ3fQ.U9mjsEgrik0XuraCmRw6HXsKHVZn5mri8Ud8ntl2wt0",
    "user": {
        "id": "68871d639dbcfbc0cd7e34f7",
        "name": "Abhishek",
        "email": "abhisheksoni@example.com"
    }
}*/