package team.is.learning.scala.ch3.extractors

//Define : def unapply(object: S): Option[T]

trait Person {
  def name: String
}

class Colleague(val name: String) extends Person

object Colleague {
  def apply(n: String): Colleague = new Colleague( n)
  def unapply(c: Colleague): Option[String] = Some(c.name)
}

class Visitor(val name: String) extends Person

object Visitor {
  def unapply(v: Visitor): Option[String] = Some(v.name)
}

class Robber(val name: String, val shirtColor: String) extends Person

object Robber {
  //
  def unapply(r: Robber): Option[(String, String)] = Some((r.name, r.shirtColor))
}

// --------------------------------------------


object Name {
  //Injection : comment definir un prenom
  def apply(f: String, l: String ): String = s"$f.$l"

  //Extractor : come faire le chemain inverse
  def unapply(arg: String): Option[(String, String)] = {
    val parts = arg.split('.')
    if(parts.length == 2) Some(parts(0), parts(1)) else None;
  }

}







