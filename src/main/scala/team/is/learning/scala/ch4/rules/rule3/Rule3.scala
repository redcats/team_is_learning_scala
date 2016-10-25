package team.is.learning.scala.ch4.rules.rule3

object Rule3 extends App {

  //One-at-a-time rule: Only one implicit is inserted.
  def persist(person: Person) = println(s"$person")

  implicit def toEmp(x: Developer) = Employee(x.id)
  implicit def toPers(x: Employee) = Person(x.id)

   val d = Developer(123)

  //persist(d)


  val e : Employee = d

  persist(e)

}
