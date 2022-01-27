package pageobjects;

import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import helpers.RegExHelper;
import org.openqa.selenium.By;

public class AboutSteamPage extends Form {

    private ITextBox txtInGame = getElementFactory().getTextBox(By.xpath("(//div[@class='online_stat'])[2]"), "счётчик Всего игроков");
    private ITextBox txtOnliners = getElementFactory().getTextBox(By.xpath("(//div[@class='online_stat'])[1]"), "счётсик игроков Онлайн");

    public AboutSteamPage() {
        super(By.xpath("//div[@class='about_subtitle']"), "Описание About Steam");
    }

    public int onlinersCount(){
        String onlinersText = txtOnliners.getText();
        return RegExHelper.getNumFromString(onlinersText);
    }

    public int inGameCount(){
        String inGameText = txtInGame.getText();
        return RegExHelper.getNumFromString(inGameText);
    }

}
