package fintech.homework08
import java.sql.DriverManager
import java.time.LocalDate
import org.scalatest.{FlatSpec, Matchers}
import fintech.homework08.PeopleApp.{readPerson, uri}

class SortingSpec extends FlatSpec with Matchers {
  "map" should "call a function once" in {
    var calls = 0
    DBRes(_ => "").map(_ => calls += 1).execute("jdbc:h2:~/test")
    calls shouldBe 1
  }

  "flatMap" should "call a function once" in {
    var calls = 0
    DBRes(_ => "").flatMap(_ => {
      calls += 1
      DBRes(_ => "")
    }).execute("jdbc:h2:~/test")
    calls shouldBe 1
  }
}
