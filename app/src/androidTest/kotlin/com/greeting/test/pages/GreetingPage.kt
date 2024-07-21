package com.greeting.test.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.greeting.R

class GreetingPage {
    fun selectHello() {
        onView(withId(R.id.hello_button)).perform(click())
    }

    fun selectGoodbye() {
        onView(withId(R.id.goodbye_button)).perform(click())
    }

    fun getGreeting(): ViewInteraction {
        return onView(withId(R.id.greeting_textview))
    }
}