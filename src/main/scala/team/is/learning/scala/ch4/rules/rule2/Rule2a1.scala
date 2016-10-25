package team.is.learning.scala.ch4.rules.rule2

import team.is.learning.scala.ch4.external

object Rule2a1 extends App {

  //Scope rule: An inserted implicit conversion must be in scope as a single identifier

  //Local Solution
  implicit def convert(r: String): Int = Integer.valueOf(r)

  val x = external.Calculation.count()

  def persistCount(x: Int): Unit = {
    println(s"$x")
  }

  persistCount(x)

}
