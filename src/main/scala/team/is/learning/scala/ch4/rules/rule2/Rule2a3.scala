package team.is.learning.scala.ch4.rules.rule2

import team.is.learning.scala.ch4.external

object Rule2a3 extends Rule2aBase with App {

  //Scope rule: An inserted implicit conversion must be in scope as a single identifier

  //Inherited

  val x = external.Calculation.count()

  def persistCount(x: Int): Unit = {
    println(s"$x")
  }

  persistCount(x)

}
