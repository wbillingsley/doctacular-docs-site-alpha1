import mill._, scalajslib._, scalalib._
import coursier.maven.MavenRepository

object millsite extends ScalaJSModule {
    def scalaVersion = "3.1.0"
    def scalaJSVersion = "1.7.1"

    def repositoriesTask = T.task { super.repositoriesTask() ++ Seq(
      MavenRepository("https://jitpack.io")
    ) }

    def ivyDeps = Agg(
        ivy"com.github.wbillingsley.veautiful::doctacular::v0.2-SNAPSHOT"
    )
}