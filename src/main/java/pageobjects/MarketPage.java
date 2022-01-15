package pageobjects;

import aquality.selenium.elements.HighlightState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import main.Config;
import org.openqa.selenium.By;

public class MarketPage extends Form {
private IButton btnAdvancedSearch = getElementFactory().getButton(By.xpath("//div[@class='market_search_advanced_button']"), "Show advanced option");
private IButton btnAppSelector = getElementFactory().getButton(By.xpath("//div[@class='market_app_selector']"), "Список с играми");
private IButton btnDota = getElementFactory().getButton(By.xpath("//div[@id='app_option_570']"), "Dota2");
private IComboBox listOfHeroes = getElementFactory().getComboBox(By.cssSelector("select[name='category_570_Hero[]']"), "список героев");
private IButton selectHero = getElementFactory().getButton(By.xpath("//option[@value='tag_npc_dota_hero_"+Config.get("selectHero")+"']"), "Lifeastealer");
private ICheckBox chkBoxInsideRarity = getElementFactory().getCheckBox(By.xpath("//span[normalize-space()='"+Config.get("chkBoxInsideRarity")+"']"), "чекбокс в колонке Rarity");
private ITextBox txtAdvancedSearch = getElementFactory().getTextBox(By.xpath("//input[@id='advancedSearchBox']"), "SearchFieald");
private IButton btnSearch = getElementFactory().getButton(By.xpath("//span[normalize-space()='Search']"),"Search button");
private IButton btnShowingResultFor = getElementFactory().getButton(By.xpath("//a[normalize-space()='\""+Config.get("ShowingResultsFor")+"\"']"), "фильтр в итоговом списке");
private IButton btnSearchResult = getElementFactory().getButton(By.xpath("//div[@id='result_"+Config.get("SearchResult")+"']"), "Результат поиска по играм");
private ITextBox txtDescriptionOfGame = getElementFactory().getTextBox(By.xpath("//div[@id='largeiteminfo_content']//div[@class='item_desc_description']"), "описание игры");

    /**
     * Constructor with parameters
     *
     * @param locator
     * @param name
     */
    public MarketPage(By locator, String name) {
        super(locator, name);
    }

    public MarketPage() {
        super(By.xpath("//span[@class='market_title_text']"), "title Market Page");
    }

    public void goToSearchCommunityMarket(){
        btnAdvancedSearch.click();
    }
    public void setFilterAtMarket(){
        btnAppSelector.click();
        btnDota.click();
    }
    public void selectHero (){
        listOfHeroes.click();
        selectHero.click();
    }
    public void columnCheckBoxes(){
        chkBoxInsideRarity.check();
            }
    public void setSearchField(String query) {
        txtAdvancedSearch.clearAndType(query);
        btnSearch.click();
    }
    public void deleteFiltersFromResult(){
        btnShowingResultFor.click();
    }
    public void goToDesiredResult(){
        btnSearchResult.click();
    }
    public String getText(){
        return txtDescriptionOfGame.getText();
    }
    public boolean checkFirstMatchFromResultItemPage(){
        return txtDescriptionOfGame.getText().contains("Dota 2");
    }
    public boolean checkSecondMatchFromResultItemPage(){
        return txtDescriptionOfGame.getText().contains("Immortal");
    }
    public boolean checkThirdMatchFromResultItemPage(){
        return txtDescriptionOfGame.getText().contains("Lifestealer");
    }

}
