package team.is.learning.scala.ch2.exos

import java.io.{File, PrintWriter}
import java.util.Calendar

import scala.annotation.tailrec

object Exercise extends App {

  // control structure : twice
  // apply f twice
  def applyTwice(f: Int => Int, x: Int) = f(f(x))

  //flip
  def flip(f: (Int , String) => Boolean) : (String , Int) => Boolean = (s: String , i: Int) => f(i, s)

  //Factorise following functions with using one function
  def fileNameOperation(fileName: String, query: String, operation: (String, String) => Boolean): Boolean = operation(fileName, query)

  def fileNameEndWith(fileName: String, query: String) : Boolean = ???
  def fileNameContains(fileName: String, query: String) : Boolean = ???
  def fileNameStartWith(fileName: String, query: String) : Boolean = ???

  //Currying
  def withPrintWriter(file: File)(op: PrintWriter => Unit) : Unit = op(new PrintWriter(file))
  // 1 - print "coucou", and write a date in the file
  withPrintWriter(new File("/temp/yo"))((pw: PrintWriter) => {
    println("coucou")
    pw.println(Calendar.getInstance())
  })
  // 2 - print "hello scala", and write "I did the exercise"
  def op2(pw: PrintWriter): Unit = {
    println("hello scala")
    pw.println("I did the exercise")
  }
  withPrintWriter(new File("/temp/yo"))((pw: PrintWriter)=> {
    println("hello scala")
    pw.println("I did the exercise")
  })

  // Some high orderism

  def filter(xs: List[Int], p: Int =>  Boolean) : List[Int] = {
    @tailrec
    def filterRec(xs: List[Int], acc: List[Int]):  List[Int] = xs match {
      case Nil => acc.reverse
      case h::t if p(h) => filterRec(t, h::acc)
      case _::t => filterRec(t, acc)
    }

    filterRec(xs, Nil)
  }
  // he longest prefix (possibly empty) of xs of elements that satisfy p
  // ex :  [1,2,3,4,1,2,3,4] (< 3) == [1,2]
  def takeWhile(xs: List[Int], p: Int =>  Boolean) : List[Int] = {
    @tailrec
    def takeWhileRec(xs: List[Int], acc: List[Int]):  List[Int] = xs match {
      case Nil => acc.reverse
      case h::t if p(h) => takeWhileRec(t, h::acc)
      case _::t => acc.reverse
    }

    takeWhileRec(xs, Nil)
  }
  //dropWhile is takewhile inverse : [1,2,3,4,1,2,3,4] (< 3) == [3,4,1,2,3,4]
  def dropWhile(xs: List[Int], p: Int =>  Boolean) : List[Int] = xs match {
    case Nil => Nil
    case h::t if !p(h) => xs
    case _::t => dropWhile(t, p)
  }
  //returns a tuple where first element is longest prefix (possibly empty) of xs of elements that satisfy p and second element is the remainder of the list
  //ex : [1,2,3,4,1,2,3,4] (< 3) == ([1,2],[3,4,1,2,3,4])
  def span(xs: List[Int], p: Int =>  Boolean): (List[Int], List[Int]) = (takeWhile(xs, p), dropWhile(xs, p))
}
