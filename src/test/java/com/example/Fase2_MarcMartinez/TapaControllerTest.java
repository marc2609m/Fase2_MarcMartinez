package com.example.Fase2_MarcMartinez;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.controller.TapaController;
import com.example.dao.TapaDAO;
import com.example.entity.Tapa;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers=TapaController.class)
public class TapaControllerTest {
	
	@Autowired
	private MockMvc miniPostman;
	
	@MockBean
	private TapaDAO Tapadao;
	
	private Tapa tapa1;
	private Tapa tapa2;
	
	@BeforeEach
    void init() {
        initObjects();
    }
	
	private void initObjects() {
		tapa1 = new Tapa();
        tapa1.setId(1L);
        tapa1.setNombre("Bravas");
        tapa1.setDescripcion("Patatas bravas con salsa picante");
        tapa1.setPrecio(3.5);
        tapa1.setTipo("Entrante");
        tapa1.setEnCarta(true);

        tapa2 = new Tapa();
        tapa2.setId(2L);
        tapa2.setNombre("Tortilla");
        tapa2.setDescripcion("Tortilla de patatas");
        tapa2.setPrecio(2.5);
        tapa2.setTipo("Plato principal");
        tapa2.setEnCarta(false);
	}
	
	@Test
    void pedimos_todas_las_tapas() throws Exception {
        // Arrange
        List<Tapa> tapas = Arrays.asList(tapa1, tapa2);
        when(Tapadao.getAll()).thenReturn(tapas);

        ObjectMapper objectMapper = new ObjectMapper();
        String respuestaEsperada = objectMapper.writeValueAsString(tapas);

        // Act
        MvcResult respuesta = miniPostman.perform(get("/getAll").contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = respuesta.getResponse().getContentAsString();

        // Assert
        assertThat(responseBody).isEqualToIgnoringWhitespace(respuestaEsperada);
    }

	
}
