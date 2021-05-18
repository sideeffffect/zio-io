import sbt._

object Dependencies {

  object Versions {
    val zio = "1.0.8"
  }

  val zio = "dev.zio" %% "zio" % Versions.zio
  val zioStreams = "dev.zio" %% "zio-streams" % Versions.zio

}
