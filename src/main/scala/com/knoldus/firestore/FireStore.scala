package com.knoldus.firestore
import com.google.cloud.firestore.{CollectionReference, DocumentReference, WriteResult}
import com.knoldus.connectors.FirebaseConnection.db
import com.knoldus.models._
import scala.util.{Failure, Success, Try}

class FireStore {

  var personData = MyData("3","Guys ","male")
  def writeBeanToFireStore[B](docId: String, col: CollectionReference, bean: B): Either[String, WriteResult] = {
    val newDocRef: DocumentReference = col.document(docId)
    val tryWrite =
      Try {
        newDocRef.set(bean).get()
      }
    tryWrite match {
      case Failure(ex) => Left(s"error: $ex")
      case Success(v) => Right(v)
    }
  }
  writeBeanToFireStore[MyDataBean](personData.personId, db.collection("personData"), personData.toBean)

}
