package team.is.learning.scala.ch4.rules.rule2

import team.is.learning.scala.ch4.rules.rule2.soucre_target.{Developer, Employee}

object Rule2b2 extends App {
  //import Preambule.toEmpl
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

  //There’s one exception to the “single identifier” rule.
  implicit def toEmployee(dev: Developer) : Employee = {
    println("from local")
    Employee(dev.id)
  }

  implicit def toId(dev: Developer) : Int = {
    println("from local")
    dev.id
  }

}
