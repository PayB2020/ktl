import org.gis.controller.HealthCheckController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(HealthCheckController::class)
class MyTest {

//    @Autowired
//    private lateinit var mockMvc: MockMvc


    @Test
    fun myTest() {
//        mockMvc.perform(MockMvcRequestBuilders.post("/hi")).andExpect(status().isOk())
    }
}