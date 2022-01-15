package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import main.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

public class SalesLeadersPage extends Form {

    private ICheckBox chkbxOs = getElementFactory().getCheckBox(By.xpath("//span[contains(text(),'SteamOS + Linux')]"), "чекбокс Линукс");
    private IComboBox comboxNumberOfPlayers = getElementFactory().getComboBox(By.xpath("//div[@data-collapse-name='category3']"), "Количество игроков");
    private ICheckBox chkbxInsideNumberOfPlayers = getElementFactory().getCheckBox(By.xpath("//span[contains(text(),'" + Config.get("checkBoxInsideNumbersOfPlayesr") + "')]"), "чекбокс кооператив лан");
    private IComboBox comBoxLabels = getElementFactory().getComboBox(By.xpath("//div[contains(text(),'" + Config.get("NarrowByTag") + "')]"), "tags");
    private ICheckBox checkBoxInsideLabels = getElementFactory().getCheckBox(By.xpath("(//span[@class='tab_filter_control_label'][contains(text(),'" + Config.get("checkBoxInsideLabels") + "')])[1]"), "чекбокс Action");
    private ITextBox firstSearchResult = getElementFactory().getTextBox(By.xpath("//div[@id='search_resultsRows']//a[1]"), "первый результат поиска");
    private ITextBox textReleaseDate = getElementFactory().getTextBox(By.xpath("//div[@class='date']"), "date of release");
    private ITextBox textGamePrice = getElementFactory().getTextBox(By.xpath("//div[@class='game_purchase_action']//div[@class='game_purchase_price price']"), "price of game");
    private ITextBox textGameNameFromSearch = getElementFactory().getTextBox(By.xpath("//div[@id='appHubAppName']"), "Game Name");
    private IButton btnShowAllTags = getElementFactory().getButton(By.cssSelector("a[onclick=\"ExpandOptions(this, 'TagFilter_Container'); return false;\"]"), "показать все метки");

    /**
     * Constructor with parameters
     *
     * @param locator
     * @param name
     */
    public SalesLeadersPage(By locator, String name) {
        super(locator, name);
    }

    public SalesLeadersPage() {
        super(By.cssSelector("//span[contains(text(),'SteamOS + Linux')]"), "pageHeader");
    }

    public void selectCheckBoxOS() {
        chkbxOs.check();

    }

    public void selectCheckBoxNumberOfPlayers() {
        comboxNumberOfPlayers.click();
        chkbxInsideNumberOfPlayers.check();
    }

    public void comBoxLabelsClick() {

        btnShowAllTags.click();

        checkBoxInsideLabels.check();
    }

    public String getInfoAboutGame() {
        String result = firstSearchResult.getText();
        String newResult[] = result.split("\n");
        String finalResult = newResult[0] + " " + newResult[1];
        return finalResult;

    }

    public void clickFirstSearchResult() {
        firstSearchResult.click();
    }

    public String buildInfoAboutGameToCompare() {
        return textGameNameFromSearch.getText() + " " + textReleaseDate.getText() + " " + textGamePrice.getText();
    }


}
