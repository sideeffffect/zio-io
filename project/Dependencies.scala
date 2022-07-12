import sbt._

object Dependencies {

  object Versions {
    val zio = "2.0.0"
  }

  val zio = "dev.zio" %% "zio" % Versions.zio
  val zioStreams = "dev.zio" %% "zio-streams" % Versions.zio

}
