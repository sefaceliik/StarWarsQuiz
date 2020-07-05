package com.packag.starwarsquiz

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class DownloadingObject {

    @Throws(IOException::class)
    fun downloadJSONDataFromLink(link: String): String {
        val stringBuilder: StringBuilder = StringBuilder()

        val url: URL = URL(link)
        val urlConnection = url.openConnection() as HttpURLConnection
        try {

            val bufferedInputString: BufferedInputStream = BufferedInputStream(urlConnection.inputStream)
            val bufferedReader: BufferedReader = BufferedReader(InputStreamReader(bufferedInputString))

            var inputLineString: String?
            inputLineString = bufferedReader.readLine()

            while (inputLineString != null){
                stringBuilder.append(inputLineString)
                inputLineString = bufferedReader.readLine()
            }
        } finally {
            urlConnection.disconnect()
        }
        return stringBuilder.toString()
    }

    fun downloadCharacterPicture(chosen: Int?): Bitmap?{

        var bitmap: Bitmap? = null
        var characterPictureLinks: ArrayList<String> = arrayListOf("https://vignette.wikia.nocookie.net/starwars/images/2/20/LukeTLJ.jpg","https://vignette.wikia.nocookie.net/starwars/images/3/3f/C-3PO_TLJ_Card_Trader_Award_Card.png","https://vignette.wikia.nocookie.net/starwars/images/e/eb/ArtooTFA2-Fathead.png","https://vignette.wikia.nocookie.net/fr.starwars/images/3/32/Dark_Vador.jpg","https://vignette.wikia.nocookie.net/starwars/images/f/fc/Leia_Organa_TLJ.png","https://vignette.wikia.nocookie.net/starwars/images/e/eb/OwenCardTrader.png","https://vignette.wikia.nocookie.net/starwars/images/c/cc/BeruCardTrader.png","https://vignette.wikia.nocookie.net/starwars/images/c/cb/R5-D4_Sideshow.png", "https://vignette.wikia.nocookie.net/starwars/images/0/00/BiggsHS-ANH.png","https://vignette.wikia.nocookie.net/starwars/images/4/4e/ObiWanHS-SWE.jpg",
            "https://vignette.wikia.nocookie.net/starwars/images/6/6f/Anakin_Skywalker_RotS.png","https://vignette.wikia.nocookie.net/starwars/images/c/c1/Tarkininfobox.jpg","https://vignette.wikia.nocookie.net/starwars/images/4/48/Chewbacca_TLJ.png","https://vignette.wikia.nocookie.net/starwars/images/e/e2/TFAHanSolo.png","https://vignette.wikia.nocookie.net/starwars/images/c/c6/Greedo.jpg","https://vignette.wikia.nocookie.net/starwars/images/7/7f/Jabba_SWSB.png","https://vignette.wikia.nocookie.net/starwars/images/6/60/WedgeHelmetless-ROTJHD.jpg","https://vignette.wikia.nocookie.net/starwars/images/e/eb/JekPorkins-DB.png","https://vignette.wikia.nocookie.net/starwars/images/d/d6/Yoda_SWSB.png","https://vignette.wikia.nocookie.net/starwars/images/d/d8/Emperor_Sidious.png",
            "https://vignette.wikia.nocookie.net/starwars/images/7/79/Boba_Fett_HS_Fathead.png","https://vignette.wikia.nocookie.net/starwars/images/f/f2/IG-88.png","https://vignette.wikia.nocookie.net/starwars/images/1/1d/Bossk.png","https://vignette.wikia.nocookie.net/starwars/images/8/8f/Lando_ROTJ.png","https://vignette.wikia.nocookie.net/starwars/images/9/96/SWE_Lobot.jpg","https://vignette.wikia.nocookie.net/starwars/images/2/29/Admiral_Ackbar_RH.png","https://vignette.wikia.nocookie.net/starwars/images/b/b7/MP-MonMothma.png","https://vignette.wikia.nocookie.net/starwars/images/d/de/Arvel-crynyd.jpg","https://vignette.wikia.nocookie.net/starwars/images/4/4f/Wicket_RotJ.png","https://vignette.wikia.nocookie.net/starwars/images/1/14/Old_nien_nunb_-_profile.png",
            "https://vignette.wikia.nocookie.net/starwars/images/f/f6/Qui-Gon_Jinn_Headshot_TPM.jpg","https://vignette.wikia.nocookie.net/starwars/images/f/fd/Nute_Gunray_SWE.png","https://vignette.wikia.nocookie.net/starwars/images/5/51/ValorumPortrait-SWE.png","https://vignette.wikia.nocookie.net/starwars/images/d/d2/Jar_Jar_aotc.jpg","https://vignette.wikia.nocookie.net/starwars/images/c/ca/TarpalsHS.jpg","https://vignette.wikia.nocookie.net/starwars/images/d/d8/Bossnass.jpg","https://vignette.wikia.nocookie.net/starwars/images/4/4c/RicOlieHS-SWE.png","https://vignette.wikia.nocookie.net/starwars/images/e/eb/WattoHS.jpg","https://vignette.wikia.nocookie.net/starwars/images/1/14/Sebulba_Headshot_Closeup.png","https://vignette.wikia.nocookie.net/starwars/images/7/72/PanakaHS-TPM.png",
            "https://vignette.wikia.nocookie.net/starwars/images/a/ad/ShmiSkywalkerDatabank_%28Repurposed%29.jpeg","https://vignette.wikia.nocookie.net/starwars/images/5/50/Darth_Maul_profile.png","https://vignette.wikia.nocookie.net/starwars/images/3/33/BibFortunaHS-ROTJ.png","https://vignette.wikia.nocookie.net/starwars/images/f/f9/Aayla.jpg","https://vignette.wikia.nocookie.net/starwars/images/7/73/Dud_Bolt_Podracer_Cockpit.png","https://vignette.wikia.nocookie.net/starwars/images/5/57/GasganoHS-SWE.jpg","https://vignette.wikia.nocookie.net/starwars/images/7/7f/Cropped_Quadinaros.png","https://vignette.wikia.nocookie.net/starwars/images/5/58/Mace_ROTS.png","https://vignette.wikia.nocookie.net/starwars/images/9/9e/KiAdiMundi.jpg","https://vignette.wikia.nocookie.net/starwars/images/4/4c/Kit_Fisto_Card_Trader.png",
            "https://vignette.wikia.nocookie.net/starwars/images/4/4e/EethKothCardTrader.png","https://vignette.wikia.nocookie.net/starwars/images/b/ba/AdiGallia.jpg","https://vignette.wikia.nocookie.net/starwars/images/6/68/Saesee_Tiin_Card_Trader.jpg","https://vignette.wikia.nocookie.net/starwars/images/6/66/Yarael_Poof_Canon.jpeg","https://vignette.wikia.nocookie.net/starwars/images/b/bf/PloKoonCardTrader.png","https://vignette.wikia.nocookie.net/starwars/images/3/37/Mas_Amedda_SWCT.png","https://vignette.wikia.nocookie.net/starwars/images/5/52/Gregar_Typho.jpg","https://vignette.wikia.nocookie.net/starwars/images/b/b6/Cord%C3%A9_-_SW_Card_Trader.png","https://vignette.wikia.nocookie.net/starwars/images/3/36/ClieggLarsHS-SWE.jpg","https://vignette.wikia.nocookie.net/starwars/images/9/93/Poggle_the_lesser_-_sw_card_trader.png",
            "https://vignette.wikia.nocookie.net/starwars/images/2/21/LuminaraHS-SWE_%28new%29.png","https://vignette.wikia.nocookie.net/starwars/images/3/37/Barrisprofile2.jpg","https://vignette.wikia.nocookie.net/starwars/images/1/18/Dormesenate.jpg","https://vignette.wikia.nocookie.net/starwars/images/b/b8/Dooku_Headshot.jpg","https://vignette.wikia.nocookie.net/starwars/images/5/50/Bail_Organa_Mug.jpg","https://vignette.wikia.nocookie.net/starwars/images/5/56/JangoInfobox.png","https://vignette.wikia.nocookie.net/starwars/images/7/7d/Clawdite.jpg","https://vignette.wikia.nocookie.net/starwars/images/6/6c/DexterHS-SWE.jpg","https://vignette.wikia.nocookie.net/starwars/images/7/73/Lama_Su.jpg","https://vignette.wikia.nocookie.net/starwars/images/9/9c/TaunWe.jpg",
            "https://vignette.wikia.nocookie.net/starwars/images/1/15/Jocasta_Nu_SWE.png","https://vignette.wikia.nocookie.net/starwars/images/6/68/RattsHS.jpg","https://vignette.wikia.nocookie.net/starwars/images/6/6b/R4-P17.jpg","https://vignette.wikia.nocookie.net/starwars/images/a/a5/Wat_Tambor.png","https://vignette.wikia.nocookie.net/starwars/images/6/6f/SanHill_hs.jpg","https://vignette.wikia.nocookie.net/starwars/images/2/20/Shaak_Ti_closeup-SWE.png","https://vignette.wikia.nocookie.net/starwars/images/d/de/Grievoushead.jpg","https://vignette.wikia.nocookie.net/starwars/images/3/37/Tarfful_RotS.png","https://vignette.wikia.nocookie.net/starwars/images/8/80/Raymus_card_trader.png","https://vignette.wikia.nocookie.net/starwars/images/e/ec/SlyMooreIsWatchingYouPoop-OfficialPix.jpg",
            "https://vignette.wikia.nocookie.net/starwars/images/4/43/Tion_Medon.jpg","https://vignette.wikia.nocookie.net/starwars/images/a/af/Finn_TLJ_Collector%27s_Edition.png","https://vignette.wikia.nocookie.net/starwars/images/f/f8/ReyTLJEntertainmentWeeklyNovember.png","https://vignette.wikia.nocookie.net/starwars/images/7/79/Poe_Dameron_TLJ.png","https://vignette.wikia.nocookie.net/starwars/images/6/68/BB8-Fathead.png","https://vignette.wikia.nocookie.net/starwars/images/0/02/Phasma.png","https://vignette.wikia.nocookie.net/starwars/images/b/b2/Padmegreenscrshot.jpg")

        var pictureLink = characterPictureLinks[chosen!!]

        var pictureURL = URL(pictureLink)
        val inputStream = pictureURL.openConnection().getInputStream()
        if (inputStream != null) {
            bitmap = BitmapFactory.decodeStream(inputStream)
        }
        return bitmap

    }


}