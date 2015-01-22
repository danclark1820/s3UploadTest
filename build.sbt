name := "s3UploadTest"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "nl.rhinofly" %% "play-s3" % "4.0.0"
)

resolvers += "Rhinofly Internal Repository" at "http://maven-repository.rhinofly.net:8081/artifactory/libs-release-local"

play.Project.playScalaSettings
