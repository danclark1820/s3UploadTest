name := "s3UploadTest"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.github.seratch" %% "awscala" % "0.4.+"
)

play.Project.playScalaSettings
