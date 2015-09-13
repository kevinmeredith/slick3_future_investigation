package net

import net.Person._
import slick.driver.MySQLDriver.api._
import scala.concurrent.{ExecutionContext, Future}

object PersonService {

   //good: val db = Database.forURL("jdbc:mysql://localhost:3306/person", "root", "")
   val db = Database.forURL("jdbc:mysql://www.google.com:3306/person", "root", "")

   private lazy val personQuery = TableQuery[PersonTable]

   def find(name: String)(implicit ec: ExecutionContext): Future[Seq[Person]] = {
     val action = personQuery.filter(_.name === name).result
     db.run(action)
   }
}