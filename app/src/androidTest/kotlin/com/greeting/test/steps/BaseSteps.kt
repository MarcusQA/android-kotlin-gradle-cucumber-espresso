package com.greeting.test.steps

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.greeting.GreetingActivity
import org.junit.Rule

abstract class BaseSteps {
    companion object {
        lateinit var activityScenario: ActivityScenario<GreetingActivity>
    }

    @JvmField
    @Rule
    val activityScenarioRule = ActivityScenarioRule(GreetingActivity::class.java)
}