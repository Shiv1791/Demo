package com.knoldus.connectors

import java.io.FileInputStream

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.database._
import com.google.firebase.{FirebaseApp, FirebaseOptions}
import com.typesafe.config.{Config, ConfigFactory}

object FirebaseConnection {

  val config: Config = ConfigFactory.load()
  val serviceAccount: FileInputStream = new FileInputStream(config.getString("database.keyPath"))
  val databaseUrl: String = config.getString("database.databaseURL")
  private val options = new FirebaseOptions.Builder()
    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    .setDatabaseUrl(databaseUrl)
    .build()
  FirebaseApp.initializeApp(options)

  private val database = FirebaseDatabase.getInstance()

  def ref(path: String): DatabaseReference = database.getReference().child(path)
  val db: Firestore = FirestoreClient.getFirestore
}
