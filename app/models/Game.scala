package models;

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Game (
  rank: Int,
  name: String,
  platform: String,
  year: Int,
  genre: String,
  publisher: String,
  na_sales: Int,
  eu_sales: Int,
  jp_sales: Int,
  other_sales: Int,
  global_sales: Int
)

object Game {
  implicit val messageReads: Reads[Game] = (
    (JsPath \ "id").read[Int] and
    (JsPath \ "name").read[String] and
    (JsPath \ "platform").read[String] and
    (JsPath \ "year").read[Int] and
    (JsPath \ "genre").read[String] and
    (JsPath \ "publisher").read[String] and
    (JsPath \ "na_sales").read[Int] and
    (JsPath \ "eu_sales").read[Int] and
    (JsPath \ "jp_sales").read[Int] and
    (JsPath \ "other_sales").read[Int] and
    (JsPath \ "global_sales").read[Int]
  )(Game.apply _)
}
