package fr.xela

import fr.xela.Category._
import fr.xela.Event.ButtonClicked
import org.scalajs.dom.document
import scalatags.JsDom.svgTags._
import scalatags.JsDom.svgAttrs._
import scalatags.JsDom.implicits._

object Renderer {

  def render(model: Model): Unit = {
    val squares = model.squares
    val svgTag = document.getElementById("game")
    svgTag.textContent = ""
    val width = squares.map(s => s.x + size(s)).max
    val height = squares.map(s => s.y + size(s)).max
    squares.zipWithIndex.foreach { case (box, index) =>
      svgTag.appendChild(displaySquare(box, index))
    }

    model.maybeSelectedSquare
      .flatMap(displayText(_, width, height))
      .foreach(svgTag.appendChild)

    svgTag.setAttribute("viewBox", s"0 0 $width $height")
  }

  private def displayText(
      square: Square,
      screenWidth: Int,
      screenHeight: Int
  ) = {
    val textSize = 60
    val fullText = square.category match {
      case Start | End           => Nil
      case TrueOrFalse(question) => List(question)
      case Advice(question)      => List(question)
      case MultipleAnswersQuestion(question, answers) =>
        val numbers = ('a' to 'z').map(_.toString)
        List(question, "") ++ numbers.zip(answers).map { case (a, b) =>
          a + ") " + b
        }
      case Challenge(question) => List(question)
    }

    val textBlock = fullText.zipWithIndex.map { case (line, index) =>
      text(
        fontSize := textSize,
        fill := "white",
        x := screenWidth / 2,
        y := screenHeight / 2 + index * textSize - fullText.size / 2 * textSize,
        fontFamily := "Helvetica",
        textAnchor := "middle"
      )(line)
    }

    val group = g()(
      (rect(
        stroke := "white",
        fill := "#ff9191",
        y := screenHeight / 4,
        x := -screenWidth,
        width := screenWidth * 3,
        height := screenHeight / 2
      ) :: textBlock): _*
    ).render
    group.onclick = _ => Main.dispatchEvent(Event.TextDismissed)
    Option.when(textBlock.nonEmpty)(group)
  }

  private def displaySquare(square: Square, index: Int) = {
    val imageTag =
      image(
        width := size(square),
        height := size(square),
        xLinkHref := imageLink(square)
      )
    val textNode = square.category match {
      case Category.End | Start => None
      case _ =>
        Some(
          text(
            x := size(square) / 2,
            y := size(square) / 2 + size(square) * .23,
            textAnchor := "middle",
            fontSize := size(square) * .65,
            fontFamily := "Comic Sans MS",
            fill := "white",
            stroke := "black"
          )(index.toString)
        )

    }

    val group = g(
      transform := s"translate(${square.x} ${square.y})"
    )((List(imageTag) ++ textNode.toList): _*)

    val renderedGroup = group.render
    renderedGroup.onclick = _ => Main.dispatchEvent(ButtonClicked(square))
    renderedGroup
  }

  private def size(square: Square) = {
    square.category match {
      case Start        => 200
      case Category.End => 300
      case _            => 125
    }
  }

  private def imageLink(square: Square) = {
    val imageFilename = square.category match {
      case Start                                  => "depart.svg"
      case Category.End                           => "balance.png"
      case Category.TrueOrFalse(_)                => "bleu.svg"
      case Category.Advice(_)                     => "jaune.svg"
      case Category.MultipleAnswersQuestion(_, _) => "vert.svg"
      case Category.Challenge(_)                  => "rouge.svg"
    }
    s"images/$imageFilename"
  }

}
