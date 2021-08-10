package mutual.aid.gradle.people

import mutual.aid.gradle.people.ThePeopleExtension.Companion.thePeople
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.util.*

@Suppress("unused")
class ThePluginOfThePeople : Plugin<Project> {

  override fun apply(project: Project): Unit = project.run {
    val thePeople = thePeople()

    thePeople.problems.all { problem ->
      tasks.register("listSolutionsFor${problem.name.capitalize()}", ListSolutionsTask::class.java) {
        it.problem.set(problem)
      }
    }
  }
}

abstract class ListSolutionsTask : DefaultTask() {

  init {
    group = "People"
    description = "Prints list of solutions for a given problem"
  }

  @get:Input
  abstract val problem: Property<ProblemHandler>

  @TaskAction fun action() {
    val problem = problem.get()

    val msg = buildString {
      appendLine(problem.name.capitalize())
      appendLine(problem.description.get())
      appendLine()
      appendLine("Solutions:")
      problem.solutions.sortedBy { it.rank.get() }.forEachIndexed { i, sol ->
        appendLine("${i + 1}. ${sol.name}")
        appendLine("   ${sol.description.get()}")
        appendLine("   ${sol.action.get()}")
      }
    }

    logger.quiet(msg)
  }
}

// The stdlib's capitalize() function is deprecated.
private fun String.capitalize() = replaceFirstChar {
  if (it.isLowerCase()) it.titlecase(Locale.US)
  else it.toString()
}
