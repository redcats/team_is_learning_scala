package team.is.learning.scala.ch4.rules.rule2

import team.is.learning.scala.ch4.external

object Rule2a2 extends App {

  //Scope rule: An inserted implicit conversion must be in scope as a single identifier

  //Imported
  import Preambule.convert

  val x = external.Calculation.count()

  def persistCount(x: Int): Unit = {
    println(s"$x")
  }

  //implicit def convert2(r: String): Int = Integer.valueOf(r)

  persistCount(x)

//  def call() : Unit = {
//    implicit def convert2(r: String): Int = Integer.valueOf(r)
//    persistCount(x)
//  }

}
