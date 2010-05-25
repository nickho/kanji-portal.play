package controllers

import play._
import play.mvc._
import play.db.jpa.QueryOn

import models._

object Dictionary extends Controller {
    
    def search(query : String, page : Int = 0, items : Int = 10) {
      if (query == null) {
	 render()
      } else {
	 render("entries" -> models.Dictionary.findByKeyword(query+"%").from(page).fetch(items), query)
      }
    }
    
    def view(id : Long) {
      models.Dictionary.findById(id) match {
            case Some(x) => render("entry" -> x)
            case None => render()
      }
    }
}
