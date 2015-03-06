package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import java.nio.file.Files
import java.io.File

object Application extends Controller {

  def upload = Action(parse.multipartFormData) { request =>
    request.body.file("picture").map { picture =>
      val filename = picture.filename
      val contentType = picture.contentType
      picture.ref.moveTo(new File(s"/tmp/$filename"))
      Ok(s"File $filename uploaded")
    }.getOrElse {
      Redirect(routes.Application.index).flashing(
        "error" -> "Missing file"
      )
    }
  }

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}
