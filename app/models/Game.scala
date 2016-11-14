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
  na_sales: Float,
  eu_sales: Float,
  jp_sales: Float,
  other_sales: Float,
  global_sales: Float
)

object Game {
  implicit val messageReads: Reads[Game] = (
    (JsPath \ "id").read[Int] and
    (JsPath \ "name").read[String] and
    (JsPath \ "platform").read[String] and
    (JsPath \ "year").read[Int] and
    (JsPath \ "genre").read[String] and
    (JsPath \ "publisher").read[String] and
    (JsPath \ "na_sales").read[Float] and
    (JsPath \ "eu_sales").read[Float] and
    (JsPath \ "jp_sales").read[Float] and
    (JsPath \ "other_sales").read[Float] and
    (JsPath \ "global_sales").read[Float]
  )(Game.apply _)
}
