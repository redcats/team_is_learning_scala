package team.is.learning.scala.ch3.concepts

object Concept {

  //Ideal world

  def incr(x: Int) : Int = x + 1
  def double(x: Int) : Int = x * 2

  //Awesome
  double(incr(1))

  //Welcome to real world
  def incrRealWorld(x: Int) : Option[Int] = Some(x + 1)

  //I would like to continue pur world
  //incrRealWorld(2) + double(2) : we can not

  incrRealWorld(2).map(x =>  double(x))

  //[A] -> A -> B -> [B]
  //define it
  def map[A, B](s: Option[A])(op : A => B) : Option[B] = s match {
    case None => None
    case Some(x) => Some(op(x))
  }
  //Option is a functor

  //back to real world
  def doubleRealWorld(x: Int) : Option[Int] = Some(x * 2)

  //What we want : [A] -> A -> [B] -> [B]
  def flatMap[A, B](s: Option[A])(op : A => Option[B]) : Option[B] = s match {
    case None => None
    case Some(x) => op(x)
  }

  //Option is a monad
  val result = incrRealWorld(2).flatMap(x => doubleRealWorld(x))

  //for comprension
  val r = for {
    r1 <- incrRealWorld(2);
    if r1 > 10
    r2 <- doubleRealWorld(r1)
  } yield r2

  //happy path and fail fast


}
