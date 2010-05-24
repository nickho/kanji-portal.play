package models

import java.util._
import javax.persistence._
 
import play.db.jpa._
 
@Entity
class Language(
    var codeIso63901: String,
    var codeIso63902: String,
    var description: String
) extends Model {
    def this() = this(null, null, null)
}