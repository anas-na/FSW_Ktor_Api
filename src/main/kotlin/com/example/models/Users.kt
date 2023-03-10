package com.example.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.*
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import java.util.*

//object UUIDSerializer : KSerializer<UUID> {
//    override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)
//
//    override fun deserialize(decoder: Decoder): UUID {
//        return UUID.fromString(decoder.decodeString())
//    }
//
//    override fun serialize(encoder: Encoder, value: UUID) {
//        encoder.encodeString(value.toString())
//    }
//}
//(with = UUIDSerializer::class)
@Serializable
data class User(
    @BsonId
    val id: Id<User>? = null,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val password: String,
    val isRestaurantAdmin: Boolean = false,
)

