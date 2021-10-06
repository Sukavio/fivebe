package de.taichj.npcdeck

import de.taichj.npcdeck.data.NPCLibary
import de.taichj.npcdeck.db.NPCEntity
import de.taichj.npcdeck.db.NPCRepository
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/npc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class NPCResource {

    @Inject
    lateinit var npcRepository: NPCRepository

    @GET
    fun getNPC(): NPCEntity {

        if (npcRepository.count() <= 60L) {
            repeat(IntRange(0, 60-npcRepository.count().toInt()).count()) { npcRepository.persist(NPCLibary.createNPCEntity()) }
        }
        return npcRepository.random()
    }

    @POST
    fun setNPC(ety: NPCEntity): NPCEntity {

        npcRepository.update(ety)
        return ety
    }
}
