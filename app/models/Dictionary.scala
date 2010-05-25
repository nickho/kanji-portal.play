package models

import java.util.{TreeSet,Set=>JSet}
import javax.persistence._

import play.db.jpa._
 
@Entity
class Dictionary(
    var romaji : String,
    var kanji : String,
    var kana : String
) extends Model {
    def this() = this(null, null, null)
      
    @ManyToMany(cascade=Array(CascadeType.PERSIST))
    var tags: JSet[Tag] = new TreeSet[Tag]
    
    @OneToMany(cascade=Array(CascadeType.ALL), mappedBy="dictionary")
    var translations : JSet[Translation] = new TreeSet[Translation]
    
}

object Dictionary extends QueryOn[Dictionary] {
  def findByKeyword(keyword : String) = {
    find("select d from Dictionary d join d.translations t where d.romaji like :kw or d.kana like :kw or d.kanji like :kw or t.description like :kw or t.detail like :kw or t.note like :kw", Map("kw" -> keyword)) 
  }
}

