package com.example.plugins

import com.example.routes.customersRoutes
import com.example.routes.ordersRoutes
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        customersRoutes()
        ordersRoutes()
    }
}
