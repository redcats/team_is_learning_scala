package team.is.learning.scala.ch3.extractors

object FirstLastName extends App {

  println(FN("Jamal", "Dupont"))

  val recu = "Fred.Dupont"
  recu match {
    case FN(f, l) => println(f)
  }

  //



}


object FN {

  def apply(f: String, l: String) = s"$f.$l"

  def unapply(arg: String): Option[(String, String)] = {
    val parts  = arg.split('.')
    if(parts.length == 2) Some(parts(0), parts(1)) else None
  }
}