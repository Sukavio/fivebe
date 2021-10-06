package de.taichj.charakter.db

import de.taichj.charakter.db.data.Fertigkeiten
import de.taichj.charakter.db.data.Karte
import io.quarkus.mongodb.panache.PanacheMongoEntity

class CharakterEntity: PanacheMongoEntity() {

    var name: String = ""
    var image: String = ""
    var sternzeichen: String = ""
    var typ: String = ""
    var konflikt = 2
    var currentKonflikt = 2
    var geist = 2
    var currentGeist = 2
    var sozial = 2
    var currentSozial = 2
    var zwiespalt = 0
    var currentZwiespalt = 0
    var schicksal = 2
    var currentSchicksal = 2

    var fertigkeiten = listOf<Fertigkeiten>()
    var karten = listOf<Karte>()
    var tags = mapOf<String, Any>()
}
