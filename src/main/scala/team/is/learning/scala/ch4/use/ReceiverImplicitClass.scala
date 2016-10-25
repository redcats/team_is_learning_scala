package team.is.learning.scala.ch4.use

object ReceiverImplicitClass {

  //“rich wrappers” pattern
  //Add baloo method to String

  implicit class BalooString(s: String) {
    def baloo() = println("baloo")
  }

  def display(x: String) : Unit = x.baloo()

}
