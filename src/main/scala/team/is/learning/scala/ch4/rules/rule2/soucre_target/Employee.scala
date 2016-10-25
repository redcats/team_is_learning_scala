package team.is.learning.scala.ch4.rules.rule2.soucre_target

case class Employee(id: Int)

object Employee {
  implicit def toEmployee(dev : Developer) = {
    println("from Employee")
    Employee(dev.id)
  }
}
