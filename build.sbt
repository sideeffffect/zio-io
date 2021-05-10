Global / onChangedBuildSource := ReloadOnSourceChanges
ThisBuild / turbo := true

lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    name := "zio-io",
    publish / skip := true
  )
  .aggregate(zioIoNet)

lazy val zioIoNet = project
  .in(file("zio-io-net"))
  .settings(commonSettings)
  .settings(
    name := "zio-io-net",
    libraryDependencies ++= List(
      Dependencies.zio,
      Dependencies.zioStreams
    )
  )
  .enablePlugins(BuildInfoPlugin)

lazy val commonSettings: List[Def.Setting[_]] = DecentScala.decentScalaSettings ++ List(
  organization := "com.github.sideeffffect",
  homepage := Some(url("https://github.com/sideeffffect/zio-io")),
  licenses := List("APLv2" -> url("https://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      "sideeffffect",
      "Ondra Pelech",
      "ondra.pelech@gmail.com",
      url("https://github.com/sideeffffect")
    )
  ),
  testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
  missinglinkExcludedDependencies ++= List(
    moduleFilter(organization = "org.slf4j", name = "slf4j-api"),
    moduleFilter(organization = "org.testcontainers", name = "testcontainers")
  ),
  mimaReportBinaryIssues := {}
)

addCommandAlias("ci", "; check; +publishLocal")
