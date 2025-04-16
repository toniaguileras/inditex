package toni.aguilera.inditex.infraestructure.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import toni.aguilera.inditex.infraestructure.IntegrationTestBase;

import java.nio.file.Files;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
public class GetProductsShould extends IntegrationTestBase {

    @Autowired
    private MockMvc mockMvc;

    //10:00, dia 14, producto 35455, brand 1
    @Test
    void should_return_get_for_environment_1() throws Exception {
        LocalDateTime time = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/v1/prices")
                        .param("applicationDate", time.toString())
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(jsonFrom("response_1.json")));

    }

    //16:00, dia 14, producto 35455, brand 1
    @Test
    void should_return_get_for_environment_2() throws Exception {
        LocalDateTime time = LocalDateTime.of(2020, 6, 14, 16, 0);
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/v1/prices")
                        .param("applicationDate", time.toString())
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(jsonFrom("response_2.json")));

    }

    //21:00, dia 14, producto 35455, brandId 1
    @Test
    void should_return_get_for_environment_3() throws Exception {
        LocalDateTime time = LocalDateTime.of(2020, 6, 14, 21, 0);
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/v1/prices")
                        .param("applicationDate", time.toString())
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(jsonFrom("response_3.json")));

    }

    //10:00, dia 15, producto 35455, brandId 1
    @Test
    void should_return_get_for_environment_4() throws Exception {
        LocalDateTime time = LocalDateTime.of(2020, 6, 15, 10, 0);
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/v1/prices")
                        .param("applicationDate", time.toString())
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(jsonFrom("response_4.json")));

    }

    //21:00, dia 16, producto 35455, brandId 1
    @Test
    void should_return_get_for_environment_5() throws Exception {
        LocalDateTime time = LocalDateTime.of(2020, 6, 16, 21, 0);
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/v1/prices")
                        .param("applicationDate", time.toString())
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(jsonFrom("response_5.json")));

    }

    @Test
    void should_fail_when_there_is_no_products() throws Exception {
        LocalDateTime time = LocalDateTime.of(2024, 6, 16, 21, 0);
        int productId = 1111;
        int brandId = 2;

        mockMvc.perform(get("/v1/prices")
                        .param("applicationDate", time.toString())
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    private String jsonFrom(String fileName) throws Exception {
        ClassPathResource resource = new ClassPathResource(fileName);
        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }
}
