package com.example.plugins

import com.example.routes.customersRoutes
import com.example.routes.restaurantsRoutes
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("FSW Kotlin API")
        }
        customersRoutes()
        restaurantsRoutes()
//        ordersRoutes()
    }
}
