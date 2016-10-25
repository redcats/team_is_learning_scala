package team.is.learning.scala.ch3.concepts

import scala.concurrent.Future

object Usage {

  def main(args: Array[String]): Unit = {

  }


  def incr(x: Int) : Int = x + 1
  def double(x: Int) : Int = x * 2

  double(incr(3))

  //Failure, les dependance, les excption, side effect

  def incrRealWorld(x: Int) : Option[Int] = Some(x + 1)

  //Functor : map
  val result : Option[Int] = incrRealWorld(3).map( x => double(x))

  //
  def doubleRealWorld(x: Int) : Option[Int] = Some(x * 2)

  //Monad
  val result2 : Option[Int] = incrRealWorld(3).flatMap(x => doubleRealWorld(x))



  def tripleRealWorld(x: Int) : Option[Int] = Some(x * 3)

  val r3 =   incrRealWorld(3).
    flatMap(x => doubleRealWorld(x)).
    flatMap(y => tripleRealWorld(y))

  //for comprenhension

   for(i <- 0 to 10) {
     println(i)
   }

  //map

  def quadrubleRealWorld(x: Int) : Option[Int] = Some(x * 4)

  val r5 = for(x <- quadrubleRealWorld(3)) yield double(x)

  val r5prim = quadrubleRealWorld(3).map(x => double(x))

  //flatMap



  incrRealWorld(3).flatMap(x => doubleRealWorld(x))








  // Ecrivez

  def myValues : List[Int] = (2 to 10).toList
  def myFunctions : List[Int => Int] = List(x => 10000, x => 0)

  val resultN : List[Int] = for {
    x <- myValues
    f <- myFunctions
  } yield f(x)

}
