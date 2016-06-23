package team.is.learning.scala.ch2

object Function extends App {

  //----------------------------------------------------------------
  //local function : helper function (better than private methods)
  //---------------------------------------------------------------
  def example1(word: String, msg : String) : Unit = {
    //this function is specific to this
    def oddOrEven(e: String) : Boolean = {
        e.length % 2 == 1
    }

    def replaceOdds(e: String, isOdd: Boolean, message: String) : String = {
      if(isOdd) message else e
    }

    println(replaceOdds(word, oddOrEven(word), msg))
  }
  //Scope
  def example2(word: String, msg : String) : Unit = {
    //this function is specific to this
    def oddOrEven(e: String) : Boolean = {
      e.length % 2 == 0
    }

    def replaceOdds(e: String, isOdd: Boolean) : String = {
      if(isOdd) msg else e
    }

    println(replaceOdds(word, oddOrEven(word)))
  }

  //---------------------------------------------------------------
  // function literal
  //---------------------------------------------------------------
  var double : Int => Int = (x: Int) => {
    x * 2
  }

  //val doubleX = (x: Int) => (y: Int) => x * y
  val doubleA = (x: Int) => x * 2
  //Place holder : This blank will be filled in with an argument to the function each time the function is invoked
  //single parameter
  val doubleB : Int => Int = _ * 2

  //val doubleD : (Int, Int) => Int  = (_: Int) + (_: Int) // In reality it's a sum

  //equivalent to
  def double2(x: Int) : Int = x * 2

  // With literals function is like other values
  double = double2

  //then, We can pass them as values
  val numbers = List(1,2,3,4,5,6,7,8,9)
  numbers.map(double).foreach((x : Int) => println(x))
  //Short form : the compiler is smart
  numbers.map(double).foreach(x => println(x))

  //---------------------------------------------------------------
  // Partially applied function
  //---------------------------------------------------------------

  def summing(x: Int, y: Int, z: Int) = x + y + z
  val sumV2 = summing _
  val sum1 = sumV2(1, _: Int, _: Int)
  //Simple example
  def sumWork(x: Int, y: Int, z: Int, f: (Int, Int, Int) => Int) = f(x,y,z)
  // _ needed: no function required here
  //val forWork = summing
  // _ not needed : function required
  sumWork(1,2,3, summing)

  //----------------------------------------------------------------
  // Closures
  //----------------------------------------------------------------

  // function that refers to a variable outside its params
  val message = "Hello free variable"
  def colsure1(x : Int) : String = {
     message * x
  }
  // At runtime : it's called closure (message value is captured)
  //is open term # closed term
  def closeTerm(x: Int) : String = {
    "Hello closed variable"
  }

  // varargs

  def welcome(names: String*) : Unit = {
     names.foreach(println)
  }

  val arr = Array("A","B","C")
  welcome(arr: _*)

  //Named argumenent
  def speed(distance: Double, time: Double) : Double =  distance / time
  speed(time = 1.47, distance = 5.5)

  //Default value
  def hello(lang: String = "scala") : Unit = {
    println(lang)
  }

  hello()
  hello("js")

  //----------------------------------------------------------------
  // Currying
  //----------------------------------------------------------------

  def multiply(x: Int)(y: Int) = x * y
  val r1 = multiply(2)(3)
  // decompose left associativity

  def part1(x: Int) = (y : Int) => x * y

  val part2 = part1(2)
  val r2 = part2(3)
  assert(r1 == r2)
  // as literal
  val multiply2 = (x: Int) => (y: Int) => x * y

  //Built in control structure
  def operateInInt(x: Int, op: Int => Boolean)(success: Int => Unit)(failed: Int => Unit) = {
    if(op(x)) success(x) else failed
  }

  operateInInt(1, _ % 2 == 1) { x =>
     println(s"success operation on $x")
  } { x =>
    println(s"failed operation on $x")
  }

  //By name parameters and side effects

  def when(test: Boolean, whenTrue: String, whenFalse: String) = {
    if(test) println(s"inside test $whenTrue") else println(s"inside test $whenFalse")
  }

  def writeToDB() : String = {println("Write to db done"); "ok"}
  def writeToLog() : String = {println("Write to log"); "ko"}

  when(1 == 1, writeToDB(), writeToLog())
}
