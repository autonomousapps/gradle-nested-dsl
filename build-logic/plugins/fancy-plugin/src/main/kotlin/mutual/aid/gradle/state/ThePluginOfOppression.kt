package mutual.aid.gradle.state

import mutual.aid.gradle.state.TheStateExtension.Companion.theState
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.JavaExec

@Suppress("unused")
class ThePluginOfOppression : Plugin<Project> {

  override fun apply(project: Project): Unit = project.run {
    pluginManager.apply("org.jetbrains.kotlin.jvm")
    pluginManager.apply("application")

    val theState = theState()

    afterEvaluate {
      tasks.named("run", JavaExec::class.java) {
        it.args = theState.theDeepState.theDeepestState.victims
      }
    }
  }
}
