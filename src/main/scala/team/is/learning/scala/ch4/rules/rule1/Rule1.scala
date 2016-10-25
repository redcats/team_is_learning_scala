package team.is.learning.scala.ch4.rules.rule1

import team.is.learning.scala.ch4.external

object Rule1 extends App {

  //Only definitions marked implicit are available
  //Seul ce qui est declaré `implicit` est utilisé par le compilateur

  val x = external.Calculation.count()

  def persistCount(x: Int): Unit = {
    println(s"$x")
  }

  //Solution  : Implicit conversion explicit
  implicit def balbal(r: String): Int = Integer.valueOf(r)


  def call(): Unit = {
    persistCount(x)
  }

}
