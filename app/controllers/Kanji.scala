package controllers

import play._
import play.mvc._
import play.db.jpa.QueryOn

import models._

object Kanji extends Controller {
    
    def search(query : String, page : Int = 0, items : Int = 10) {
      if (query == null) {
	 render()
      } else {
	 render("kanjis" -> models.Kanji.findByKeyword(query+"%").from(page).fetch(items), query)
      }
    }
    
    def view(id : Long) {
      QueryOn[Kanji].findById(id) match {
            case Some(x) => render("kanji" -> x)
            case None => render()
      }
    }
    
}
