package telegram_bot;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import telegram_bot.Domain.MotorRespostas;
import telegram_bot.Domain.TelegramConversa;
import telegram_bot.Domain.TelegramConversas;

public class HinataBot extends TelegramLongPollingBot {

	public HinataBot(){

	}

//	private WeatherForecast weatherForecast;
	private TelegramConversas telegramConversas;

	public HinataBot(
//			WeatherForecast weatherForecast,
			TelegramConversas telegramConversas
	){
//		this.weatherForecast = weatherForecast;
		this.telegramConversas = telegramConversas;
	}

	public String getBotUsername() {
		return "HinataBot";
	}

	public String getBotToken() {
		return "TokenKey";
	}

	public void onUpdateReceived(Update update) {

		if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }

		TelegramConversa conversa = telegramConversas.getConversaByCharId(update.getMessage().getChatId());

		MotorRespostas motorResposta = new MotorRespostas(update, conversa);
//		motorResposta = new MotorRespostas(update, conversa, this.weatherForecast);

		telegramConversas.addConversaIfNotExist(conversa);

		try {
			execute(motorResposta.answerMessage());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

}
