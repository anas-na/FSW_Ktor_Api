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
        admins = this.admins,
        lunchMenu = this.lunchMenu,
        dinnerMenu = this.dinnerMenu,
        brunchMenu = this.brunchMenu
    )

fun RestaurantsDto.toRestaurant(): Restaurant =
    Restaurant(
        name = this.name,
        address = this.address,
        phoneNumber = this.phoneNumber,
        email = this.email,
        admins = this.admins,
        lunchMenu = this.lunchMenu,
        dinnerMenu = this.dinnerMenu,
        brunchMenu = this.brunchMenu
    )