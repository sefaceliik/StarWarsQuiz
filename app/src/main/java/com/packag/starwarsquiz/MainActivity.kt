package com.packag.starwarsquiz

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    var characterPictureLinks: ArrayList<String> = arrayListOf("https://vignette.wikia.nocookie.net/starwars/images/2/20/LukeTLJ.jpg","https://vignette.wikia.nocookie.net/starwars/images/3/3f/C-3PO_TLJ_Card_Trader_Award_Card.png","https://vignette.wikia.nocookie.net/starwars/images/e/eb/ArtooTFA2-Fathead.png","https://vignette.wikia.nocookie.net/fr.starwars/images/3/32/Dark_Vador.jpg","https://vignette.wikia.nocookie.net/starwars/images/f/fc/Leia_Organa_TLJ.png","https://vignette.wikia.nocookie.net/starwars/images/e/eb/OwenCardTrader.png","https://vignette.wikia.nocookie.net/starwars/images/c/cc/BeruCardTrader.png","https://vignette.wikia.nocookie.net/starwars/images/c/cb/R5-D4_Sideshow.png", "https://vignette.wikia.nocookie.net/starwars/images/0/00/BiggsHS-ANH.png","https://vignette.wikia.nocookie.net/starwars/images/4/4e/ObiWanHS-SWE.jpg",
        "https://vignette.wikia.nocookie.net/starwars/images/6/6f/Anakin_Skywalker_RotS.png","https://vignette.wikia.nocookie.net/starwars/images/c/c1/Tarkininfobox.jpg","https://vignette.wikia.nocookie.net/starwars/images/4/48/Chewbacca_TLJ.png","https://vignette.wikia.nocookie.net/starwars/images/e/e2/TFAHanSolo.png","https://vignette.wikia.nocookie.net/starwars/images/c/c6/Greedo.jpg","https://vignette.wikia.nocookie.net/starwars/images/7/7f/Jabba_SWSB.png","https://vignette.wikia.nocookie.net/starwars/images/6/60/WedgeHelmetless-ROTJHD.jpg","https://vignette.wikia.nocookie.net/starwars/images/e/eb/JekPorkins-DB.png","https://vignette.wikia.nocookie.net/starwars/images/d/d6/Yoda_SWSB.png","https://vignette.wikia.nocookie.net/starwars/images/d/d8/Emperor_Sidious.png",
        "https://vignette.wikia.nocookie.net/starwars/images/7/79/Boba_Fett_HS_Fathead.png","https://vignette.wikia.nocookie.net/starwars/images/f/f2/IG-88.png","https://vignette.wikia.nocookie.net/starwars/images/1/1d/Bossk.png","https://vignette.wikia.nocookie.net/starwars/images/8/8f/Lando_ROTJ.png","https://vignette.wikia.nocookie.net/starwars/images/9/96/SWE_Lobot.jpg","https://vignette.wikia.nocookie.net/starwars/images/2/29/Admiral_Ackbar_RH.png","https://vignette.wikia.nocookie.net/starwars/images/b/b7/MP-MonMothma.png","https://vignette.wikia.nocookie.net/starwars/images/d/de/Arvel-crynyd.jpg","https://vignette.wikia.nocookie.net/starwars/images/4/4f/Wicket_RotJ.png","https://vignette.wikia.nocookie.net/starwars/images/1/14/Old_nien_nunb_-_profile.png",
        "https://vignette.wikia.nocookie.net/starwars/images/f/f6/Qui-Gon_Jinn_Headshot_TPM.jpg","https://vignette.wikia.nocookie.net/starwars/images/f/fd/Nute_Gunray_SWE.png","https://vignette.wikia.nocookie.net/starwars/images/5/51/ValorumPortrait-SWE.png","https://vignette.wikia.nocookie.net/starwars/images/d/d2/Jar_Jar_aotc.jpg","https://vignette.wikia.nocookie.net/starwars/images/c/ca/TarpalsHS.jpg","https://vignette.wikia.nocookie.net/starwars/images/d/d8/Bossnass.jpg","https://vignette.wikia.nocookie.net/starwars/images/4/4c/RicOlieHS-SWE.png","https://vignette.wikia.nocookie.net/starwars/images/e/eb/WattoHS.jpg","https://vignette.wikia.nocookie.net/starwars/images/1/14/Sebulba_Headshot_Closeup.png","https://vignette.wikia.nocookie.net/starwars/images/7/72/PanakaHS-TPM.png",
        "https://vignette.wikia.nocookie.net/starwars/images/a/ad/ShmiSkywalkerDatabank_%28Repurposed%29.jpeg","https://vignette.wikia.nocookie.net/starwars/images/5/50/Darth_Maul_profile.png","https://vignette.wikia.nocookie.net/starwars/images/3/33/BibFortunaHS-ROTJ.png","https://vignette.wikia.nocookie.net/starwars/images/f/f9/Aayla.jpg","https://vignette.wikia.nocookie.net/starwars/images/7/73/Dud_Bolt_Podracer_Cockpit.png","https://vignette.wikia.nocookie.net/starwars/images/5/57/GasganoHS-SWE.jpg","https://vignette.wikia.nocookie.net/starwars/images/7/7f/Cropped_Quadinaros.png","https://vignette.wikia.nocookie.net/starwars/images/5/58/Mace_ROTS.png","https://vignette.wikia.nocookie.net/starwars/images/9/9e/KiAdiMundi.jpg","https://vignette.wikia.nocookie.net/starwars/images/4/4c/Kit_Fisto_Card_Trader.png",
        "https://vignette.wikia.nocookie.net/starwars/images/4/4e/EethKothCardTrader.png","https://vignette.wikia.nocookie.net/starwars/images/b/ba/AdiGallia.jpg","https://vignette.wikia.nocookie.net/starwars/images/6/68/Saesee_Tiin_Card_Trader.jpg","https://vignette.wikia.nocookie.net/starwars/images/6/66/Yarael_Poof_Canon.jpeg","https://vignette.wikia.nocookie.net/starwars/images/b/bf/PloKoonCardTrader.png","https://vignette.wikia.nocookie.net/starwars/images/3/37/Mas_Amedda_SWCT.png","https://vignette.wikia.nocookie.net/starwars/images/5/52/Gregar_Typho.jpg","https://vignette.wikia.nocookie.net/starwars/images/b/b6/Cord%C3%A9_-_SW_Card_Trader.png","https://vignette.wikia.nocookie.net/starwars/images/3/36/ClieggLarsHS-SWE.jpg","https://vignette.wikia.nocookie.net/starwars/images/9/93/Poggle_the_lesser_-_sw_card_trader.png",
        "https://vignette.wikia.nocookie.net/starwars/images/2/21/LuminaraHS-SWE_%28new%29.png","https://vignette.wikia.nocookie.net/starwars/images/3/37/Barrisprofile2.jpg","https://vignette.wikia.nocookie.net/starwars/images/1/18/Dormesenate.jpg","https://vignette.wikia.nocookie.net/starwars/images/b/b8/Dooku_Headshot.jpg","https://vignette.wikia.nocookie.net/starwars/images/5/50/Bail_Organa_Mug.jpg","https://vignette.wikia.nocookie.net/starwars/images/5/56/JangoInfobox.png","https://vignette.wikia.nocookie.net/starwars/images/7/7d/Clawdite.jpg","https://vignette.wikia.nocookie.net/starwars/images/6/6c/DexterHS-SWE.jpg","https://vignette.wikia.nocookie.net/starwars/images/7/73/Lama_Su.jpg","https://vignette.wikia.nocookie.net/starwars/images/9/9c/TaunWe.jpg",
        "https://vignette.wikia.nocookie.net/starwars/images/1/15/Jocasta_Nu_SWE.png","https://vignette.wikia.nocookie.net/starwars/images/6/68/RattsHS.jpg","https://vignette.wikia.nocookie.net/starwars/images/6/6b/R4-P17.jpg","https://vignette.wikia.nocookie.net/starwars/images/a/a5/Wat_Tambor.png","https://vignette.wikia.nocookie.net/starwars/images/6/6f/SanHill_hs.jpg","https://vignette.wikia.nocookie.net/starwars/images/2/20/Shaak_Ti_closeup-SWE.png","https://vignette.wikia.nocookie.net/starwars/images/d/de/Grievoushead.jpg","https://vignette.wikia.nocookie.net/starwars/images/3/37/Tarfful_RotS.png","https://vignette.wikia.nocookie.net/starwars/images/8/80/Raymus_card_trader.png","https://vignette.wikia.nocookie.net/starwars/images/e/ec/SlyMooreIsWatchingYouPoop-OfficialPix.jpg",
        "https://vignette.wikia.nocookie.net/starwars/images/4/43/Tion_Medon.jpg","https://vignette.wikia.nocookie.net/starwars/images/a/af/Finn_TLJ_Collector%27s_Edition.png","https://vignette.wikia.nocookie.net/starwars/images/f/f8/ReyTLJEntertainmentWeeklyNovember.png","https://vignette.wikia.nocookie.net/starwars/images/7/79/Poe_Dameron_TLJ.png","https://vignette.wikia.nocookie.net/starwars/images/6/68/BB8-Fathead.png","https://vignette.wikia.nocookie.net/starwars/images/0/02/Phasma.png","https://vignette.wikia.nocookie.net/starwars/images/b/b2/Padmegreenscrshot.jpg")

    var correctCharacter: Characters? = null
    var correctCharacterPictureNumber: Int? = null
    var numberOfTimesUserAnsweredCorrectly: Int = 0
    var numberOfTimesUserAnsweredIncorrectly: Int = 0
    var correctCharacterIndex = 0

    var datasFromApi: List<Characters>? = arrayListOf<Characters>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        displayUIWidgets(false)
        setProgressBar(false)

        btnStart.setOnClickListener(View.OnClickListener {


            if (checkForInternetConnection()) {
                try {
                    val innerClassObject = DownloadingCharacterTask()
                    innerClassObject.execute()

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            setProgressBar(true)
            btnStart.setVisibility(View.GONE)
        })



        btnNextCharacter.setOnClickListener(View.OnClickListener {


            button1.setClickable(true)
            button2.setClickable(true)
            button3.setClickable(true)
            button4.setClickable(true)

            uiThread().execute()

            setColorsToDefault()
            txtState.setText("")

            if(checkForInternetConnection()) {

                button1.setClickable(true)
                button2.setClickable(true)
                button3.setClickable(true)
                button4.setClickable(true)

                setProgressBar(true)
                displayUIWidgets(false)


                setColorsToDefault()
                txtState.setText("")
            }
        })
    }


    inner class DownloadingCharacterTask : AsyncTask<String, Int, List<Characters>>() {

        override fun doInBackground(vararg params: String?): List<Characters>? {

            setProgressBar(true)
            var parseCharacter = ParseCharacterUtility()
            datasFromApi = parseCharacter.parseCharacterObjectFromJSONData()

            return parseCharacter.parseCharacterObjectFromJSONData()
        }

        override fun onPostExecute(result: List<Characters>?) {
            super.onPostExecute(result)

            uiThread().execute()

        }
    }
    inner class uiThread: AsyncTask<String, Int, List<Characters>?>() {
        override fun doInBackground(vararg p0: String?): List<Characters>? {

            return datasFromApi
        }

        override fun onPostExecute(result: List<Characters>?) {
            super.onPostExecute(result)


           // setProgressBar(true)
            //displayUIWidgets(false)
            var numberOfCharacters = result?.size ?: 0
            var index: Int = 0


            if (numberOfCharacters > 0) {
                var randomCharacterIndexForButton1: Int = (Math.random() * result!!.size).toInt()
                var randomCharacterIndexForButton2: Int = (Math.random() * result!!.size).toInt()
                var randomCharacterIndexForButton3: Int = (Math.random() * result!!.size).toInt()
                var randomCharacterIndexForButton4: Int = (Math.random() * result!!.size).toInt()

                var allRandomCharacters = ArrayList<Characters>()
                allRandomCharacters.add(result.get(randomCharacterIndexForButton1))
                allRandomCharacters.add(result.get(randomCharacterIndexForButton2))
                allRandomCharacters.add(result.get(randomCharacterIndexForButton3))
                allRandomCharacters.add(result.get(randomCharacterIndexForButton4))

                var ids: ArrayList<Int> = arrayListOf(
                    randomCharacterIndexForButton1,
                    randomCharacterIndexForButton2,
                    randomCharacterIndexForButton3,
                    randomCharacterIndexForButton4
                )
                correctCharacterIndex = (Math.random() * ids.size).toInt()
                correctCharacterPictureNumber = ids[correctCharacterIndex]



                button1.text = result.get(randomCharacterIndexForButton1).toString()
                button2.text = result.get(randomCharacterIndexForButton2).toString()
                button3.text = result.get(randomCharacterIndexForButton3).toString()
                button4.text = result.get(randomCharacterIndexForButton4).toString()

                correctCharacter = allRandomCharacters.get(correctCharacterIndex)


                val downloadingImageTask = DownloadingImageTask()
                downloadingImageTask.execute(characterPictureLinks[correctCharacterPictureNumber!!])
            }
        }
    }
    inner class DownloadingImageTask: AsyncTask<String, Int, Bitmap?>(){
        override fun doInBackground(vararg pictureName: String?): Bitmap? {

            try {
                val downloadingObject = DownloadingObject()
                val plantBitmap: Bitmap? = downloadingObject.downloadCharacterPicture(correctCharacterPictureNumber)

                return plantBitmap
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)

            imgTaken.setImageBitmap(result)

            setProgressBar(false)
            displayUIWidgets(true)
        }
    }


    fun button1IsClick(buttonView: View){
        specifyTheRightAndWrongAnswer(0)
    }
    fun button2IsClick(buttonView: View){
        specifyTheRightAndWrongAnswer(1)
    }
    fun button3IsClick(buttonView: View){
        specifyTheRightAndWrongAnswer(2)
    }
    fun button4IsClick(buttonView: View){
        specifyTheRightAndWrongAnswer(3)
    }

    private fun checkForInternetConnection(): Boolean {

        val connectivityManager: ConnectivityManager = this.getSystemService(android.content.Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        val isDeviceConnectedToInternet = networkInfo != null && networkInfo.isConnectedOrConnecting

        if (isDeviceConnectedToInternet){

            return true
        } else {

            createAlert()
            return false
        }
    }
    private fun createAlert(){

        val alertDialog: AlertDialog = AlertDialog.Builder(this@MainActivity).create()
        alertDialog.setTitle("Network Error")
        alertDialog.setMessage("Please Check for Internet Connection")
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", {
                dialog: DialogInterface?, which: Int ->
            startActivity(Intent(Settings.ACTION_SETTINGS))
        })

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", {
                dialog: DialogInterface?, which: Int ->

            Toast.makeText(this@MainActivity, "You must be connected to the internet", Toast.LENGTH_SHORT).show()
            finish()
        })

        alertDialog.show()
    }
    private fun setProgressBar(show: Boolean){
        if (show) {
            linearLayoutProgress.setVisibility(View.VISIBLE)
            progressBar.setVisibility(View.VISIBLE)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        } else if (!show) {
            linearLayoutProgress.setVisibility(View.GONE)
            progressBar.setVisibility(View.GONE)
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }
    private fun displayUIWidgets(display: Boolean){

        if (display) {
            imgTaken.setVisibility(View.VISIBLE)
            button1.setVisibility(View.VISIBLE)
            button2.setVisibility(View.VISIBLE)
            button3.setVisibility(View.VISIBLE)
            button4.setVisibility(View.VISIBLE)
            btnNextCharacter.setVisibility(View.VISIBLE)
            txtState.setVisibility(View.VISIBLE)
            txtRightAnswers.setVisibility(View.VISIBLE)
            txtWrongAnswers.setVisibility(View.VISIBLE)
        }else if (!display){
            imgTaken.setVisibility(View.INVISIBLE)
            button1.setVisibility(View.INVISIBLE)
            button2.setVisibility(View.INVISIBLE)
            button3.setVisibility(View.INVISIBLE)
            button4.setVisibility(View.INVISIBLE)
            btnNextCharacter.setVisibility(View.INVISIBLE)
            txtState.setVisibility(View.INVISIBLE)
            txtRightAnswers.setVisibility(View.INVISIBLE)
            txtWrongAnswers.setVisibility(View.INVISIBLE)
        }
     }
    private fun specifyTheRightAndWrongAnswer(userGuess: Int){
        button1.setClickable(false)
        button2.setClickable(false)
        button3.setClickable(false)
        button4.setClickable(false)

        when (correctCharacterIndex){
            0 -> button1.setBackgroundColor(Color.parseColor("#EEDB00"))
            1 -> button2.setBackgroundColor(Color.parseColor("#EEDB00"))
            2 -> button3.setBackgroundColor(Color.parseColor("#EEDB00"))
            3 -> button4.setBackgroundColor(Color.parseColor("#EEDB00"))

        }
        when (correctCharacterIndex) {
            0 -> button1.setTextColor(Color.parseColor("#000000"))
            1 -> button2.setTextColor(Color.parseColor("#000000"))
            2 -> button3.setTextColor(Color.parseColor("#000000"))
            3 -> button4.setTextColor(Color.parseColor("#000000"))
        }

        if (userGuess == correctCharacterIndex) {
            txtState.setText("Right!")
            numberOfTimesUserAnsweredCorrectly++
            txtRightAnswers.setText("$numberOfTimesUserAnsweredCorrectly")
        }else{
            var correctCharacterName = correctCharacter.toString()
            txtState.setText("Wrong! Choose : $correctCharacterName")
            numberOfTimesUserAnsweredIncorrectly++
            txtWrongAnswers.setText("$numberOfTimesUserAnsweredIncorrectly")

        }
        //falseCounter()
    }
    private fun setColorsToDefault(){

        button1.setBackgroundColor(Color.BLACK)
        button2.setBackgroundColor(Color.BLACK)
        button3.setBackgroundColor(Color.BLACK)
        button4.setBackgroundColor(Color.BLACK)

        button1.setTextColor(Color.WHITE)
        button2.setTextColor(Color.WHITE)
        button3.setTextColor(Color.WHITE)
        button4.setTextColor(Color.WHITE)
    }

    /*private fun falseCounter(){
        if( numberOfTimesUserAnsweredIncorrectly == 3){
            endgame()
        }
    }

    private fun endgame(){
        if(numberOfTimesUserAnsweredIncorrectly > numberOfTimesUserAnsweredCorrectly) {

            var drawable: Drawable = DrawableFactory.decodeResource(getResources(),R.drawable.babyyodapng1)
            imgTaken.setImageBitmap(drawable)

        }
    }*/
}







