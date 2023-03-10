//package com.example.models
//
//import kotlinx.serialization.KSerializer
//import kotlinx.serialization.Serializable
//import kotlinx.serialization.descriptors.PrimitiveKind
//import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
//import kotlinx.serialization.encoding.Decoder
//import kotlinx.serialization.encoding.Encoder
//import kotlinx.serialization.json.Json
//import java.util.*
//
////val orderList = listOf(orderContent(
////    "2020-04-06-01", listOf(
////        OrderItem("Ham Sandwich", 2, 5.50),
////        OrderItem("Water", 1, 1.50),
////        OrderItem("Beer", 3, 2.30),
////        OrderItem("Cheesecake", 1, 3.75)
////    )),
////    Order("2020-04-03-01", listOf(
////        OrderItem("Cheeseburger", 1, 8.50),
////        OrderItem("Water", 2, 1.50),
////        OrderItem("Coke", 2, 1.76),
////        OrderItem("Ice Cream", 1, 2.35)
////    ))
////)
//
//@Serializable
//data class Orders(@Serializable(with = UUIDSerializer::class) val id: UUID = UUID.randomUUID(), val orderContent: List<Item> )
//
//@Serializable
//data class Item(val name: String, val quantity: Int, val price: Double)
//
//val ordersList = mutableListOf<Orders>()
