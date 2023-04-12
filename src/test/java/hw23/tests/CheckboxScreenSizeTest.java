package hw23.tests;

import hw23.pages.MobilePhonesPage;
import hw23.pages.PhonesAndElectronicsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxScreenSizeTest extends BaseTest {

    @Test
    public void checkboxScreenSize() {
        PhonesAndElectronicsPage phonesAndElectronicsPage = mainPage.clickPhonesAndElectronics();
        MobilePhonesPage mobilePhonesPage = phonesAndElectronicsPage.clickMobilePhones();
        mobilePhonesPage.clickCheckBox();
        Assert.assertEquals(mobilePhonesPage.headingText.getText(), mobilePhonesPage.getCheckboxIndexText());
    }
}
