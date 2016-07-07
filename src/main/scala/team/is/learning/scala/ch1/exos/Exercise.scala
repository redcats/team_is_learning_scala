package team.is.learning.scala.ch1.exos

import java.lang.Exception

import scala.annotation.tailrec

object Exercise {


  def main(args: Array[String]) {
    //infinite("Hello scala")
  }

  //infinite println
  def infinite(msg: String): Unit = ???

  //Infinite repeat of x
  def repeat(x: Int): List[Int] = ???

  // sum
  def sum(xs: List[Int]) : Int = {

    @tailrec
    def loop(acc: Int, ys: List[Int]) : Int = ys match {
      case Nil => acc
      case h::t => loop(acc + h, t)
    }

    loop(0, xs)
  }

  //replicate msg n times
  def replicate(n: Int, msg: String): List[String] = ???

  def maximum(xs: List[Int]) : Int = {
    @tailrec
    def loop(acc: Int,  ys: List[Int]) : Int = ys match {
      case Nil => acc
      case h::t if  h > acc => loop(h, t)
      case _::t => loop(acc, t)
    }

    xs match {
      case Nil => throw new Exception("Empty list")
      case h::t => loop(h, t)
    }
  }


  def maximum0(xs: List[Int]): Int = {
    def loop(max: Int, ys: List[Int]) : Int = ys match {
      case Nil => max
      case h :: t => {
        if (h>max) loop(h, t)
        else loop(max, t)
      }
    }
    loop(0, xs)
  }

  def reverse(xs: List[String]) : List[String] = ???

  def contains(xs: List[String], elem: String) : Boolean = ???

  //take n first elems from xs
  def take(n: Int, xs: List[String]) : List[String] = {

    def loop(pos: Int, acc: List[String], ys: List[String]) : List[String] = {
      if(pos > n) acc
      else {
        ys match {
          case Nil => acc
          case h::t => acc match {
            case Nil => loop( pos + 1, h::acc, t)
            case h1::t1 => loop( pos + 1, h1::h::t1, t)
          }
        }
      }
    }
    loop(0, Nil, xs)

  }




}
