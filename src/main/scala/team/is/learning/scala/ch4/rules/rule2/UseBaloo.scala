package team.is.learning.scala.ch4.rules.rule2

object UseBaloo extends App {
  // implicit def toInt(x: Boolean) : Int = 1
  implicit def toS(x: Boolean) : String= "1"

  val b = new Baloo
  val r : Boolean = true
  b.baloo(r)

}
