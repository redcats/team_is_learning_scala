package team.is.learning.scala.ch2.exos

import java.io.{File, PrintWriter}

object Exercise extends App {

  // control structure : twice
  // apply f twice
  def applyTwice(f: Int => Int, x: Int) = ???

  //flip
  def flip(f: (Int , String) => Boolean) : (String , Int) => Boolean = (s: String, x:Int) => f(x, s)

  def flip(f: Int => String => Boolean) : String => Int => Boolean = (s: String) => (x:Int) => f(x)(s)


  def example(x: Int, s: String) = (s.length + x > 10)
  def flipedExample = flip(example _)
  assert(example(2, "scala") == flipedExample("scala", 2))

  //Factorise following fucntions with using one function
  def fileNameEndWith(fileName: String, query: String) : Boolean = mafon(fileName, query, _.startsWith(_) )
  def fileNameContains(fileName: String, query: String) : Boolean = fileName.contains(query)
  def fileNameStartWith(fileName: String, query: String) : Boolean = fileName.startsWith(query)



  def mafon(fileName: String, query: String, f: (String, String) => Boolean) = {
    f(fileName, query)
  }

  val filename = "learnscala.pdf"

  assert(fileNameEndWith(filename, "pdf") == true)
  assert(fileNameContains(filename, "scala") == true)
  assert(fileNameStartWith(filename, "learn") == true)
  assert(fileNameStartWith(filename, "js") == false)

  //Currying
  def withPrintWriter(file: File)(op: PrintWriter => Unit) : Unit = ???
  // 1 - print "coucou", and write a date in the file
  // 2 - print "hello scala", and write "I did the exercise"

  // Some high orderism

  def filter(xs: List[Int], p: Int =>  Boolean) : List[Int] = ???
  // he longest prefix (possibly empty) of xs of elements that satisfy p
  // ex :  [1,2,3,4,1,2,3,4] (< 3) == [1,2]
  def takeWhile(xs: List[Int], p: Int =>  Boolean) : List[Int] = xs match {
    case h::t if p(h) => h :: takeWhile(t, p)
    case _ => Nil
  }



  //dropWhile is takewhile inverse : [1,2,3,4,1,2,3,4] == [3,4,1,2,3,4]
  def dropWhile(xs: List[Int], p: Int =>  Boolean) : List[Int] = ???
  //returns a tuple where first element is longest prefix (possibly empty) of xs of elements that satisfy p and second element is the remainder of the list
  //ex : [1,2,3,4,1,2,3,4] (< 3) == ([1,2],[3,4,1,2,3,4])
  def span(xs: List[Int], p: Int =>  Boolean): (List[Int], List[Int]) = ???
}
