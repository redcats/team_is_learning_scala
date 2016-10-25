package team.is.learning.scala.ch4.use

object ReceiverTwoPhases {

  //“rich wrappers” pattern
  //Add baloo method to String

  class BalooString(s: String) {
    def baloo() = println("baloo")
  }

  implicit def stringToBaloo(s: String) = new BalooString(s)

  def display(x: String) : Unit = x.baloo()

}
