package team.is.learning.scala.ch4.rules.rule2.soucre_target

case class Developer(id: Int)

object Developer {
  implicit def toId(dev : Developer) : Int = {
    println("from Developer")
    dev.id
  }



}
