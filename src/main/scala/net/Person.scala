package net

import slick.driver.MySQLDriver.api._

case class Person(name: String)

class PersonTable(tag: Tag) extends Table[Person](tag, "person") {

      def name = column[String]("name")

      override def * = name <> (Person.apply, Person.unapply)
}