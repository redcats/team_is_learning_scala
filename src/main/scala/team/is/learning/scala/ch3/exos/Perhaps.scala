package team.is.learning.scala.ch3.exos

sealed trait Perhaps[+A] {
  def map[B](op: (A) => B): Perhaps[B] = this match {
    case Ok(y) => Ok(op(y))
    case Ko => Ko
  }

  def flatMap[B](op: A => Perhaps[B]): Perhaps[B] = this match {
    case Ko => Ko
    case Ok(x) => op(x)
  }

  def withFilter(op: A => Boolean) : Perhaps[A] = this match {
    case Ok(x) if op(x) => Ok(x)
    case _ => Ko
  }
}

case class Ok[A](x: A) extends Perhaps[A]

case object Ko extends Perhaps[Nothing]


object AppMain {
  def main(args: Array[String]) {
    val r1 = Ok(2)
    val r2 = Ok(3)
    val rrr = Some(333)

    //Map
    val r3 = for {
      x1 <- Ok(1)
    } yield x1 + 10

    println(r3)
    //flatMap
    val r4 = for {
      x1 <- Ok(1);
      if x1 > 10
      x2 <- Ok(3)
    } yield x1 + x2

    println(r4)

  }
}