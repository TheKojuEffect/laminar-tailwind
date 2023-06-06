ThisBuild / scalaVersion := "3.3.0"
ThisBuild / version := "0.0.1-SNAPSHOT"


val V = new {
  val Laminar = "15.0.1"
  val ScalaJsDom = "2.6.0"
  
}

import org.scalajs.linker.interface.ModuleSplitStyle

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "ui" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("dev.koju.ui")),
        )
    },
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % V.ScalaJsDom,
      "com.raquo" %%% "laminar" % V.Laminar,
    ),
  )

