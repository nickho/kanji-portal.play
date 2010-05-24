package models

import java.util.{TreeSet,Set=>JSet}
import javax.persistence._
 
import play.db.jpa._
 
@Entity
class Spelling(
    var romaji: String,
    var kana: String,
    @ManyToOne var spelType: SpellingType
) extends Model {
    def this() = this(null, null, null)
    
    @ManyToMany(cascade=Array(CascadeType.PERSIST))
    var meanings: JSet[Meaning] = new TreeSet[Meaning]
    
}