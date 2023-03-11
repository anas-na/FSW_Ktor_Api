package com.example.routes

import com.example.extension.toDto
import com.example.models.ErrorResponse
import com.example.models.User
import com.example.service.usersService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import org.litote.kmongo.newId
import com.example.extension.toUser
import com.example.models.UsersDto

fun Route.customersRoutes() {
    val service = usersService()

    route("/users") {
        get {
            val usersList = service.findAll()
                .map(User::toDto)
            call.respond(usersList)

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