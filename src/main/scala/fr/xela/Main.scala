package fr.xela

case class Square(x: Int, y: Int, category: Category)

object Main {

  var model: Model = Model.initial

  def main(args: Array[String]): Unit = {
    Renderer.render(model)
  }

  def dispatchEvent(event: Event): Unit = {
    model = Controller.handleEvent(model, event)
    Renderer.render(model)
  }

}
