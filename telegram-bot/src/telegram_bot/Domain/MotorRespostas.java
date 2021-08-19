package telegram_bot.Domain;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

import telegram_bot.Services.WeatherForecast;

public class MotorRespostas {
	private Update update;
	private TelegramConversa conversa;
	private WeatherForecast weatherService;

	public MotorRespostas(Update update, TelegramConversa conversation, WeatherForecast weatherService) {
		this.update = update;
		this.conversa = conversation;
		this.weatherService = weatherService;

		setNome(update.getMessage().getFrom().getFirstName());
		setSobrenome(update.getMessage().getFrom().getLastName());
	}

	private String nome;
	private String sobrenome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	private String getNomeCompleto() {
		String nomeCompleto = getNome();
		if (getSobrenome() != null) {
			nomeCompleto += " " + getSobrenome();
		}
		return nomeCompleto;
	}

	public SendMessage answerMessage() {

		String respostaUsuario = update.getMessage().getText().toLowerCase();
		Long chatID = update.getMessage().getChatId();
		SendMessage message = new SendMessage();

		Pattern patternTudoBem = Pattern.compile("tudo bem");
		Matcher matcherTudoBem = patternTudoBem.matcher(respostaUsuario);

		if ((conversa.getStatus() == ConversaStatus.NOVA || conversa.getStatus() == ConversaStatus.COMPLETO)
				&& respostaUsuario.toLowerCase().contains("oi ")) {
			message.setText("Oi!");

			if (matcherTudoBem.find()) {
				message.setText(message.getText() + " Tudo bem e com você ?");
			}

			message.setChatId(chatID);
			return message;
		} else if ((conversa.getStatus() == ConversaStatus.NOVA || conversa.getStatus() == ConversaStatus.COMPLETO)
				&& matcherTudoBem.find()) {
			message.setText("Tudo bem e com você ?");
			message.setChatId(chatID);

			return message;
		} else if ((conversa.getStatus() == ConversaStatus.NOVA || conversa.getStatus() == ConversaStatus.COMPLETO)
				&& (respostaUsuario.contains("tbm") || respostaUsuario.contains("tambem")
						|| respostaUsuario.contains("tambem") || respostaUsuario.contains("estou")
						|| respostaUsuario.contains("também"))) {
			message.setText("<3");
			message.setChatId(chatID);

			return message;
		} else if ((conversa.getStatus() == ConversaStatus.NOVA || conversa.getStatus() == ConversaStatus.COMPLETO)
				&& respostaUsuario.toLowerCase().equals("oi")) {
			message.setText("Oi!");
			message.setChatId(chatID);

			return message;
		}

		if ((conversa.getStatus() == ConversaStatus.NOVA || conversa.getStatus() == ConversaStatus.COMPLETO)
				&& (respostaUsuario.contains("/previsao"))) {

			conversa.setStatus(ConversaStatus.PREVISAO_REQUISITADA);

			message.setReplyMarkup(RespostaKeyboard.getYesNoKeyboard());

			message.setText("Você gostaria de saber qual é a previsão do tempo ? Ex: São Paulo");
			message.setChatId(chatID);
			return message;
		}

		if (conversa.getStatus() == ConversaStatus.PREVISAO_REQUISITADA && respostaUsuario.contains("sim")) {
			conversa.setStatus(ConversaStatus.ESPERANDO_LOCAL);
			message.setText("De qual local você gostaria de saber a previsão do tempo ?");
			message.setChatId(chatID);
			return message;
		} else if (conversa.getStatus() == ConversaStatus.PREVISAO_REQUISITADA && respostaUsuario.contains("nao")) {
			conversa.setStatus(ConversaStatus.COMPLETO);
			message.setText("pq faz issu cmg :(");
			message.setChatId(chatID);
			return message;
		}

		if ((conversa.getStatus() == ConversaStatus.ESPERANDO_LOCAL)) {

			conversa.setStatus(ConversaStatus.COMPLETO);

			String resposta = "";
			try {
				resposta = this.weatherService.retrieveWeatherForecastAsJson(respostaUsuario);
			} catch (Exception e) {
				resposta = "Não consegui recuperar a previsão do tempo para (" + respostaUsuario + ")... :(";
			}

			message.setText(resposta);
			message.setChatId(chatID);
			return message;
		}

		if (respostaUsuario.equals("/saudacao")) {
			Calendar cal = Calendar.getInstance();
			int hora = cal.get(Calendar.HOUR_OF_DAY);

			String retorno = "";
			if (hora < 12) {
				retorno = "Bom dia ";
			} else if (hora >= 12 && hora < 18) {
				retorno = "Boa tarde ";
			} else {
				retorno = "Boa noite ";
			}
			message.setText(retorno + getNomeCompleto());
			message.setChatId(chatID);

			return message;
		}

		if (respostaUsuario.equals("/help")) {
			message.setText("Comandos disponiveis:\n1 - /saudacao\n2 - /previsao\n3 - /meunome\n4 - /meusobrenome\n5 - /meunomecompleto");
			message.setChatId(chatID);

			return message;
		}
		

		if (respostaUsuario.equals("/meunome")) {
			message.setText(getNome());
			message.setChatId(chatID);

			return message;
		}

		if (respostaUsuario.equals("/meusobrenome")) {
			message.setText(getSobrenome());
			message.setChatId(chatID);

			return message;
		}

		if (respostaUsuario.equals("/meunomecompleto")) {
			message.setText(getNomeCompleto());
			message.setChatId(chatID);
			return message;
		}

		if (respostaUsuario.equals("/yametekudasai")) {
			message.setText(getNomeCompleto());
			message.setChatId(chatID);
			return message;
		}

		message.setText("Desculpe, " + getNome() + "-kun!");
		message.setChatId(chatID);
		return message;

	}
}