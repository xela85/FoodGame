enablePlugins(ScalaJSPlugin)

name := "Jeu"
scalaVersion := "2.13.7" // or any other Scala version >= 2.11.12

libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.10.0"

// This is an application with a main method
scalaJSUseMainModuleInitializer := true
