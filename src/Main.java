import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

/**
 * Created by Vitaly on 28.05.17.
 */
public class Main {
    public static void main(String args[]) {
        ApiContextInitializer.init();
        TelegramBotsApi telApi = new TelegramBotsApi();
        Bot bot = new Bot();

        try {
            telApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }
}
