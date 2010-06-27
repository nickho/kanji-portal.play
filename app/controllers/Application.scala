package controllers

import play._
import play.mvc._
import play.db.jpa.QueryOn
import play.i18n.Lang

import models._

object Application extends Controller {
    
    def index = render("news" -> QueryOn[News].find("language.codeIso63901 = ?", Lang.get()).fetch)
    
}
