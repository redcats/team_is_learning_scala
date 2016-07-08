package team.is.learning.scala.ch3.apply

class Person(val name: String, val age: Int) {

    def apply() = "cooou"
   val  infos = Array("linux", "debian")
   val  infos2 = Array(9, 300)
   def update(idx: Int, inf: String): Unit = infos.update(idx, inf) // infos(idx) = inf
   def update(idx: Int, inf: Int): Unit = infos2.update(idx, inf) // infos(idx) = inf
}

object Person {
  def apply(name: String,  age: Int): Person = new Person(name, age)
  private class Collegue(override val name: String, override val age: Int, duree: Int) extends Person(name, age)

  def newColllegue(name: String,  age: Int) : Person= new Collegue(name, age, 0)

  def apply(name: String, age: Int, duree: Int) : Person = new Collegue(name, age, duree)
}


object MyApp2 {
  def main(args: Array[String]) {
    val per = new Person("", 2)

    per(0) = "Windows"
    println(per())
    per(0) = 8

    per.update(0, "Windows")



    val tony = Person("Tony", 54)
    val collegue = Person("", 3, 3)



  }
}

