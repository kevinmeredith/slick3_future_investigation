package net

import slick.driver.MySQLDriver.api._

case class Person(name: String)

class PersonTable(tag: Tag) extends Table[Person](tag, "PERSON") {

      def name = column[String]("NAME")
      override def * = name <> (Person.apply, Person.unapply)
}