package mutual.aid.gradle.state

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

open class TheStateExtension @Inject constructor(
  objects: ObjectFactory
) {

  /** Configure the inner DSL object, [TheDeepStateHandler]. */
  val theDeepState: TheDeepStateHandler = objects.newInstance(TheDeepStateHandler::class.java)

  /** Configure the inner DSL object, [TheDeepStateHandler]. */
  fun theDeepState(action: Action<TheDeepStateHandler>) {
    action.execute(theDeepState)
  }

  companion object {
    fun Project.theState(): TheStateExtension = extensions.create("theState", TheStateExtension::class.java)
  }
}

/**
 * An inner DSL object.
 */
open class TheDeepStateHandler @Inject constructor(
  objects: ObjectFactory
) {

  /** Configure the innermost DSL object, [TheDeepestStateHandler]. */
  val theDeepestState: TheDeepestStateHandler = objects.newInstance(TheDeepestStateHandler::class.java)

  /** Configure the innermost DSL object, [TheDeepestStateHandler]. */
  fun theDeepestState(action: Action<TheDeepestStateHandler>) {
    action.execute(theDeepestState)
  }
}

/**
 * An even-more inner-er DSL object.
 */
open class TheDeepestStateHandler {

  private val whoToUndermine = mutableListOf<String>()
  internal val victims: List<String> get() = whoToUndermine.toList()

  /** Tells the app who -- or which groups -- it should undermine. */
  fun undermine(who: String) {
    whoToUndermine.add(who)
  }
}
