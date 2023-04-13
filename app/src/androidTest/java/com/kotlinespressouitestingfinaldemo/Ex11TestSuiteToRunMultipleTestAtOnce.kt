package com.kotlinespressouitestingfinaldemo
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    Ex9DialogToastInstumentedTest::class,
    Ex10BackbuttonPressedInstrumentedTest::class
)
class Ex11TestSuiteToRunMultipleTestAtOnce {

}