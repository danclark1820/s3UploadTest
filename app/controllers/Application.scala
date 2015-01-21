package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import java.nio.file.Files
import java.io.File

object Application extends Controller {

//  case class ImageFile(name: String)

//  val imageForm = Form(
//    mapping(
//      "file" -> nonEmptyText
//    )(ImageFile.apply)(Iamgefile.unapply)

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}
