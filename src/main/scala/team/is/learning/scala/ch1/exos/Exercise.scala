package team.is.learning.scala.ch1.exos

import scala.annotation.tailrec

object Exercise {


  def main(args: Array[String]) {
    //infinite("Hello scala")

    val list1432 = 1::4::3::2::Nil
    println("sum 1 4 3 2 : " + sum(list1432))
    println("replicate bla 4 time : " + replicate(4, "bla "))
    println("max 1 4 3 2 : " + maximum(list1432))
    println("reverse 1 4 3 2 : " + reverse(list1432))
    val list_aa_ab_bc_cd = "aa"::"ab"::"bc"::"cd"::Nil
    println("contains bc in aa ab bc cd : " + contains(list_aa_ab_bc_cd, "bc"))
    println("contains de in aa ab bc cd : " + contains(list_aa_ab_bc_cd, "de"))
    println("take 3 in aa ab bc cd : " + take2(3, list_aa_ab_bc_cd))
    println("take 10 in aa ab bc cd : " + take2(10, list_aa_ab_bc_cd))
    println("take -10 in aa ab bc cd : " + take2(-10, list_aa_ab_bc_cd))
  }

  //infinite println
  def infinite(msg: String): Unit = {
    println(msg)
    infinite(msg)
  }

  //Infinite repeat of x
  def repeat(x: Int): List[Int] = x::repeat(x)

  // Sum
  def sum(xs: List[Int]): Int = {
    @tailrec
    def sumRec(xs: List[Int], acc: Int): Int = xs match {
      case Nil => acc
      case h :: t => sumRec(t, h + acc)
    }

    sumRec(xs, 0)
  }

  //replicate msg n times
  def replicate(n: Int, msg: String): List[String] = {
    @tailrec
    def replicateRec(n: Int, acc: List[String]): List[String] = n match {
      case 0 => acc
      case _ => replicateRec(n - 1, msg::acc)
    }

    replicateRec(n, Nil)
  }

  def maximum(xs: List[Int]): Int = {
    @tailrec
    def maxRec(currentMax: Int, xs: List[Int]): Int = xs match {
      case Nil => currentMax
      //case h::t => if (h > currentMax) maxRec(h, t) else maxRec(currentMax, t)
      case h::t if h > currentMax => maxRec(h, t)
      case _::t => maxRec(currentMax, t)
    }

    maxRec(Int.MinValue, xs)
  }

  def reverse(list: List[Int]): List[Int] = {
    @tailrec
    def reverseRec(reversed: List[Int], list: List[Int]): List[Int] = list match {
      case Nil => reversed
      case h::t => reverseRec(h::reversed, t)
    }

    reverseRec(Nil, list)
  }

  @tailrec
  def contains(xs: List[String], elem: String) : Boolean = xs match {
    case Nil => false
    case h::t if h == elem => true
    case _::t => contains(t, elem)
  }

  //take n first elems from xs
  def take(n: Int, xs: List[String]) : List[String] = {
    @tailrec
    def takeRec(index: Int, acc: List[String]) : List[String] = index match {
      case i if i <= 0 => acc
      case _ =>
        val nextIndex = index - 1
        takeRec(nextIndex, xs(nextIndex) :: acc)
    }

    if (n > xs.length) xs
    else takeRec(n, Nil)
  }

  def take2(n: Int, xs: List[String]) : List[String] = {
    @tailrec
    def takeRec(index: Int, xs: List[String], acc: List[String]) : List[String] = xs match {
      case _ if index <= 0 => acc.reverse
      case Nil => acc.reverse
      case h::t => takeRec(index - 1, t, h :: acc)
    }

    takeRec(n, xs, Nil)
  }

}
