package com.greeting.test.steps

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.greeting.test.pages.GreetingPage
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GreetingActivitySteps: BaseSteps() {
    private val greetingPage = GreetingPage()

    @When("I select SAY HELLO")
    fun i_select_say_hello() {
        greetingPage.selectHello()
    }

    @When("I select SAY GOODBYE")
    fun i_select_say_goodbye() {
        greetingPage.selectGoodbye()
    }

    @Then("I see greeting {string}")
    fun i_see_greeting(expectedGreeting: String ) {
        greetingPage.getGreeting().check(matches(withText(expectedGreeting)))
    }
}