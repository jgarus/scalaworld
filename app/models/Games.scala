import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Games(rank: Int, name: String, platform: String, year: String,
  genre: String, publisher: String, na_sales: Int, eu_sales: Int, jp_sales: Int,
  other_sales: Int, global_sales: Int) {


  }
