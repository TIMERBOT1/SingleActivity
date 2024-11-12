package models

import androidx.lifecycle.ViewModel

data class Character(
    var id: Int,
    var name: String,
    var status: String
)

class CharactersModel: ViewModel(){
    public var charactersList = listOf(
        Character(1, "PickleRick", "Dead"),
        Character(2, "Rick Sanchez", "Alive"),
        Character(3, "Morty", "Alive")
    )

    fun characterInfo(characterID: Int): Character{
        return charactersList.filter{ it.id == characterID }.first()
    }
}
