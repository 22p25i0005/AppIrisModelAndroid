package com.ninenox.irisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getStringExtra("RESULT")
        if (result != null) {
            result_textview.text = result

            when (result) {
                "Sentosa" -> { imageView.setImageResource(R.mipmap.iris_sentosa) }
                "Vassicolour" -> { imageView.setImageResource(R.mipmap.iris_versicolor) }
                "Virginica" -> { imageView.setImageResource(R.mipmap.iris_verginica) }
            }
        }

        close_textview.setOnClickListener {
            finish()
        }

    }
}