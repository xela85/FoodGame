package fr.xela

sealed trait Attribute
object Attribute {
  case class Simple(name: String) extends Attribute
  case class Namespaced(namespace: String, name: String) extends Attribute
}
