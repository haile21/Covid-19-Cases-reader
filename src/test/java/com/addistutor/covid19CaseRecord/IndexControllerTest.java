package com.addistutor.covid19CaseRecord;

//import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.addistutor.covid19CaseRecord.controller.IndexController;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class IndexControllerTest {
	
	@Autowired 
	private MockMvc mockMvc;
	
	private IndexController ic;
	
	@Before
	public void setup() {
		ic= new IndexController();
		mockMvc=MockMvcBuilders.standaloneSetup(ic).build();
	}

	@Test
	public void indexTest() throws Exception {
		
		mockMvc.perform(get("/covid19")).andExpect(status().isOk()).andExpect(view().name("index"));
		
	}

}
