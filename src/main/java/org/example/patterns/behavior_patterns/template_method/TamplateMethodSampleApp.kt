package org.example.patterns.behavior_patterns.template_method

abstract class DayRoutine {
    private fun arriveToWork() {
        println("Hi boss! I appear in the office sometimes!")
    }

    private fun drinkCoffee() {
        println("Coffee is delicious today")
    }

    private fun goToLunch() {
        println("Hamburger and chips, please!")
    }
    private fun goHome() {
        println("Go home everybodies")
    }

    abstract fun doBeforeLaunch()

    abstract fun doAfterLunch()
    open fun bossHook() {
        println("Hey, can I have yo for a sec in my office?")
    }

    fun runSchedule(){
        arriveToWork()
        drinkCoffee()
        doBeforeLaunch()
        goToLunch()
        doAfterLunch()
        bossHook()
        goHome()
    }
}

class MondaySchedule: DayRoutine() {
    override fun doBeforeLaunch() {
        println("Some pointless meeting")
        println("Code review. What this does?")
    }

    override fun doAfterLunch() {
        println("Meeting with Ralf")
        println("Telling")
    }

}

fun main() {

    val monday = MondaySchedule()
    monday.runSchedule()


}