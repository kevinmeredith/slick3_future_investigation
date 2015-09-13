package net

import net.Person._
import slick.driver.MySQLDriver.api._
import scala.concurrent.{ExecutionContext, Future}

object PersonService {

   val db = Database.forURL("jdbc:mysql://localhost:3306/person", "root", "")
   private lazy val personQuery = TableQuery[PersonTable]

   def findPersons(name: String)(implicit ec: ExecutionContext): Future[Seq[Person]] = {
     val action = personQuery.filter(_.name === name).result
     db.run(action)
   }
}