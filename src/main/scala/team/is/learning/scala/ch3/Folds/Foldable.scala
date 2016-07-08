package team.is.learning.scala.ch3.folds

object Foldable extends App {

  def sum(m: List[Int]) : Int = {
    def loop(acc: Int, xs: List[Int]) : Int = xs match {
      case Nil => acc
      case h::t =>  loop(acc + h, t)
    }
    loop(0, m)
  }

  def sum2(m: List[Int]) : Int = {
    def loop(acc: Int) (xs: List[Int]) (op : (Int, Int) => Int) : Int = xs match {
      case Nil => acc
      case h::t =>  loop(op(acc , h)) (t) (op)
    }
    loop(0)( m)( _ + _)
  }

  def product2(m: List[Int]) : Int = {
    def loop(acc: Int) (xs: List[Int]) (op : (Int, Int) => Int) : Int = xs match {
      case Nil => acc
      case h::t =>  loop(op(acc , h)) (t) (op)
    }
    loop(1)( m)( _ * _)
  }




  def foldLeft[A,B](z: B)(m : List[A])(op: (B, A) => B): B = m match {
    case Nil => z
    case h::t => foldLeft(op(z, h))(t)(op)
  }

  def reduceLeft[A](m: List[A])(op: (A, A) => A): A = m match {
    case Nil => throw new Exception("Empty list")
    case h::t => foldRight(h)(t)(op)
  }

  def foldRight[A, B](z: B)(m : List[A])(op: (A, B) => B): B = m match {
    case Nil => z
    case h::t => op(h, foldRight(z)(t)(op))
  }




  def product(m: List[Int]) : Int = foldRight(1)(m)((e, acc) => acc * e)

  def accumulate(acc: Int, e: Int )  = if(e > acc)  e else acc






  val numbers =  1 to 4 toList

  println(sum(numbers))
  println(product(numbers))

}
