package pageobjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import helpers.ConfigProperties;
import helpers.RegExHelper;
import org.openqa.selenium.By;

public class SalesLeadersPage extends Form {

    private ICheckBox chkbxOs = getElementFactory().getCheckBox(By.xpath("//span[@data-value='linux']//span//span[@class='tab_filter_control_checkbox']"), "чекбокс Линукс");
    private IComboBox comboxNumberOfPlayers = getElementFactory().getComboBox(By.xpath("//div[@data-collapse-name='category3']"), "Количество игроков");
    private ICheckBox chkbxInsideNumberOfPlayers = getElementFactory().getCheckBox(By.xpath("//span[contains(text(),'" + ConfigProperties.get("checkBoxInsideNumbersOfPlayesr") + "')]"), "чекбокс кооператив лан");
    private IComboBox comBoxLabels = getElementFactory().getComboBox(By.xpath("//div[contains(text(),'" + ConfigProperties.get("NarrowByTag") + "')]"), "tags");
    private ICheckBox checkBoxInsideLabels = getElementFactory().getCheckBox(By.xpath("(//span[@class='tab_filter_control_label'][contains(text(),'" + ConfigProperties.get("checkBoxInsideLabels") + "')])[1]"), "чекбокс Action");
    private ITextBox firstSearchResult = getElementFactory().getTextBox(By.xpath("//div[@id='search_resultsRows']//a[1]"), "первый результат поиска");
    private ITextBox textReleaseDate = getElementFactory().getTextBox(By.xpath("//div[@class='date']"), "date of release");
    private ITextBox textGamePrice = getElementFactory().getTextBox(By.xpath("//div[@class='game_purchase_action']//div[@class='game_purchase_price price']"), "price of game");
    private ITextBox textGameNameFromSearch = getElementFactory().getTextBox(By.xpath("//div[@id='appHubAppName']"), "Game Name");
    private IButton btnShowAllTags = getElementFactory().getButton(By.cssSelector("a[onclick=\"ExpandOptions(this, 'TagFilter_Container'); return false;\"]"), "показать все метки");

    public SalesLeadersPage() {
        super(By.cssSelector(".pageheader.full"), "pageHeader");
    }

    public void selectCheckBoxOS() {
        chkbxOs.check();
    }

    public boolean isCheckBoxOSchecked() {
        return chkbxOs.state().isDisplayed();
    }

    public void selectCheckBoxNumberOfPlayers() {
        comboxNumberOfPlayers.click();
        chkbxInsideNumberOfPlayers.check();
    }

    public boolean isCheckBoxNumberOfPlayersChecked() {
        return chkbxInsideNumberOfPlayers.state().isDisplayed();
    }

    public void comBoxLabelsClick() {
        btnShowAllTags.click();
        checkBoxInsideLabels.check();
    }

    public boolean isCheckboxInsideLabesChecked() {
        return checkBoxInsideLabels.state().isDisplayed();
    }

    public String getInfoAboutGame() {
        String result = firstSearchResult.getText();
        String newResult[] = RegExHelper.divisionToSeparateWord(result);
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
