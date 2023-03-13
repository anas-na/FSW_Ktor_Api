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
            val users = service.findAll()
                .map(User::toDto)
            call.respond(users)

        }
        get("/{id}") {
            val id = call.parameters["id"].toString() ?: return@get call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            service.findById(id)
                ?.let { foundUser -> call.respond(foundUser.toDto()) }
                ?: call.respond(HttpStatusCode.NotFound, ErrorResponse.NOT_FOUND_RESPONSE)
        }
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

        put("/{id}") {
            val id = call.parameters["id"].toString()
            val request = call.receive<UsersDto>()
            val user = request.toUser()
            val updated = service.updateUser(id, user)

            if (updated) {
                call.respondText("customer updated correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respond(HttpStatusCode.BadRequest, ErrorResponse.BAD_REQUEST_RESPONSE)
            }
        }
        delete("/{id}") {
            val id = call.parameters["id"].toString()
            val deleted = service.deleteUser(id)
            if (deleted) {
                call.respondText("customer deleted correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respond(HttpStatusCode.BadRequest, ErrorResponse.BAD_REQUEST_RESPONSE)
            }
        }
    }

}