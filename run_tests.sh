#!/bin/bash

./gradlew clean connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class="com.greeting.test.TestRunner"

connected_folder="./app/build/outputs/connected_android_test_additional_output/debugAndroidTest/connected"
device_subfolder=$(find "$connected_folder" -mindepth 1 -maxdepth 1 -type d | head -n 1)
java -jar ./CucumberReportGenerator.jar "$device_subfolder/cucumber.json" ./ "Greeting app"
