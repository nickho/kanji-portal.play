package models

import java.util._
import javax.persistence._
 
import play.db.jpa._
 
@Entity
class ReferenceType(
    var code: String,
    var name: String,
    var description: String
) extends Model {
    def this() = this(null, null, null)
}