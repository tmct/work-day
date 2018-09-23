package uk.co.tmmct.basekotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button4)
        button.setOnClickListener {
            val intent = Intent(this, StartHourChoiceActivity::class.java)
            startActivity(intent)
        }
    }
}
