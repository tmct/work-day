package uk.co.tmmct.basekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartHourChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_hour_choice)

        val hour7Button = findViewById<Button>(R.id.hour7)
        startQuarterHourActivity(hour7Button, 7)
        val hour8Button = findViewById<Button>(R.id.hour8)
        startQuarterHourActivity(hour8Button, 8)
        val hour9Button = findViewById<Button>(R.id.hour9)
        startQuarterHourActivity(hour9Button, 9)
    }

    private fun startQuarterHourActivity(button: Button, hour: Int) {
        button.setOnClickListener {
            val intent = Intent(this, StartQuarterHourActivity::class.java).apply {
                putExtra(StartQuarterHourActivity.startHourMsg, hour)
            }
            startActivity(intent)
        }
    }
}
