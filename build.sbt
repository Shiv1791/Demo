
import Dependencies._
import sbt.Keys._
import sbt._

name := "myproject"
version := "0.1"
scalaVersion := "2.12.8"
val scalaVer = "2.12.8"

// Enable experimental cached SBT/Ivy library resolution to speed up compile
updateOptions := updateOptions.value.withCachedResolution(true)

// Limit test concurrency to avoid timeouts when running the many tests of the many sub-projects
// 2 concurrent tests seems to have the fastest performance
concurrentRestrictions in Global += Tags.limit(Tags.Test, 2)

val commonSettings = Seq (
  scalaVersion := scalaVer,
  libraryDependencies ++= Seq(
    scalaTest,
    mockitoCore,
    typesafeConfig,
    kafka,
    akkaActor,
    akkaStream,
    akkaTestKit,
    akkaHttp,
    akkaSprayJson,
    akkaHttpTestKit,
    firebaseAdmin,
    logbackClassic,
    akkaFcm
  )
)

// Definition of modules that make up this project
lazy val common = (project in file("com/"))
  .settings(commonSettings)

lazy val root = (project in file("."))
  .aggregate(
    common
  )
  .settings(commonSettings)

//lazy val root = (project in file(".")).
//  settings(
//    name := "dataBase",
//    version := "1.0",
//    libraryDependencies ++= Seq(
//    "com.google.firebase" % "firebase-admin" % "6.6.0" ,
//    "com.typesafe" % "config" % "1.3.3"
//  )
//  )
  
