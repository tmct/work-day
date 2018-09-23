package uk.co.tmmct.basekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LunchLengthActivity : AppCompatActivity() {
    companion object {
        const val startHourMsg = "START_HOUR"
        const val startQuarterHourMsg = "START_QUARTER_HOUR"
    }

    private var startHour: Int = -1
    private var startQuarterHour: Int = -1
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch_length)
        startHour = intent.getIntExtra(startHourMsg, -1)
        if (startHour == -1) {
            throw IllegalStateException()
        }
        startQuarterHour = intent.getIntExtra(startQuarterHourMsg, -1)
        if (startQuarterHour == -1) {
            throw IllegalStateException()
        }

        val lunch2 = findViewById<Button>(R.id.lunch2)
        startLeavingTimeActivity(lunch2, 2)
        val lunch3 = findViewById<Button>(R.id.lunch3)
        startLeavingTimeActivity(lunch3, 3)
        val lunch4 = findViewById<Button>(R.id.lunch4)
        startLeavingTimeActivity(lunch4, 4)
        val lunch5 = findViewById<Button>(R.id.lunch5)
        startLeavingTimeActivity(lunch5, 5)
        val lunch6 = findViewById<Button>(R.id.lunch6)
        startLeavingTimeActivity(lunch6, 6)
    }

    private fun startLeavingTimeActivity(button: Button, lunchLength: Int) {
        button.setOnClickListener {
            val intent = Intent(this, LeavingTimeActivity::class.java).apply {
                putExtra(LeavingTimeActivity.startHourMsg, startHour)
                putExtra(LeavingTimeActivity.startQuarterHourMsg, startQuarterHour)
                putExtra(LeavingTimeActivity.lunchLengthMsg, lunchLength)
            }
            startActivity(intent)
        }
    }
}
