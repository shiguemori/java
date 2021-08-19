package telegram_bot;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import telegram_bot.Domain.MotorRespostas;
import telegram_bot.Domain.TelegramConversa;
import telegram_bot.Domain.TelegramConversas;
import telegram_bot.Services.WeatherForecast;

public class HinataBot extends TelegramLongPollingBot {

	public HinataBot(){

	}

	private WeatherForecast weatherForecast;
	private TelegramConversas telegramConversas;
	private MotorRespostas motorResposta;

	public HinataBot(WeatherForecast weatherForecast, TelegramConversas telegramConversas){
		this.weatherForecast = weatherForecast;
		this.telegramConversas = telegramConversas;
	}

	
	public String getBotUsername() {
		return "HinataBot";
	}

	public String getBotToken() {
		return "1743022277:AAFkVL6e951PlIldR67vvtNQXZyvhclpGJ4";
	}

	public void onUpdateReceived(Update update) {

		if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }

		TelegramConversa conversa = telegramConversas.getConversaByCharId(update.getMessage().getChatId());

		motorResposta = new MotorRespostas(update, conversa, this.weatherForecast);

		telegramConversas.addConversaIfNotExist(conversa);

		try {
			execute(motorResposta.answerMessage());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

}
