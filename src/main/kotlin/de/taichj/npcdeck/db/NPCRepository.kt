package de.taichj.npcdeck.db

import io.quarkus.mongodb.panache.PanacheMongoRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class NPCRepository: PanacheMongoRepository<NPCEntity> {
    fun random(): NPCEntity {
        return findAll().list<NPCEntity>().random()
    }
}
