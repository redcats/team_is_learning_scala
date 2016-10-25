package team.is.learning.scala.ch4

object Principle extends App {



  //Conversion : Une plaie java ça
  def persisteCount(x: Int): Unit = {
    println(s"$x")
  }

  val x = external.Calculation.count()

  //Solution 1 : explicit
  def convert(r: String): Int = Integer.valueOf(r)
  persisteCount(convert(x))

//  //Avec les implicits on reduit tres largement les conversion de type
}
