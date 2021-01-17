package com.augen.test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.augen.augen.controller.BuyController;
import com.augen.augen.model.BuyingConfirmKeys;
import com.augen.constant.CommonConstant;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(classes = BuyController.class)
public class BuyControllerTest extends BaseTest {
	
	@Autowired
	private BuyController buyController;
	
    @BeforeEach
    public void init() {
    	assertThat(buyController).isNotNull();
    }

    // @Test
	public void shouldReturnCorrectCost() throws Exception {
    	ObjectMapper mapper = new ObjectMapper();
    	BuyingConfirmKeys body = new BuyingConfirmKeys(1, 2, -1); // Train, Sep => 7.5
    	RequestBuilder builder = MockMvcRequestBuilders.post("/adjustcost").contentType(
                MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(body));
                
    	ResultActions resultAction = mockMvc.perform(builder);
    	MvcResult mvcResult = resultAction.andReturn();
    	String resBody = mvcResult.getResponse().getContentAsString();
    	Assertions.assertEquals("7.5", resBody);
    }
	
	@Test
	public void shouldReturnDefaultMessageSPLIT() throws Exception {
		RequestBuilder builder = MockMvcRequestBuilders.get("/initUT"); // .param("name", name);

		try {
			mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

			ResultActions resultAction = mockMvc.perform(builder);
			MvcResult mvcResult = resultAction.andReturn();
			String resBody = mvcResult.getResponse().getContentAsString();
			Assertions.assertEquals(resBody, CommonConstant.SPLIT);
			
		} catch (Exception e) {
			Assertions.fail("Failed by:" + e.getMessage());
		}

	}
	
}
