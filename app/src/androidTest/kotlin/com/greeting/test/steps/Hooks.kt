package com.greeting.test.steps

import android.graphics.Bitmap
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.screenshot.captureToBitmap
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.greeting.GreetingActivity
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.Scenario
import java.io.ByteArrayOutputStream
import junit.framework.TestCase
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Hooks: BaseSteps() {

    @Before()
    fun beforeEachScenario(){
        activityScenario = ActivityScenario.launch(GreetingActivity::class.java)
        TestCase.assertNotNull(activityScenario)
    }

    @After()
    fun afterEachScenario(scenario: Scenario){
        if (scenario.isFailed) {
            attachScreenshotToReport(scenario, "Failure screen")
//            If the app has more than one screen, uncomment the lines below to navigate back to the previous screen and take a screenshot
//            pressBack()
//            attachScreenshotToReport(scenario, "Previous screen")
        }
        activityScenario.close()
    }

    private fun attachScreenshotToReport(scenario: Scenario, screenshotName: String) {
        val screenshot = onView(ViewMatchers.isRoot())
            .captureToBitmap()
        val byteArrayOutputStream = ByteArrayOutputStream()
        screenshot.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val data = byteArrayOutputStream.toByteArray()
        scenario.attach(data, "image/png", screenshotName)
    }
}