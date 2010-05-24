package models

import java.util.{TreeSet,Set=>JSet}
import javax.persistence._

import play.db.jpa._
 
@Entity
class Kanji(
    var kanji: String,
    var description: String
) extends Model {
    def this() = this(null, null)
    
    @ManyToMany(cascade=Array(CascadeType.PERSIST))
    var meanings: JSet[Meaning] = new TreeSet[Meaning]
    
    @ManyToMany(cascade=Array(CascadeType.ALL))
    var spellings: JSet[Spelling] = new TreeSet[Spelling]
    
    @ManyToMany(cascade=Array(CascadeType.PERSIST))
    var tags: JSet[Tag] = new TreeSet[Tag]
    
    @ManyToMany(cascade=Array(CascadeType.ALL))
    var references : JSet[Reference] = new TreeSet[Reference]
    
}

object Kanji extends QueryOn[Kanji] {
  def findByKeyword(keyword : String) = {
    find("select k from Kanji k join k.meanings m where k.description like :kw or m.meaning like :kw", Map("kw" -> keyword)) 
  }
}

