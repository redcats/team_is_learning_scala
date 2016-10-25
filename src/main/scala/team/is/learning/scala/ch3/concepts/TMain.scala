package team.is.learning.scala.ch3.concepts

object TMain {


  def main(args: Array[String]): Unit = {

    val x = Some(1)

    searchGirl() match {
      case Girl(_, _) => println("G")
      case Boy(_,_) => println("B")

    }

  }

  def searchGirl() : Person = Girl("name", 23)

  def getVistor() : User = Visitor(Info(1,2,"3"), 4)


   getVistor() match {
     case all@Visitor( _, n) => println(n + "" + all.vMet())
     case all@Logged( n) => println(n + "" + all.x)
   }
}


//or / and


sealed trait Person
case class Girl(name: String, age: Int) extends Person// Valerie , 23
case class Boy(name: String, age: Int) extends Person



case class Info(x: Int, y: Int, z: String)
//
sealed trait User
case class Visitor(i: Info, n: Int)  extends User {
  def vMet () = i.x * n
}
case class Logged(x: Int) extends User



