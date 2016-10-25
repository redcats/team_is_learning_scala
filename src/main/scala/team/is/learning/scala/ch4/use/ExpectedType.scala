package team.is.learning.scala.ch4.use

import team.is.learning.scala.ch4.external

object ExpectedType extends App {
  //Implicit conversion to an expected type
  //defines implicit conversions that convert “smaller”  types to “larger” ones

  val x = external.Calculation.count()

  def persistCount(x: Int): Unit = {
    println(s"$x")
  }

  //Solution  : Implicit conversion explicit
  implicit def convert(r: String): Int = 12

  persistCount(x)
}
