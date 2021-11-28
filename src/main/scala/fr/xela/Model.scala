package fr.xela

import fr.xela.Category.{
  TrueOrFalse,
  End,
  MultipleAnswersQuestion,
  Challenge,
  Start,
  Advice
}

case class Model(squares: List[Square], maybeSelectedSquare: Option[Square])

object Model {
  val initial: Model = Model(
    squares = List(
      Square(914, 970, Start),
      Square(
        1020,
        806,
        Challenge("Faire 10 montées de genoux")
      ),
      Square(
        1060,
        652,
        MultipleAnswersQuestion(
          "Quelle est l'unité énergétique utilisée en nutrition ?",
          List("Kg", "Newton", "Calorie", "Ampère")
        )
      ),
      Square(
        1056,
        488,
        TrueOrFalse("Est-il grave d'avoir une balance énergétique positive ?")
      ),
      Square(
        1008,
        346,
        MultipleAnswersQuestion(
          "Où y-a-t-il le plus de personnes  sous-alimentées ?",
          List("Asie", "Afrique", "Caraïbes")
        )
      ),
      Square(
        906,
        216,
        Advice(
          "Prenez l'escalier au lieu de l'ascenseur !"
        )
      ),
      Square(
        784,
        118,
        TrueOrFalse("Est-il grave d'avoir une balance énergétique négative ?")
      ),
      Square(638, 84, Challenge("Faire 10 squats")),
      Square(
        488,
        72,
        TrueOrFalse(
          "Dépense-t-on de l'énergie en restant allongé ?"
        )
      ),
      Square(
        338,
        104,
        MultipleAnswersQuestion(
          "Où s'accumule la graisse ?",
          List(
            "Tissus adipeux",
            "Tissus musculaires",
            "Tissus conjonctifs",
            "Tissus nerveux"
          )
        )
      ),
      Square(
        210,
        198,
        TrueOrFalse("L'appétit est une notion strictement psycho-sociale")
      ),
      Square(
        112,
        330,
        Advice("Quand vous prenez le tram, descendez un arrêt avant !")
      ),
      Square(
        76,
        474,
        MultipleAnswersQuestion(
          "Quel est le pourcentage d'obésité chez l'enfant de 7 à 10 ans ?",
          List("16.3", "5", "41.2", "25.3")
        )
      ),
      Square(
        80,
        632,
        TrueOrFalse(
          "Une européen sur deux est en surpoids"
        )
      ),
      Square(
        122,
        768,
        MultipleAnswersQuestion(
          "Quelle est la prévalence de l'anorexie en France ?",
          List(
            "5 cas sur 100 000",
            "250 cas sur 100 000",
            "1005 cas sur 100 000"
          )
        )
      ),
      Square(
        256,
        876,
        Challenge("Faire la chaise 20 secondes")
      ),
      Square(
        414,
        948,
        Advice(
          "Mangez une poignée de fruits secs en collation"
        )
      ),
      Square(
        578,
        962,
        TrueOrFalse("Si on ne fait rien pendant une heure, on dépense 80 kcal")
      ),
      Square(
        744,
        894,
        MultipleAnswersQuestion(
          "L'obésité n'induit pas :",
          List(
            "Le diabète",
            "Le cancer",
            "Les maladies cardio-vasculaires",
            "Des MST"
          )
        )
      ),
      Square(842, 736, Challenge("Faire 5 pompes")),
      Square(
        870,
        582,
        MultipleAnswersQuestion(
          "J'ai mangé deux cookies, pour équilibrer ma balance énergétique, je cours :",
          List("20 minutes", "45 minutes", "1 heure et demie", "2 heures")
        )
      ),
      Square(
        822,
        422,
        Advice(
          "Une assiette équilibrée = 1/2 légumes + 1/4 féculents + 1/4 protéines"
        )
      ),
      Square(
        678,
        284,
        MultipleAnswersQuestion(
          "De quel élément le métabolisme de base ne dépend-il pas ?",
          List(
            "L'activité thyroïdienne",
            "Le poids",
            "Les poumons",
            "Les organes génitaux"
          )
        )
      ),
      Square(500, 262, Challenge("Faire 20 secondes de gainage")),
      Square(344, 346, TrueOrFalse("La faim dans le monde est en baisse")),
      Square(
        260,
        502,
        MultipleAnswersQuestion(
          "L'appétit est-il régulé par :",
          List("La leptine", "L'ocytocine", "La dopamine", "La prolactine")
        )
      ),
      Square(450, 500, End)
    ),
    maybeSelectedSquare = None
  )
}
