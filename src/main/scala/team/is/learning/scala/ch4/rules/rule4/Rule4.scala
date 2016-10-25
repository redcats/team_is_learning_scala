package team.is.learning.scala.ch4.rules.rule4

object Rule4 extends App {

  //Explicits-first rule: Whenever code type checks as it is written, no implicits are attempted.
  implicit def toPerson(x: Employee) = {
    println("called")
    new Person(x.id)
  }
  def persist(x: Person) = println(s"${x.id}")

  val e = new Employee(1234)
  persist(e)

}