package uk.co.tmmct.basekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartQuarterHourActivity : AppCompatActivity() {
    companion object {
        const val startHourMsg = "START_HOUR"
    }

    private var startHour: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_quarter_hour)

        startHour = intent.getIntExtra(startHourMsg, 0)
        if (startHour == 0) {
            throw IllegalStateException()
        }

        val quarter0 = findViewById<Button>(R.id.quarter00)
        startLunchLengthActivity(quarter0, 0)
        val quarter1 = findViewById<Button>(R.id.quarter15)
        startLunchLengthActivity(quarter1, 1)
        val quarter2 = findViewById<Button>(R.id.quarter30)
        startLunchLengthActivity(quarter2, 2)
        val quarter3 = findViewById<Button>(R.id.quarter45)
        startLunchLengthActivity(quarter3, 3)
    }

    private fun startLunchLengthActivity(button: Button, quarterHour: Int) {
        button.setOnClickListener {
            val intent = Intent(this, LunchLengthActivity::class.java).apply {
                putExtra(LunchLengthActivity.startHourMsg, startHour)
                putExtra(LunchLengthActivity.startQuarterHourMsg, quarterHour)
            }
            startActivity(intent)
        }
    }
}
