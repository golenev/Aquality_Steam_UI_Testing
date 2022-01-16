
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import main.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MarketPage;
import pageobjects.SalesLeadersPage;
import pageobjects.SteamMainPage;

public class SteamTests extends BaseTest{

    private final SteamMainPage steamMainPage = new SteamMainPage();
    private final SalesLeadersPage salesLeadersPage = new SalesLeadersPage();
    private final MarketPage marketPage = new MarketPage();

    @Test
    public void testMainPage(){
        Assert.assertTrue(steamMainPage.isMainPageOpen());
        steamMainPage.btnAboutClick();
        Assert.assertTrue(steamMainPage.isOnlineMoreThanInGame(), "неверно");
        steamMainPage.btnStoreClick();

    }
    @Test
    public void secondCase()  {
        Assert.assertTrue(steamMainPage.isMainPageOpen());
        steamMainPage.comboBoxNewAndRemarkableHover();
        salesLeadersPage.selectCheckBoxOS();
        Assert.assertTrue(salesLeadersPage.isCheckBoxOSchecked(), "ошибка, чекбок не вбыран");
        salesLeadersPage.selectCheckBoxNumberOfPlayers();
        Assert.assertTrue(salesLeadersPage.isCheckBoxNumberOfPlayersChecked(), "ошибка, чекбокс не выбран");
        salesLeadersPage.comBoxLabelsClick();
        Assert.assertTrue(salesLeadersPage.isCheckboxInsideLabesChecked(), "ошибка, чекбокс не выбран");
        String gameInfo = salesLeadersPage.getInfoAboutGame();
        salesLeadersPage.clickFirstSearchResult();
        Assert.assertEquals(gameInfo, salesLeadersPage.buildInfoAboutGameToCompare(), "ошибка, несоответствие");
            }

    @Test
    public void thirdCase(){
        Assert.assertTrue(steamMainPage.isMainPageOpen());
        steamMainPage.goToMarket();
        marketPage.goToSearchCommunityMarket();
        marketPage.setFilterAtMarket();
        marketPage.selectHero();
        marketPage.columnCheckBoxes();
        marketPage.setSearchField(Config.get("setSearchField"));
        Assert.assertTrue(marketPage.check1FinalFilters());
        Assert.assertTrue(marketPage.check2FinalFilters());
        Assert.assertTrue(marketPage.check3FinalFilters());
        Assert.assertTrue(marketPage.check4FinalFilters());
        marketPage.deleteFiltersFromResult();
        Assert.assertTrue(marketPage.check1FinalFilters());
        Assert.assertFalse(marketPage.check2FinalFilters());
        Assert.assertTrue(marketPage.check3FinalFilters());
        Assert.assertTrue(marketPage.check4FinalFilters());

        marketPage.goToDesiredResult();
        Assert.assertTrue(marketPage.checkFirstMatchFromResultItemPage(), "ошибка, несовпадение");
        Assert.assertTrue(marketPage.checkSecondMatchFromResultItemPage(), "ошибка, несовпадение");
        Assert.assertTrue(marketPage.checkThirdMatchFromResultItemPage(), "ошибка, несовпадение");

    }

}
