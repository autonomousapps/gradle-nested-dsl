// unused: we have a deliberate API, and many elements aren't "used" but the plugin code itself
@file:Suppress("unused")

package mutual.aid.gradle.people

import org.gradle.api.Action
import org.gradle.api.Named
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import javax.inject.Inject

open class ThePeopleExtension @Inject constructor(objects: ObjectFactory) {

  val problems = objects.domainObjectContainer(ProblemHandler::class.java)

  fun problems(action: Action<NamedDomainObjectContainer<ProblemHandler>>) {
    action.execute(problems)
  }

  companion object {
    internal fun Project.thePeople(): ThePeopleExtension =
      extensions.create("thePeople", ThePeopleExtension::class.java)
  }
}

open class ProblemHandler @Inject constructor(
  private val name: String,
  objects: ObjectFactory
) : Named {

  override fun getName(): String = name

  internal val description: Property<String> = objects.property(String::class.java)
  val solutions = objects.domainObjectContainer(SolutionHandler::class.java)

  fun solutions(action: Action<NamedDomainObjectContainer<SolutionHandler>>) {
    action.execute(solutions)
  }

  fun description(description: String) {
    this.description.set(description)
    this.description.disallowChanges()
  }
}

open class SolutionHandler @Inject constructor(
  private val name: String,
  objects: ObjectFactory
) : Named {

  override fun getName(): String = name

  internal val action: Property<String> = objects.property(String::class.java)
  internal val description: Property<String> = objects.property(String::class.java)
  internal val rank: Property<Int> = objects.property(Int::class.java)

  fun action(action: String) {
    this.action.set(action)
    this.action.disallowChanges()
  }

  fun description(description: String) {
    this.description.set(description)
    this.description.disallowChanges()
  }

  fun rank(rank: Int) {
    this.rank.set(rank)
    this.rank.disallowChanges()
  }
}
