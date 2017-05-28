import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Vitaly on 28.05.17.
 */
public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getFrom().getFirstName() + ": " + update.getMessage().getText());
        SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
        message.setText("Hello " + update.getMessage().getFrom().getFirstName() + "\n" + update.getMessage().getText());

        try {
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        Properties prop = new Properties();
        InputStream input = null;
        String token = "";

        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            token = prop.getProperty("token");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return token;
    }
}
