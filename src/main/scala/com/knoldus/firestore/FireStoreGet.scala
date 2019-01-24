package com.knoldus.firestore

import com.google.cloud.firestore.{CollectionReference, DocumentSnapshot}
class FireStoreGet {


//  def getData():ValueEventListener{
//
//  }
//  val docRef = db.collection("cities").document("SF")
//  // asynchronously retrieve the document
//  val future = docRef.get
//  // ...
//  // future.get() blocks on response
//  val document = future.get
//  if (document.exists) System.out.println("Document data: " + document.getData)
//  else System.out.println("No such document!")
  def getSnapshotDoc(docId: String)(col: CollectionReference): Either[String, DocumentSnapshot] = {
    val docSnapshot = col.document(docId).get().get()
    if (docSnapshot.exists()) Right(docSnapshot) else Left("Nothing")
  }

  def getSnapshots(docIds: Seq[String])(col: CollectionReference): Either[String, Seq[DocumentSnapshot]] = {
    val documentSnapshots =
      docIds.map(id => col.document(id).get()).map(af => af.get())

    if (documentSnapshots.exists(!_.exists())) Left("Nothing")
    else Right(documentSnapshots)
  }


}

