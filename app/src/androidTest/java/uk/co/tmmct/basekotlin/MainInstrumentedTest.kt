package uk.co.tmmct.basekotlin

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainInstrumentedTest {
    @get:Rule
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun saysHelloWorld() {
        onView(withId(R.id.hello_world))
                .check(matches(withText("Hello World!")));
    }
}
