package team.is.learning.scala.ch1

object PatternMatching {

  //From Java : switch (selector) { alternatives }


  //To scala : selector match { alternatives }

  //
  //wildcard
  def noCareOfVar(x: String) : Unit = x match {
    case _ => println("hello")
  }

  //Variable
  def iNeedTheVar(x: String) : Unit = x match {
    case e => println("hello" + e.length)
  }

  //Constant and finally variable (wildcard) : Int,
  // order is important : the specific comes first
  def doubleAllExceptO1And3(x: Int) : Int = x match {
    case 1 => 1
    case 3 => 3
    case e => e * 2
  }

  //Constructor pattern : Option
  def isItThere(x: Option[String]) : Boolean = x match {
    case None => false
    case Some(x) => true
  }

  //Constructor pattern : Seq
  def isItList(xs: List[Int]) : Int = xs match {
    case Nil => 0   //empty
    case x::Nil => x // one element
    case x::y::z::Nil => x - y - z // 3 elems
    case x::y::rest => x + y  // 3 elems minimum
    case h::tail => h //1 elem minimum
  }

  //Constructor pattern : Tuple
  def diff(point: (Int, Int)) : Int = point match {
    case (x, y) => x - y
  }

  //Type pattern : a better instance of
  def isItString(x: Any) : Unit = x match {
    case e: String => println("Oh string")
    case e: Int => println("On int")
    case e => println("unknown")
  }

  //Pattern guard : if ...
  def doubleSuperiorToTen(x: Int) : Int  = x match {
      case y if (y > 10) => y*2
      case y => y
  }

  //To be discovered : variable binding, Pattern overlaps (Martin Odersky book)
}
