package com.example.extension

import com.example.models.User
import com.example.models.UsersDto

fun User.toDto(): UsersDto =
    UsersDto(
        id = this.id?.toString(),
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email,
        phoneNumber = this.phoneNumber,
        password = this.password,
        isRestaurantAdmin = this.isRestaurantAdmin,
    )

fun UsersDto.toUser(): User =
    User(
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email,
        phoneNumber = this.phoneNumber,
        password = this.password,
        isRestaurantAdmin = this.isRestaurantAdmin,
    )