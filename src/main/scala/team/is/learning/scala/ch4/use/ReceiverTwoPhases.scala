package team.is.learning.scala.ch4.use

object ReceiverTwoPhases {

  //“rich wrappers” pattern
  //Add baloo method to String

  class BalooString(service: String) {
    def baloo() = println("baloo" + service.toString + service.hashCode)
  }

  implicit def stringToBaloo(s: String) = new BalooString(s)


  //def display(x: String) : Unit = x.baloo()

  def doSomething(x: String) = {
   x.baloo()
  }


}
