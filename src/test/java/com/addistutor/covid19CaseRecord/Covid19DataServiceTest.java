package com.addistutor.covid19CaseRecord;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.Assert.*;				
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.addistutor.covid19CaseRecord.model.CaseLocation;
import com.addistutor.covid19CaseRecord.services.Covid19DataService;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Covid19CaseRecordApplication.class)
public class Covid19DataServiceTest {

 	@Autowired
	@MockBean
	Covid19DataService dataservice;;

	@Test
	public void getAllcasesTest() throws IOException, InterruptedException {
		when(dataservice.getAllcases()).thenReturn( Stream.of(new CaseLocation("LA","USA","34.052235","-118.243683",2200,200)).collect(Collectors.toList()));		
		//dataservice.fetchData();
		assertEquals(1, dataservice.getAllcases().size());
	}

}
