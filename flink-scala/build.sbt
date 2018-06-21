ThisBuild / resolvers ++= Seq(
  "Apache Development Snapshot Repository" at "https://repository.apache.org/content/repositories/snapshots/",
  Resolver.mavenLocal
)

name := "flink-scala"

version := "0.1-SNAPSHOT"

organization := "tao"

ThisBuild / scalaVersion := "2.11.12"

lazy val root = (project in file(".")).
  settings(
    libraryDependencies ++= flinkDependencies,
    libraryDependencies += twitterConnectorLogDependencies,
    libraryDependencies += jacksonDependencies,
    libraryDependencies += scalaTestDependencies
  )
val flinkVersion = "1.5.0"
val flinkDependencies = Seq(
  "org.apache.flink" %% "flink-scala" % flinkVersion % "provided",
  "org.apache.flink" %% "flink-connector-twitter" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion % "provided")

val twitterConnectorLogDependencies = "commons-logging" % "commons-logging" % "1.2"
val playJsonDependencies = "com.typesafe.play" %% "play-json" % "2.6.9"
val jacksonDependencies = "com.fasterxml.jackson.core" % "jackson-core" % "2.9.6"
val scalaTestDependencies = "org.scalatest" %% "scalatest" % "3.0.5" % "test"

assembly / mainClass := Some("tao.Job")

// make run command include the provided dependencies
Compile / run := Defaults.runTask(Compile / fullClasspath,
  Compile / run / mainClass,
  Compile / run / runner
).evaluated

// stays inside the sbt console when we press "ctrl-c" while a Flink programme executes with "run" or "runMain"
Compile / run / fork := true
Global / cancelable := true

// exclude Scala library from assembly
assembly / assemblyOption := (assembly / assemblyOption).value.copy(includeScala = false)
