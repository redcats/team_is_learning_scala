package team.is.learning.scala.ch3.extractors

object Usage {


  def main(args: Array[String]) {
    val email : String = Name("fred", "dupont")
    println(email)

    "roland.dupont" match {
      case Name(f, s) => println(s"Quel du ? c'est : $s")
      case e => println("----------->" +e)
    }

    val c = new Colleague("Yoan")
    wathToDo(c)
    //Pattern partout
    val Colleague(name) = create()
    println(name)

    val r = exemple()
    println(r._2)

    val (os, distro) = exemple()

    println(distro)
  }

  def exemple() : (String, String) = ("linux", "debian")

  def wathToDo(p: Person): Unit = p match {
    case Colleague(n) => println(s"Salut $n")
    case Visitor(n) => println(s"Bonjour $n")
    case Robber(_, c) => println(s"Je n'ai plus d'ordi, il portait un t-shirt $c")
  }

  def create(): Person = Colleague("unknown")

}
