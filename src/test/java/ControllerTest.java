
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/app-ctx.xml"})
@WebAppConfiguration
@FixMethodOrder
public class ControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void set() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void allTest() throws Exception {
        mockMvc.perform(get("/car/all")).andExpect(status().is2xxSuccessful()).andDo(print());
    }

    @Test
    public void addCar() throws Exception {
        mockMvc.perform(post("/car/add")
                        .param("brand", "SuperBrand")
                        .param("capacity", "123")
                        .param("price", "123456789")
                        .param("model", "SuperModel")
                        .param("speedMax", "100"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void findByBrand() throws Exception {
        System.out.println(
                mockMvc.perform(
                                get("/car/findByBrand")
                                        .param("brand", "SuperBrand"))
                        .andExpect(status().is2xxSuccessful())
                        .andReturn().getModelAndView().getModel().get("cars"));
    }

    @Test
    public void findByBrandAndModelAndSpeedMax() throws Exception {
        System.out.println(
                mockMvc.perform(get("/car/findByBrandAndModelAndSpeedMax")
                        .param("brand", "SuperBrand")
                        .param("model", "SuperModel")
                        .param("speedMax", "100")
                )
                        .andExpect(status().is2xxSuccessful())
                        .andReturn().getModelAndView().getModel().get("cars")
        );
    }
    /// Test for id
//    @Test
//    public void removeById()throws Exception{
//        mockMvc.perform(get("/car/removeById").param("id","1"));
//   }

    @Test(timeout = 1000L)
    public void removeAllByBrand() throws Exception{
        mockMvc.perform(get("/car/removeAllByBrand").param("brand","SuperBrand"))
                .andExpect(status().is3xxRedirection());
    }
}
