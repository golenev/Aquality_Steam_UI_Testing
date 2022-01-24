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

}
