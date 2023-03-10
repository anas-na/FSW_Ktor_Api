package com.example.routes

import com.example.models.ErrorResponse
import com.example.models.User
import com.example.service.usersService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.litote.kmongo.Id
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import org.litote.kmongo.newId

fun Route.customersRoutes() {
    val service = usersService()

    route("/users") {
        get {
            val peopleList =
                service.findAll()
            println(peopleList)
            call.respond(peopleList)
        }
//        get("/{id?}") {
//            val id = call.parameters["id"] ?: return@get call.respondText(
//                "Missing or malformed id",
//                status = HttpStatusCode.BadRequest
//            )
//            val customer =
//                customersList.find { it.id.toString() == id } ?: return@get call.respondText(
//                    "No customer with id $id",
//                    status = HttpStatusCode.NotFound
//                )
//            call.respond(customer)
//        }
        post {
            val customer = call.receive<User>()
            service.create(customer)
                ?.let { userId ->
                    call.response.headers.append("My-User-Id-Header", userId.toString())
                    call.respond(HttpStatusCode.Created)
                } ?: call.respond(HttpStatusCode.BadRequest, ErrorResponse.BAD_REQUEST_RESPONSE)
//            customersList.added(customer)
            call.respondText("customer added correctly", status = HttpStatusCode.Created)
            call.respondText("create customer")
        }
//        delete("/{id?}") {
//            call.respondText("delete customer")
//            val id = call.parameters["id"] ?: return@delete call.respondText(
//                "Missing or malformed id",
//                status = HttpStatusCode.BadRequest
//            )
//            if (customersList.removeIf { it.id.toString() == id }) {
//                call.respondText("customer removed correctly", status = HttpStatusCode.Accepted)
//            } else {
//                call.respondText("customer not found", status = HttpStatusCode.NotFound)
//            }
//        }
    }

}