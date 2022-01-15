
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
        steamMainPage.btnAboutClick();
        Assert.assertTrue(steamMainPage.isOnlineMoreThanInGame(), "неверно");
        steamMainPage.btnStoreClick();

    }
    @Test
    public void secondCase()  {
        steamMainPage.comboBoxNewAndRemarkableHover();
        salesLeadersPage.selectCheckBoxOS();
        salesLeadersPage.selectCheckBoxNumberOfPlayers();
        salesLeadersPage.comBoxLabelsClick();
        String gameInfo = salesLeadersPage.getInfoAboutGame();
        salesLeadersPage.clickFirstSearchResult();
        Assert.assertEquals(gameInfo, salesLeadersPage.buildInfoAboutGameToCompare(), "ошибка, несоответствие");
            }

    @Test
    public void thirdCase(){
        steamMainPage.goToMarket();
        marketPage.goToSearchCommunityMarket();
        marketPage.setFilterAtMarket();
        marketPage.selectHero();
        marketPage.columnCheckBoxes();
        marketPage.setSearchField(Config.get("setSearchField"));
        marketPage.deleteFiltersFromResult();
        marketPage.goToDesiredResult();
        Assert.assertTrue(marketPage.checkFirstMatchFromResultItemPage(), "ошибка, несовпадение");
        Assert.assertTrue(marketPage.checkSecondMatchFromResultItemPage(), "ошибка, несовпадение");
        Assert.assertTrue(marketPage.checkThirdMatchFromResultItemPage(), "ошибка, несовпадение");

    }

}
