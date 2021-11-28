package fr.xela

sealed trait Event

object Event {
  case class ButtonClicked(square: Square) extends Event
  case object TextDismissed extends Event
}
