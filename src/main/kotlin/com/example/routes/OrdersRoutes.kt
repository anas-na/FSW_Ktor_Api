//package com.example.routes
//
//import com.example.models.Item
////import com.example.models.customersList
//import com.example.models.ordersList
//import com.example.models.Orders
//import io.ktor.http.*
//import io.ktor.server.application.*
//import io.ktor.server.request.*
//import io.ktor.server.response.*
//import io.ktor.server.routing.*
//
//fun Route.ordersRoutes() {
//    route("/orders") {
//        get {
////            if (ordersList.isNotEmpty()) {
////                call.respond(ordersList)
////            } else {
////                call.respondText("No orders found", status = HttpStatusCode.NotFound)
////            }
//        }
//        get("/{id?}") {
//            val id = call.parameters["id"] ?: return@get call.respondText(
//                "Missing or malformed id",
//                status = HttpStatusCode.BadRequest
//            )
//            val order = ordersList.find { it.id.toString() == id } ?: return@get call.respondText(
//                "No order with id $id",
//                status = HttpStatusCode.NotFound
//            )
//            call.respond(order)
//        }
//        get("/{id?}/total") {
//            println("order total")
//            val id = call.parameters["id"] ?: return@get call.respondText(
//                "Missing or malformed id",
//                status = HttpStatusCode.BadRequest
//            )
//            val order = ordersList.find { it.id.toString() == id } ?: return@get call.respondText(
//                "No order with id $id",
//                status = HttpStatusCode.NotFound
//            )
//            val total = order.orderContent.sumOf() { it.price * it.quantity }
//            call.respondText("Total: $total")
//        }
//        post {
//           val Orders = call.receive<Orders>()
//            println("ordersList")
//            println(Orders)
//            ordersList.add(Orders)
//            call.respondText("order added correctly", status = HttpStatusCode.Created)
//
//        }
//        delete("/{id?}") {
//            val id = call.parameters["id"] ?: return@delete call.respondText(
//                "Missing or malformed id",
//                status = HttpStatusCode.BadRequest
//            )
//            if (customersList.removeIf { it.id.toString() == id }) {
//                call.respondText("order removed correctly", status = HttpStatusCode.Accepted)
//            } else {
//                call.respondText("order not found", status = HttpStatusCode.NotFound)
//            }
//            call.respondText("delete order")
//        }
//    }
//}