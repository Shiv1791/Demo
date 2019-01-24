import sbt._

object Dependencies {

  val scalaTestVersion = "3.0.5"
  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % "test"

  val mockitoCoreVersion = "2.23.0"
  val mockitoCore = "org.mockito"  % "mockito-core" % mockitoCoreVersion % Test

  val typesafeConfig = "com.typesafe" % "config" % "1.3.3"
  

  val akkaHttpVersion = "10.1.6"
  val akkaVersion = "2.5.19"
  val akkaHttpCoreVersion = "0.2.2"

  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaTestKit = "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  val akkaStream = "com.typesafe.akka" %% "akka-stream" % akkaVersion

  val akkaHttp = "com.typesafe.akka" %% "akka-http"  % akkaHttpVersion
  val akkaSprayJson = "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion
  val akkaHttpTestKit = "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion
  val akkaHttpCore = "ch.megard" %% "akka-http-cors" % akkaHttpCoreVersion

  val firebaseAdmin = "com.google.firebase" % "firebase-admin" % "6.6.0"
  val json4s = "org.json4s" %% "json4s-native" % "3.6.3"
  val kafka = "org.apache.kafka" %% "kafka" % "2.1.0"
  val akkaFcm = "com.lightbend.akka" %% "akka-stream-alpakka-google-fcm" % "1.0-M1"

  val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.2.3"
}
