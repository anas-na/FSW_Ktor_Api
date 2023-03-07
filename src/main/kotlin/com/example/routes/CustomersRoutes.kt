package com.example.routes
import com.example.models.Customer
import com.example.models.customersList
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customersRoutes() {
    route("/customers") {
        get {
            if (customersList.isNotEmpty()) {
                call.respond(customersList)
            } else {
                call.respondText("No customers found", status = HttpStatusCode.NotFound)
            }
        }
        get("/{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            val customer =
                customersList.find { it.id.toString() == id } ?: return@get call.respondText(
                    "No customer with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(customer)
        }
        post {
            val customer = call.receive<Customer>()
            customersList.add(customer)
            call.respondText("customer added correctly", status = HttpStatusCode.Created)
            call.respondText("create customer")
        }
        delete("/{id?}") {
            call.respondText("delete customer")
            val id = call.parameters["id"] ?: return@delete call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            if (customersList.removeIf { it.id.toString() == id }) {
                call.respondText("customer removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("customer not found", status = HttpStatusCode.NotFound)
            }
        }
    }

}