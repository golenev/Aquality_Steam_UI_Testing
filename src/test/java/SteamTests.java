import helpers.ConfigProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AboutSteamPage;
import pageobjects.MarketPage;
import pageobjects.SalesLeadersPage;
import pageobjects.SteamMainPage;

public class SteamTests extends BaseTest{

    private final SteamMainPage steamMainPage = new SteamMainPage();
    private final SalesLeadersPage salesLeadersPage = new SalesLeadersPage();
    private final MarketPage marketPage = new MarketPage();
    private final AboutSteamPage aboutSteamPage = new AboutSteamPage();

    @Test
    public void testMainPage(){
        Assert.assertTrue(steamMainPage.state().isDisplayed(),"Ошибка. Главная страница не отобразилась");
        steamMainPage.btnAboutClick();
        Assert.assertTrue(aboutSteamPage.state().isDisplayed(), "Ошибка. Страница AboutSteam не отобразилась");
        Assert.assertTrue(aboutSteamPage.inGameCount() < aboutSteamPage.onlinersCount(), "Ошибка. Число игроков сейчас не меньше, чем онлайн");
        steamMainPage.btnStoreClick();
        Assert.assertTrue(marketPage.state().isDisplayed(), "Ошибка. Страница магазина не отобразилась");
    }

    @Test
    public void secondCase()  {
        Assert.assertTrue(steamMainPage.state().isDisplayed(),"Ошибка. Главная страница не отобразилась");
        steamMainPage.comboBoxNewAndRemarkableHover();
        Assert.assertTrue(salesLeadersPage.state().isDisplayed(), "Ошибка. Страница Лидеры продаж не отобразилась");
        salesLeadersPage.selectCheckBoxOS();
        Assert.assertTrue(salesLeadersPage.isCheckBoxOSchecked(), "Ошибка, чекбок не выбран");
        salesLeadersPage.selectCheckBoxNumberOfPlayers();
        Assert.assertTrue(salesLeadersPage.isCheckBoxNumberOfPlayersChecked(), "Ошибка, чекбокс не выбран");
        salesLeadersPage.comBoxLabelsClick();
        Assert.assertTrue(salesLeadersPage.isCheckboxInsideLabesChecked(), "Ошибка, чекбокс не выбран");
//вызвал метод и записал его значение в переменную, чтобы использовать на другом шаге, где его уже нельзя будет вызвать
        String gameInfo = salesLeadersPage.getInfoAboutGame();
        salesLeadersPage.clickFirstSearchResult();
//и использую переменную вот тут, так как метод сюда подставить не получится, он не сработает из этого шага
        Assert.assertEquals(gameInfo, salesLeadersPage.buildInfoAboutGameToCompare(), "Ошибка, несоответствие описания игры");
    }

    @Test
    public void thirdCase(){
        Assert.assertTrue(steamMainPage.state().isDisplayed(),"Ошибка. Главная страница не отобразилась");
        steamMainPage.goToMarket();
        Assert.assertTrue(marketPage.state().isDisplayed(), "Ошибка, страница Market не отобралилась");
        marketPage.goToAdvancedSearch();
        marketPage.setFilterAtMarket();
        marketPage.selectHero();
        marketPage.columnCheckBoxes();
        marketPage.setSearchField(ConfigProperties.get("setSearchField"));
        Assert.assertTrue(marketPage.check1FinalFilters(), "Ошибка, фильтр 1 не присутствует");
        Assert.assertTrue(marketPage.check2FinalFilters(), "Ошибка, фильтр 2 не присутствует");
        Assert.assertTrue(marketPage.check3FinalFilters(), "Ошибка, фильтр 3 не присутствует");
        Assert.assertTrue(marketPage.check4FinalFilters(), "Ошибка, фильтр 4 не присутствует");
        marketPage.deleteFiltersFromResult();
        Assert.assertTrue(marketPage.check1FinalFilters(), "Ошибка, фильтр 1 не присутствует");
        Assert.assertFalse(marketPage.check2FinalFilters(), "Ошибка, фильтр 2 НЕ УДАЛИЛСЯ");
        Assert.assertTrue(marketPage.check3FinalFilters(), "Ошибка, фильтр 3 не присутствует");
        Assert.assertTrue(marketPage.check4FinalFilters(), "Ошибка, фильтр 4 не присутствует");
        marketPage.goToDesiredResult();
        Assert.assertTrue(marketPage.checkFirstMatchFromResultItemPage(), "ошибка, несовпадение");
        Assert.assertTrue(marketPage.checkSecondMatchFromResultItemPage(), "ошибка, несовпадение");
        Assert.assertTrue(marketPage.checkThirdMatchFromResultItemPage(), "ошибка, несовпадение");
    }

}
