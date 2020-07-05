package com.packag.starwarsquiz

import org.json.JSONArray
import org.json.JSONObject

class ParseCharacterUtility {

    fun parseCharacterObjectFromJSONData(): List<Characters>? {

        var i = 1
        var allCharactersObject: ArrayList<Characters> = ArrayList()

        while (i<10) {
            var downloadingObject = DownloadingObject()
            var link: String = "https://swapi.co/api/people/?page=" + i
            var topLevelPlantJSONData = downloadingObject.downloadJSONDataFromLink(link)


            var topLevelJSONObject: JSONObject = JSONObject(topLevelPlantJSONData)
            var characterObjectArray: JSONArray = topLevelJSONObject.getJSONArray("results")

            var index: Int = 0

            while (index < characterObjectArray.length()) {

                var characterObject: Characters = Characters()
                var jsonObject = characterObjectArray.getJSONObject(index)

                //var name: String, var height: String, var mass: Int, var birth_year: String, var gender: String)

                with(jsonObject) {
                    characterObject.name = getString("name")
                    characterObject.height = getString("height")
                    characterObject.mass = getString("mass")
                    characterObject.birthYear = getString("birth_year")
                    characterObject.gender = getString("gender")
                }

                allCharactersObject.add(characterObject)


                index++

            }
            i++
        }
        return allCharactersObject
    }

}

