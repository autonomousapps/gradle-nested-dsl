package mutual.aid

fun main(vararg args: String) {
  val victim = args.firstOrNull() ?: "everyone"
  println("Now undermining: $victim")
}
