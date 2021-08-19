package telegram_bot.Domain;

import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class RespostaKeyboard {
	public static ReplyKeyboardMarkup getYesNoKeyboard() {

		ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
		replyKeyboardMarkup.setSelective(true);
		replyKeyboardMarkup.setResizeKeyboard(true);
		replyKeyboardMarkup.setOneTimeKeyboard(true);

		List<KeyboardRow> keyboard = new ArrayList<>();

		KeyboardRow keyboardFirstRow = new KeyboardRow();

		keyboardFirstRow.add("Sim");
		keyboardFirstRow.add("Nao");

		keyboard.add(keyboardFirstRow);

		replyKeyboardMarkup.setKeyboard(keyboard);
		return replyKeyboardMarkup;
	}

	public static void inlineBlock() {

	}

}
