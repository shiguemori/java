package telegram_bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import telegram_bot.Domain.TelegramConversas;
import telegram_bot.Services.WeatherForecast;

public class Main {	

	public static void main(String[] args) {	

		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new HinataBot(new WeatherForecast(), new TelegramConversas()));

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}
}
