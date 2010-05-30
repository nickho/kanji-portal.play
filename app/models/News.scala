package models

import java.util._
import javax.persistence._

import play.db.jpa._
 
/*@Indexed*/
@Entity
class News(
    var description: String,
    var publicationDate: Date,
    var author: String,
    @ManyToOne var language : Language
) extends Model {
    def this() = this(null, null, null, null)
}

