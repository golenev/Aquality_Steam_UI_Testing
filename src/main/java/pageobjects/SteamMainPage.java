package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import helpers.RegExHelper;
import helpers.ConfigProperties;
import org.openqa.selenium.By;

public class SteamMainPage extends Form {
    private ILabel lblLogoHolder = getElementFactory().getLabel(By.xpath("//span[@id='logo_holder']//a//img"), "уникальный элемент лого");
    private IButton btnAbout = getElementFactory().getButton(By.xpath("//a[contains(text(),'ABOUT')]"), "кнопка ABOUT");
    private ITextBox txtInGame = getElementFactory().getTextBox(By.xpath("(//div[@class='online_stat'])[2]"), "счётчик Всего игроков");
    private ITextBox txtOnliners = getElementFactory().getTextBox(By.xpath("(//div[@class='online_stat'])[1]"), "счётсик игроков Онлайн");
    private IComboBox dropdownNewAndRemarkable = getElementFactory().getComboBox(By.cssSelector("#noteworthy_tab"), "Новое и примечательное");
    private IButton btnSalesLeaders = getElementFactory().getButton(By.cssSelector("div[id='noteworthy_flyout'] a:nth-child(1)"), "лидеры продаж");
    private IButton btnCommunity = getElementFactory().getButton(By.xpath("//a[contains(text(),'" + ConfigProperties.get("btnNavBar") + "')]"), "Сообщество");
    private IButton btnMarket = getElementFactory().getButton(By.xpath("//div[@class='supernav_content']//a[@class='submenuitem'][normalize-space()='"+ ConfigProperties.get("btnInsideCommunity")+"']"), "кнопка Маркет");


    public SteamMainPage() {
        super(By.xpath("//span[@id='logo_holder']//a//img"), "уникальный элемент Лого");
    }

    public void btnAboutClick() {
        btnAbout.click();
    }

    public boolean isOnlineMoreThanInGame() {
        String onlinersText = txtOnliners.getText();
        String inGameText = txtInGame.getText();
        RegExHelper.getNumFromString(onlinersText);
        RegExHelper.getNumFromString(inGameText);
        if (RegExHelper.getNumFromString(onlinersText) > RegExHelper.getNumFromString(inGameText))
            return true;
        return false;
    }

    public void btnStoreClick() {
        lblLogoHolder.click();
    }

    public void comboBoxNewAndRemarkableHover() {
        dropdownNewAndRemarkable.getJsActions().hoverMouse();
        btnSalesLeaders.click();
    }
    public void goToMarket (){
        btnCommunity.getJsActions().hoverMouse();
        btnMarket.click();
    }
    public boolean isMainPageOpen(){
       return lblLogoHolder.state().isDisplayed();
    }

}
