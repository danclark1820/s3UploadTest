name := "s3UploadTest"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.amazonaws" % "aws-java-sdk" % "1.8.9.1"
)

play.Project.playScalaSettings
