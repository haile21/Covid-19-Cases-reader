package com.addistutor.covid19CaseRecord.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.addistutor.covid19CaseRecord.model.CaseLocation;

import jakarta.annotation.PostConstruct;

@Service
public class Covid19DataService {
	private static String DATA_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private List<CaseLocation> allcases= new ArrayList<>();
	
	 
	public List<CaseLocation> getAllcases() {
		return allcases;
	}
	 
	@PostConstruct //tells spring to execute this method when the application starts 
	@Scheduled(cron="* * 1 * * *") //run every day at 1 oclock
	public void fetchData() throws IOException, InterruptedException {
		List<CaseLocation> newcases= new ArrayList<>();

		HttpClient hcleint = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(DATA_URL)).build();
		HttpResponse<String> response= hcleint.send(request, HttpResponse.BodyHandlers.ofString());
		
		StringReader csvReader= new StringReader(response.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
		for (CSVRecord record : records) {
			CaseLocation cl = new CaseLocation(); 
			cl.setState(record.get("Province/State"));
			cl.setCountry(record.get("Country/Region"));
			cl.setCountry(record.get("Lat"));
			cl.setCountry(record.get("Long"));
<<<<<<< Updated upstream

=======
			
>>>>>>> Stashed changes
			int latestTotal=Integer.parseInt(record.get(record.size() -1));
			int prevDayTotal=Integer.parseInt(record.get(record.size() -2));

			cl.setRecent_total_Case(latestTotal);
			cl.setDiff(latestTotal-prevDayTotal);
			
			newcases.add(cl);
			
		    //String state = record.get("Province/State");
		    //System.out.println(state);
		    //String customerNo = record.get("CustomerNo");
		    //String name = record.get("Name");
		}
		this.allcases= newcases;
 	}

}
 