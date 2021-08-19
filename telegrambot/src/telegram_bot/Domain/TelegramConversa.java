package telegram_bot.Domain;

import java.time.LocalDateTime;

public class TelegramConversa {
	Long chatId;
	ConversaStatus status;
	LocalDateTime lastConversationTime;

	public TelegramConversa(Long chatId, ConversaStatus status, LocalDateTime lastConversationTime) {
		this.chatId = chatId;
		this.status = status;
		this.lastConversationTime = lastConversationTime;
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	public ConversaStatus getStatus() {
		return status;
	}

	public void setStatus(ConversaStatus status) {
		this.status = status;
	}

	public LocalDateTime getLastConversationTime() {
		return lastConversationTime;
	}

	public void setLastConversationTime(LocalDateTime lastConversationTime) {
		this.lastConversationTime = lastConversationTime;
	}
}
