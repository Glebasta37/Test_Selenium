import custom.drivers.Manager;
import custom.properties.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static steps.StepsAll.*;

public class AllTest extends BaseTest {
    @DisplayName("Проверка ядекс маркета")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#provideCheckingMoneyList")
    public void OpenList2(String section, String elementOfSection, List<String> priceFromAndPriceTo, String manufacturer, List<String> brand, String count, String indexElement) throws InterruptedException {
        openSiteYandex(TestData.propsUrl.baseURLYandex(), Manager.getCurrentDriver());
        moveToYandexMarket();
        moveAndClick(section, elementOfSection);
        sendOptionsPrice(priceFromAndPriceTo);
        selectManufacturerAndBrand(manufacturer, brand);
        installCountElementsOnPageSearch(count);
        validateCountElementsOnPageSearch(count);
        savingFirstElementAndSendHimInFieldSearch(indexElement);
        searchElementInNewSearchPage();
        validateFieldSearchContainsSaveElement();

    }

}
