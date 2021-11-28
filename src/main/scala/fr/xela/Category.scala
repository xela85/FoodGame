package fr.xela

sealed trait Category

case object Category {

  case object Start extends Category
  case object End extends Category
  case class TrueOrFalse(question: String) extends Category
  case class Advice(question: String) extends Category
  case class MultipleAnswersQuestion(question: String, answers: List[String])
      extends Category
  case class Challenge(question: String) extends Category
}
