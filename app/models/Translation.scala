package models

import java.util.{TreeSet,Set=>JSet}
import javax.persistence._

import play.db.jpa._
 
@Entity
class Translation(
    var pos : String,
    var posDetail : String,
    var description : String,
    var detail : String,
    var note : String,
    @ManyToOne(cascade=Array(CascadeType.ALL))
    var dictionary : Dictionary,
    @ManyToOne(cascade=Array(CascadeType.ALL))
    var language : Language
) extends Model {
    def this() = this(null, null, null, null, null, null, null) 
}

object Translation extends QueryOn[Translation]
