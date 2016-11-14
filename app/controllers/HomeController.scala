package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.io.Source
import org.json4s._
import org.json4s.native.JsonMethods._
//import play.api.libs.json.JsValue // work on this, it might be a way to send json unhindered to views

  /**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
  @Singleton
  class HomeController @Inject() extends Controller {
  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { Ok(views.html.index("Video game data analysis")) }

  //Can call this function to redirect to index page from wherever
  def redirect = Action { implicit request => Redirect(routes.HomeController.index()) }
 
  val source_na: String = Source.fromFile("app/assets/vgsales_na.json").getLines.mkString
  val json_na: JsValue = Json.parse(source_na)
  val pjson_na = Json.prettyPrint(json_na)

  val source_eu: String = Source.fromFile("app/assets/vgsales_eu.json").getLines.mkString
  val json_eu: JsValue = Json.parse(source_eu)
  val pjson_eu = Json.prettyPrint(json_eu)
 
  val source_jp: String = Source.fromFile("app/assets/vgsales_jp.json").getLines.mkString
  val json_jp: JsValue = Json.parse(source_jp)
  val pjson_jp = Json.prettyPrint(json_jp)

 
  val source_other: String = Source.fromFile("app/assets/vgsales_other.json").getLines.mkString
  val json_other: JsValue = Json.parse(source_other)
  val pjson_other = Json.prettyPrint(json_other)

 
  val source_global: String = Source.fromFile("app/assets/vgsales_global.json").getLines.mkString
  val json_global: JsValue = Json.parse(source_global)
  val pjson_global = Json.prettyPrint(json_global)

 
  val source: String = Source.fromFile("app/assets/videogames.json").getLines.mkString
  val json: JsValue = Json.parse(source)
  val pjson = Json.prettyPrint(json)
       
  val lat2 = json \\ "Name"
  val test2: JsValue = Json.toJson(lat2)
  
  val lat3 = json \\ "na_sale"
  val test3: JsValue = Json.toJson(lat3)
       
  //Function to load JSON in plain text in an html page
  def getNaSales = Action{ Ok(test2) }
  
  def getEuSales = Action{ Ok(pjson_eu) }
  
  def getJpSales = Action{ Ok(pjson_jp) }
  
  def getOtherSales = Action{ Ok(pjson_other) }
  
  def getGlobalSales = Action{ Ok(pjson_global) }
  
  def getSales = Action{ Ok(pjson) }
  }
