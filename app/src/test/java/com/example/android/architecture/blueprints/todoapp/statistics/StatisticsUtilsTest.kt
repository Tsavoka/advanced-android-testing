package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        // Create an active task
        val tasks: List<Task> = emptyList()
        // Call your function
        val result: StatsResult = getActiveAndCompletedStats(tasks)
        // Check the result
        //assertThat(result.activeTasksPercent + result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // Create an active task
        val tasks = null
        // Call your function
        val result: StatsResult = getActiveAndCompletedStats(tasks)
        // Check the result
        //assertThat(result.activeTasksPercent + result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsHundredZero() {
        // Create an active task
        val tasks = listOf( Task("title", "desk", isCompleted = true))
        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {

        val tasks = mutableListOf<Task>().also { tasklist ->
            repeat(3){
                tasklist.add(Task("title", "desk", isCompleted = false))}
            repeat(2){
                tasklist.add(Task("title", "desk", isCompleted = true))}
        }
        // Call your function
        val result = getActiveAndCompletedStats(tasks.toList())
        // Check the result
        assertThat(result.activeTasksPercent, `is`(60f))
        assertThat(result.completedTasksPercent, `is`(40f))
    }
}