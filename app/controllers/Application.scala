package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import java.nio.file.Files
import java.io.File

import awscala.s3._
import awscala.Region
import com.amazonaws.{ regions => awsregions }


object Application extends Controller {

  implicit val s3 = S3()

  val uuid = java.util.UUID.randomUUID.toString
  //val bucket: Bucket = s3.createBucket(s"play-test-$uuid")
  val buckets: Seq[Bucket] = s3.buckets
  val bucket = buckets(3)


  def upload = Action(parse.multipartFormData) { request =>
    request.body.file("picture").map { picture =>
      val filename = picture.filename
      val contentType = picture.contentType
      bucket.put(s"$filename", picture.ref.file)
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
