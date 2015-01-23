package plugins

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.service.s3.AmazonS3Client
import play.Application
import play.api.Play.current
import play.Logger
import play.Plugin

class S3Plugin extends Plugin {

  val AWS_S3_BUCKET = "aws.s3.bucket"
  val AWS_ACCESS_KEY = "aws.access.key"
  val AWS_SECRET_KEY = "aws.secret.key"

  val amzonS3:AmazonS3;

  val s3Bucket:String;

  override def onStart = {
    val accessKey = current.configuration.getString(AWS_ACCESS_KEY)
    val secretKey = current.configuartion.getString(AWS_SECRET_KEY)
    val s3Bucket = current.configuration.getString(AWS_S3_BUCKET)

    if ((accessKey != null) && (secretKey != null)) {
      val awsCredentials = new BasicAWSCredentials(accessKey, secretKey)
      amazonS3 = new AmazonS3Client(awsCredentials)
      amazonS3.createBucket(s3Bucket)
      Logger.info("Using S3 Bucket: " + s3Bucket)
    }
  }

  override def enabled:boolean = {
    if (application.configuration.keys.contains(AWS_ACCESS_KEY) &&
     application.configuration.keys.contains(AWS_SECRET_KEY) &&
     application.configuration.keys.contains(AWS_S3_BUCKET))
}
