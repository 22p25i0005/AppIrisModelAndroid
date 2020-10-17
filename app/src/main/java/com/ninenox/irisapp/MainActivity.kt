package com.ninenox.irisapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send_button.setOnClickListener {

            val sl = slEditText.text
            val sw = swEditText.text
            val pl = plEditText.text
            val pw = pwEditText.text

            Fuel.post("https://frozen-garden-55839.herokuapp.com/iris",listOf("param" to "${sl},${sw},${pl},${pw}"))
                    .responseString { request, response, result ->
                        println(response.data.toString(Charsets.UTF_8))
                        val intent = Intent(this ,ResultActivity::class.java)
                        intent.putExtra("RESULT",response.data.toString(Charsets.UTF_8))
                        startActivity(intent)
                    }
        }
    }
}