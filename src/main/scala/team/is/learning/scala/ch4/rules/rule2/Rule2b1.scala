package team.is.learning.scala.ch4.rules.rule2

import team.is.learning.scala.ch4.rules.rule2.soucre_target.{Developer, Employee}

object Rule2b1 extends App {


  //Scope rule: An inserted implicit conversion must be associated with the source or target type of the conversion.
  def persistEmployee(e: Employee) : Unit = {
    println(s"${e.id}")
  }

  val dev = Developer(1234)

  //From target : Employee
  persistEmployee(dev)
  def persistEmployeeId(id: Int) : Unit = {
    println(s"$id")
  }
  //From source : Developer
  persistEmployeeId(dev)
}
