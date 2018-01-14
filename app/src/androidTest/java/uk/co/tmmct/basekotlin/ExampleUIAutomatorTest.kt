package uk.co.tmmct.basekotlin

import android.content.Intent
import android.content.pm.PackageManager
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.Until
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleUIAutomatorTest {
    private val appPackage = "uk.co.tmmct.basekotlin"
    private val launchTimeout = 5000L
    private lateinit var mDevice: UiDevice

    @Before
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        mDevice.pressHome()

        // Wait for launcher
        val launcherPackage = getLauncherPackageName()

        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), launchTimeout)

        // Launch the blueprint app
        val context = InstrumentationRegistry.getContext()
        val intent = context.packageManager
                .getLaunchIntentForPackage(appPackage)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)    // Clear out any previous instances
        context.startActivity(intent)

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(appPackage).depth(0)), launchTimeout)
    }

    @Test
    fun test() {
        val helloWorldElement = mDevice.findObject(By.res(appPackage, "hello_world"))
        val helloWorldText = helloWorldElement.text

        Assert.assertEquals(helloWorldText, "Hello World!")
    }

    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.`
     */
    private fun getLauncherPackageName(): String {
        // Create launcher Intent
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)

        // Use PackageManager to get the launcher package name
        val pm = InstrumentationRegistry.getContext().packageManager
        val resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
        return resolveInfo.activityInfo.packageName
    }
}
