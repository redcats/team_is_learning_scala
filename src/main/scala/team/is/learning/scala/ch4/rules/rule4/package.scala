package team.is.learning.scala.ch4.rules

package object rule4 {

  class Person(val id: Int)

  class Employee(id: Int) extends Person(id)

}
