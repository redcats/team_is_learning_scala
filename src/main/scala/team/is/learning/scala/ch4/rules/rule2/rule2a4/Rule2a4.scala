package team.is.learning.scala.ch4.rules.rule2.rule2a4

import team.is.learning.scala.ch4.external

object Rule2a4 extends App {

  //Scope rule: An inserted implicit conversion must be in scope as a single identifier

  //package object

  val x = external.Calculation.count()

  def persistCount(x: Int): Unit = {
    println(s"$x")
  }

  persistCount(x)

}
