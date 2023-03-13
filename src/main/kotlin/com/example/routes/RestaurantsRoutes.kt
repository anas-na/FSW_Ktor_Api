package com.example.routes

import com.example.models.Restaurant
import com.example.models.RestaurantsDto
import com.example.extension.toDto
import com.example.extension.toRestaurant
import com.example.service.RestaurantsService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.restaurantsRoutes() {
    val service = RestaurantsService()
    route("/restaurants") {
        get {
            val restaurants = service.findAll()
                .map(Restaurant::toDto)
            if (restaurants.isEmpty()) {
                call.respondText("No restaurants found", status = HttpStatusCode.NotFound)
            } else {
                call.respond(restaurants)
            }
        }
        get("/{id}") {
            val id = call.parameters["id"].toString()
            service.findById(id)
                ?.let { foundRestaurant -> call.respond(foundRestaurant.toDto()) }
                ?: call.respond(HttpStatusCode.NotFound, "Restaurant not found")
        }
        post {
            val restaurant = call.receive<Restaurant>()
            service.create(restaurant)
                ?.let { restaurantId ->
                    call.response.headers.append("My-Restaurant-Id-Header", restaurantId.toString())
                    call.respond(HttpStatusCode.Created)
                } ?: call.respond(HttpStatusCode.BadRequest, "Bad request")
            call.respondText("Restaurant added correctly", status = HttpStatusCode.Created)
        }
        put("/{id}") {
            val id = call.parameters["id"].toString()
            val request = call.receive<RestaurantsDto>()
            val restaurant = request.toRestaurant()
            val updated = service.updateRestaurant(id, restaurant)
            if (updated) {
                call.respondText("Restaurant updated correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respond(HttpStatusCode.BadRequest, "Bad request")
            }
        }
        delete("/{id}") {
            val id = call.parameters["id"].toString()
            val deleted = service.deleteRestaurant(id)
            if (deleted) {
                call.respondText("Restaurant deleted correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respond(HttpStatusCode.BadRequest, "Bad request")
            }
        }

    }

}