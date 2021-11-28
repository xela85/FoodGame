package fr.xela

object Controller {

  def handleEvent(model: Model, event: Event): Model = event match {
    case Event.ButtonClicked(square) =>
      model.copy(maybeSelectedSquare = Some(square))
    case Event.TextDismissed => model.copy(maybeSelectedSquare = None)
  }

}
