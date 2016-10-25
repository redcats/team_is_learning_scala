package team.is.learning.scala.ch3.concepts.ADT

sealed trait Transport
case class Bus(line: Int, color: String) extends Transport
case class Tram(color: String) extends Transport


object Usage {
  def main(args: Array[String]): Unit = {
    val Bus(l, c) = bus(13)
    val bus2 = bus(34)

    println(s"$l $c")
    println(s"${bus2.line} ${bus2.color}")
    test()

    println(pf(bus2))
    println(if(pf.isDefinedAt(transport())) pf(transport()))

  }


  def pf : PartialFunction[Transport, Int] =  {
    case Bus(l, _) => l
  }


  def test() = {
    val t : Transport = transport()

    t match {
      case Bus(l,_) => println(l)
      case Tram(l) => println(l)
    }
  }

  def bus(line: Int) =  Bus(line, "red")

  def transport() : Transport = Tram("blue")
}
