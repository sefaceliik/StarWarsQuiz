package com.packag.starwarsquiz


class Characters(var name: String, var height: String, var mass: String, var birthYear: String, var gender: String) {

    constructor() : this("", "", "", "", "")

    private var _characterName: String? = null

    var characterName: String?
        get() = _characterName
        set(value) {
            _characterName = value
        }
    private fun gender(): String{
        return "$gender"
    }

    override fun toString(): String {
        return "$name"
    }

}









