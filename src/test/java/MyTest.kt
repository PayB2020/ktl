import org.gis.controller.HealthCheckController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest

@WebMvcTest(HealthCheckController::class)
class MyTest {

    @Autowired
    private lateinit var mockMvc: MockMvc


    @Test
    fun myTest() {

    }
}