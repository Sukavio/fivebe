package de.taichj.npcdeck.db

import io.quarkus.mongodb.panache.PanacheMongoEntity
import org.bson.types.ObjectId

class NPCEntity(): PanacheMongoEntity() {
    var id: ObjectId = ObjectId()
    var vorname: String = ""
    var nachname: String = ""
    var weiblich = false
    var url: String = ""
    var tags = HashMap<String, Any>()
}
