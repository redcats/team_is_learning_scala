package team.is.learning.scala.ch4.rules.rule2.soucre_target

case class Employee(id: Int)

object Employee {
  implicit def toEmploye(dev : Developer) = {
    println("from Employee 33")
    Employee(dev.id)
  }
}
