package com.example.extension

import com.example.models.Restaurant
import com.example.models.RestaurantsDto

fun Restaurant.toDto(): RestaurantsDto =
    RestaurantsDto(
        id = this.id?.toString(),
        name = this.name,
        address = this.address,
        phoneNumber = this.phoneNumber,
        email = this.email,
        password = this.password,
    )

fun RestaurantsDto.toRestaurant(): Restaurant =
    Restaurant(
        name = this.name,
        address = this.address,
        phoneNumber = this.phoneNumber,
        email = this.email,
        password = this.password,
    )