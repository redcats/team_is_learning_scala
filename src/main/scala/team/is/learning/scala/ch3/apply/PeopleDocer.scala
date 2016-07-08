package team.is.learning.scala.ch3.apply

//--------------------------
//1 - Factory methods
//---------------------------


class PeopleDocer(age: Int, name: String) {
  var badge = false
  val games = Set("fifa", "baby", "cards")
  val information = Array("linux", "debian")
  def apply(game: String) = games(game)
  def update(badge: Boolean) = this.badge = badge
  def update(idx: Int, info: String) = information(idx) = info
}

object PeopleDocer {
  //Factory method : Injection method
  def apply(age: Int, name: String): PeopleDocer = new PeopleDocer(age, name)

  def apply() = "coucou scala"

  //User factory method
  private class Asid(os: String, age: Int, name: String) extends PeopleDocer(age, name)

  private class Developer(lang: String, age: Int, name: String) extends PeopleDocer(age, name)

  def scalaDev(age: Int, name: String): PeopleDocer = new Developer("scala", age, name)

  def asid(age: Int, name: String): PeopleDocer = new Asid("debian", age, name)
}


object MyApp {
  def main(args: Array[String]) {
    val p1 = new PeopleDocer(34, "Durant")
    println(p1)
    val p2 = PeopleDocer(34, "Dupont")
    println(p2)
    val p3 = PeopleDocer()
    println(p3)
    val p4 = PeopleDocer.scalaDev(32, "Ducoin")
    println(PeopleDocer.asid(32, "Patlin")("baby"))
    p4() = false
    println("badge " + p4.badge)
    //An that's why it's working : no need of new
    val s = Set("Dupont", "Durant")
    println(s.apply("salah eddine"))
  }
}
