package uk.co.tmmct.basekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LeavingTimeActivity : AppCompatActivity() {

    companion object {
        const val startHourMsg = "START_HOUR"
        const val startQuarterHourMsg = "START_QUARTER_HOUR"
        const val lunchLengthMsg = "LUNCH_LENGTH"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaving_time)

        val startHour = intent.getIntExtra(startHourMsg, -1)
        if (startHour == -1) {
            throw IllegalStateException()
        }
        val startQuarterHour = intent.getIntExtra(startQuarterHourMsg, -1)
        if (startQuarterHour == -1) {
            throw IllegalStateException()
        }
        val lunchLength = intent.getIntExtra(lunchLengthMsg, -1)
        if (lunchLength == -1) {
            throw IllegalStateException()
        }

        val leavingTimeView = findViewById<TextView>(R.id.leavingTime)
        leavingTimeView.text = calculateLeavingTime(startHour, startQuarterHour, lunchLength)

        val startAgainView = findViewById<Button>(R.id.startAgain)
        startAgainView.setOnClickListener {
            val intent = Intent(this, StartHourChoiceActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }
            startActivity(intent)
        }
    }

    private fun calculateLeavingTime(startHour: Int, startQuarterHour: Int, lunchLength: Int): String {
        val totalQuarterHoursToWork = calcQuarterHoursToWork(startHour, startQuarterHour, lunchLength)
        val hoursToWork = totalQuarterHoursToWork / 4
        val quarterHoursToWork = totalQuarterHoursToWork % 4;
        val quarterHourNames = arrayOf("00", "15", "30", "45")
        return "$hoursToWork:${quarterHourNames[quarterHoursToWork]}"
    }

    private fun calcQuarterHoursToWork(startHour: Int, startQuarterHour: Int, lunchLength: Int): Int {
        val hoursToWork = 8
        return 4 * startHour + startQuarterHour + lunchLength + 4 * hoursToWork;
    }
}
