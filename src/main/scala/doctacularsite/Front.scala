package doctacularsite

import com.wbillingsley.veautiful._
import com.wbillingsley.veautiful.html._
import com.wbillingsley.veautiful.doctacular._
import org.scalajs.dom

val frontPage = Unique(<.div(
  <.div(^.cls := Styles.imageCard.className,
    <("img")(^.src := "doctacular.svg"),
    <.p(
        "Doctacular! Doctacular!", <("br")(),
        "Teach 'em your vernacular!", <("br")(),
        "Instruction most oracular,", <("br")(),
        "To keep 'em coming backular."
    )
  ),
  markdown.Fixed("""
  |# What is Doctacular?
  |
  |Doctacular is a static site system for education and interactive documentation. 
  |It makes it quick and easy to write and self-publish courses, so they can be hosted on GitHub Pages or any webserver.
  """.stripMargin)
))