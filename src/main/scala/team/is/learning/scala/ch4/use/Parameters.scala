package team.is.learning.scala.ch4.use

object Parameters extends App {

  //implicit parameters usually have “rare” or “special” enough types that accidental matches are unlikely

  def sayHello(msg: String)(implicit lang: Lang, specific: Specific) = {
    println(s"${lang.s} > ${specific.s} ! $msg")
  }

  def sayHello2(msg: String)(implicit lang: Lang, specific: Specific) = {
    println(s"${implicitly[Lang].s} > ${implicitly[Lang].s} ! $msg")
  }


  import Preambule._

  sayHello("Bienvenue")

  //Use of imlicitly[T] : ask compiler to look for an implicit definition of type T


  sayHello2("Bienvenue")

  sayHello2("Bienvenue")(Lang("1"), Specific("1"))

}
