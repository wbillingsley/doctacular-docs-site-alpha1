enablePlugins(ScalaJSPlugin)

name := "Doctacular Site"
scalaVersion := "3.1.0"

resolvers += "jitpack" at "https://jitpack.io"

updateOptions := updateOptions.value.withLatestSnapshots(false)

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

// Because we then use webpack to build the final output
scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) }

// ScalaJSBundler currently disabled because of failures reading webpack statistics that should be
// fixed soon. See https://github.com/scalacenter/scalajs-bundler/pull/408
// Until then, we'll just use webpack externally
// 
// useYarn := true
//
// there is an issue whereby if there is an anonymous top-level given, the name that Scala.js will
// give it involves a character that the SourceMap generator fails to read.
// https://github.com/scalacenter/scalajs-bundler/issues/385
// As sites built by users aren't likely to be debugged step-by-step, we just turn off sourcemaps
// webpackEmitSourceMaps := false
//
//enablePlugins(ScalaJSBundlerPlugin)
//
// Compile / npmDependencies ++= Seq(
//    "marked" -> "4.0.1"
//  )


libraryDependencies ++= Seq(
  "com.github.wbillingsley.veautiful" %%% "doctacular" % "v0.2-SNAPSHOT",
  "com.github.wbillingsley" % "lavamaze" % "master-SNAPSHOT", // Need to single-% as it's a top-level jitpack project
)

val deployFast = taskKey[Unit]("Copies the fastLinkJS script to deployscripts/")
val deployFull = taskKey[Unit]("Copies the fullLinkJS script to deployscripts/")

// Used by GitHub Actions to get the script out from the .gitignored target directory
deployFast := {
  val opt = (Compile / fastOptJS).value
  IO.copyFile(opt.data, new java.io.File("target/compiled.js"))
}

deployFull := {
  val opt = (Compile / fullOptJS).value
  IO.copyFile(opt.data, new java.io.File("target/compiled.js"))
}