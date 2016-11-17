package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.io.Source
import play.api.libs.functional.syntax._

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
   
  //Can call this function to redirect to index page from wherever
  def redirect = Action { implicit request => Redirect(routes.HomeController.index()) }
  
  //Importing North American Video Game Sales Data
  val source_na: String = Source.fromFile("app/assets/vgsales_na.json").getLines.mkString
  val json_na: JsValue = Json.parse(source_na)

  //Importing European Video Game Sales Data
  val source_eu: String = Source.fromFile("app/assets/vgsales_eu.json").getLines.mkString
  val json_eu: JsValue = Json.parse(source_eu)

  //Importing Japanese Video Game Sales Data
  val source_jp: String = Source.fromFile("app/assets/vgsales_jp.json").getLines.mkString
  val json_jp: JsValue = Json.parse(source_jp)
 
  //Importing Other Regions Video Game Sales Data
  val source_other: String = Source.fromFile("app/assets/vgsales_other.json").getLines.mkString
  val json_other: JsValue = Json.parse(source_other)

  //Importing All Video Game Sales Data
  val source: String = Source.fromFile("app/assets/videogames.json").getLines.mkString
  val json: JsValue = Json.parse(source)

  //Mapping Region Sales
  val na_sales = (json \\ "NA_Sales").map(_.as[Double])
  val eu_sales = (json \\ "EU_Sales").map(_.as[Double])
  val jp_sales = (json \\ "JP_Sales").map(_.as[Double])
  val other_sales = (json \\ "Other_Sales").map(_.as[Double])
  
  //Send these values to Index so that we can show them off in Graph format
  val na_total = na_sales.sum
  val eu_total = eu_sales.sum
  val jp_total = jp_sales.sum
  val other_total = other_sales.sum
  
  //Send the values to HTML
  val values = Array(na_total, eu_total, jp_total, other_total)
    
  //Sends message and values to html
  def index = Action{ Ok(views.html.index(values, "Video Game Data Analytics","Click on any link to go to the corresponding dataset")) }
  
  //Functions to Send JSON to page
  def getNaSales = Action{ Ok(Json.prettyPrint(json_na)) }
  def getEuSales = Action{ Ok(Json.prettyPrint(json_eu)) }
  def getJpSales = Action{ Ok(Json.prettyPrint(json_jp)) }
  def getOtherSales = Action{ Ok(Json.prettyPrint(json_other)) }
  def getSales = Action{ Ok(Json.prettyPrint(json)) }
  }