package common;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

public class OTPReader {
	public static String getOtpFromEmail(String host, String storeType, String user, String password) {
		try {
			// Set mail properties
			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");

			// Get session
			Session emailSession = Session.getDefaultInstance(properties);
			Store store = emailSession.getStore("imaps");
			store.connect(host, user, password);

			// Open inbox folder
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// Get messages
			Message[] messages = emailFolder.getMessages();
			for (int i = messages.length - 1; i >= 0; i--) {
				Message message = messages[i];
				if (!message.isSet(Flags.Flag.SEEN)) {
					String content = getTextFromMessage(message);

					// Match 6-digit OTP
					Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
					Matcher matcher = pattern.matcher(content);
					if (matcher.find()) {
						return matcher.group();
					}
				}
			}

			emailFolder.close(false);
			store.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getTextFromMessage(Message message) throws Exception {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = mimeMultipart.getBodyPart(0).getContent().toString();
		}
		return result;
	}
}
