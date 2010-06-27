package models

import java.util._
import javax.persistence._
 
import play.db.jpa._
 
/*@Indexed*/
@Entity
class Meaning(
    /*@Field*/ var meaning: String,
    var description: String,
    @ManyToOne var language : Language
) extends Model {
    def this() = this(null, null, null)
}
