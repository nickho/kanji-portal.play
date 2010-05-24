package models

import java.util._
import javax.persistence._
 
import play.db.jpa._
 
@Entity
class Meaning(
    var meaning: String,
    var description: String,
    @ManyToOne var language : Language
) extends Model {
    def this() = this(null, null, null)
}