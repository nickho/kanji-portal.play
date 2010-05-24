import play._
import play.jobs._
import play.test._
import play.db.jpa.QueryOn
 
import models._;
 
@OnApplicationStart
class Bootstrap extends Job {
 
  override def doJob() = if (QueryOn[Kanji].count == 0) Fixtures.load("data.yml")
 
}