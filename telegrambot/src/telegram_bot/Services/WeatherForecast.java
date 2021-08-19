package telegram_bot.Services;

import java.nio.charset.Charset;
import java.text.Normalizer;
import java.time.Instant;
//import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherForecast {
	
	public String retrieveWeatherForecastAsJson(String location) throws Exception {

		String local = removerAcentoseEspacosBrancos(location);
		
		//Descomentar caso deseje apenas a previsão do dia seguinte. Caso contrário será retornado previsão dos próximos 15 dias.

		//String tomorrowDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now().plusDays(1));
		//URIBuilder builder = new URIBuilder("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"+ local + "/" + tomorrowDate);
		URIBuilder builder = new URIBuilder("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"+ local + "/");

		builder.setParameter("contentType", "json")
			.setParameter("unitGroup", "metric")
			.setParameter("key", "96EA7VXNR53RA367ATFF874TY");

		HttpGet get = new HttpGet(builder.build());
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		CloseableHttpResponse response = httpclient.execute(get);    
		String jsonWeatherForecast = null;
		try {
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_BAD_REQUEST){
					return "Limite de requisições diarias de previsão do tempo atingida, por favor tente novamente mais tarde.";
				}
                return "Infelizmente ocorreu um erro genérico ao realizar a requisição.";
			}
			
			HttpEntity entity = response.getEntity();
		    if (entity != null) {		    	
		    	jsonWeatherForecast = EntityUtils.toString(entity, Charset.forName("utf-8"));
		    }
		    
		    
		} finally {
			response.close();
		}
		
		if (jsonWeatherForecast==null || jsonWeatherForecast.isBlank()) {
			return "Não foi encontrado a previsão de tempo para o local mencionado";
		}

		JSONObject timelineResponse = new JSONObject(jsonWeatherForecast);
		
		ZoneId zoneId=ZoneId.of(timelineResponse.getString("timezone"));
		
		String mensagemResposta = String.format("Previsão do tempo para: %s%n%n", timelineResponse.getString("resolvedAddress"));
		
		JSONArray values=timelineResponse.getJSONArray("days");
		
		
		for (int i = 0; i < values.length(); i++) {
			JSONObject dayValue = values.getJSONObject(i);
            
            ZonedDateTime datetime=ZonedDateTime.ofInstant(Instant.ofEpochSecond(dayValue.getLong("datetimeEpoch")), zoneId);
            
            double maxtemp=dayValue.getDouble("tempmax");
            double mintemp=dayValue.getDouble("tempmin");

            mensagemResposta += String.format("Data: %s%nTemperaturaMax: %.1f%nTemperaturaMin: %.1f%n", datetime.format(DateTimeFormatter.ISO_LOCAL_DATE), maxtemp, mintemp );

			mensagemResposta += String.format("%s%n%n%n", dayValue.getString("description"));
		}

        return mensagemResposta;
	}

	public static String removerAcentoseEspacosBrancos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replace(" ", "");
	}
}