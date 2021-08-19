package telegram_bot.Domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TelegramConversas {

	public List<TelegramConversa> conversations = new ArrayList<>();

	public List<TelegramConversa> conversations() {
		return conversations;
	}

	public TelegramConversas() {
	}

	public TelegramConversa getConversaByCharId(Long chatId) {
		TelegramConversa result = conversations.stream().filter(conversation -> conversation.getChatId().equals(chatId))
				.findAny().orElse(new TelegramConversa(chatId, ConversaStatus.NOVA, LocalDateTime.now()));

		if (ChronoUnit.MINUTES.between(result.getLastConversationTime(), LocalDateTime.now()) >= 1) {
			result.setStatus(ConversaStatus.NOVA);
		}
		result.setLastConversationTime(LocalDateTime.now());
		return result;
	}

	public void addConversaIfNotExist(TelegramConversa newConversation) {
		if (conversations.stream().filter(conversation -> conversation.getChatId().equals(newConversation.getChatId()))
				.count() == 0) {
			conversations.add(newConversation);
		}
	}

}
