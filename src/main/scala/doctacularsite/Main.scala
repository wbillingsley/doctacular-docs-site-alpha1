package doctacularsite

import com.wbillingsley.veautiful.html._
import com.wbillingsley.veautiful.doctacular._
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSImport("marked", "marked")
object Marked extends js.Object:
  def parse(s:String):String = js.native

given markdown:Markup = new Markup({ (s:String) => Marked.parse(s).asInstanceOf[String] })

/** The doctacular site */
val site = Site()

@main def loadSite(): Unit = {
  val n = dom.document.getElementById("render-here")
  n.innerHTML = ""

  site.toc = site.Toc(
    "Home" -> site.HomeRoute,
  )
  site.home = () => site.renderPage(frontPage)
  Styles.installStyles()
  site.attachTo(n)
}

