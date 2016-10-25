package team.is.learning.scala.ch4

package object use {

  case class Lang(s: String)
  case class Specific(s: String)

  trait Speaking[T] {
    def lang : T
  }




}
