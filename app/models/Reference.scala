package models

import java.util._
import javax.persistence._
 
import play.db.jpa._
 
@Entity
class Reference (
    var value: String,
    @ManyToOne var refType: ReferenceType
) extends Model {
    def this() = this(null, null)
}