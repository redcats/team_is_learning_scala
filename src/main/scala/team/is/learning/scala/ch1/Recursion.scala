package team.is.learning.scala.ch1

object Recursion {

  def main(args: Array[String]) {
    infinite()

  }


  //Simple case : recusion is just repitition
  def infinite() : Unit = {
    println("hello")
    infinite()
  }

  //Another simple case
  def repeat(x: Int) : List[Int] =  {
    x::repeat(x)
  }

  //Usefull case : we need some result
  //general thinking : minimal cases for break + general case for recursion
  //It's not always easy to do
  def replicate(n: Int, y: String) : List[String] = n match {
    case 0 => Nil
    case _ => y::replicate(n-1, y)
  }

}
