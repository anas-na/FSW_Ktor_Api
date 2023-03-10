//
//package com.example
//
//import io.ktor.client.request.*
//import io.ktor.client.statement.*
//import io.ktor.http.*
//import io.ktor.server.testing.*
//import kotlin.test.*
//class ApplicationTest {
//    @Test
//    fun testGetCustomers() = testApplication {
//        val response = client.get("/customers")
//        println(response)
//        assertEquals(
//        """[{ "firstName": "Jane","lastName": "Smith","email": "jane.smith@company.com"},{"firstName": "John","lastName": "Smith","email": "john.smith@company.com"}]""",
//                response.bodyAsText()
//        )
//        assertEquals(HttpStatusCode.OK, response.status)
//    }
//}