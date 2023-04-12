package hw23.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MobilePhonesPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Діагональ екрана')]/../..//li")
    List<WebElement> checkBoxes;

    @FindBy(xpath = "//h1[contains(@class, 'catalog-heading')]")
    public WebElement headingText;

    private String checkboxIndexText = "";

    public String getCheckboxIndexText() {
        return checkboxIndexText;
    }

    public void setCheckboxIndexText(String checkboxIndexText) {
        this.checkboxIndexText = checkboxIndexText;
    }

    public MobilePhonesPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckBox() {

        double screenSizeValue = 3.8;
        int checkBoxIndex = 0;


        wait.until(ExpectedConditions.visibilityOfAllElements(checkBoxes));
        for (WebElement checkBox : checkBoxes) {
            String[] parts = checkBox.getText().split("\\(");
            String valueString = parts[0].trim();
            valueString = valueString.replaceAll("[^\\d.\\-]", "");

            double minValue;
            double maxValue;
            if (valueString.contains("та більше")) {
                minValue = Double.parseDouble(valueString.replace("та більше", ""));
                maxValue = Double.MAX_VALUE;
            } else if (valueString.contains("-")) {
                String[] rangeValues = valueString.split("-");
                minValue = Double.parseDouble(rangeValues[0]);
                maxValue = Double.parseDouble(rangeValues[1]);
            } else {
                minValue = Double.parseDouble(valueString);
                maxValue = Double.parseDouble(valueString);
            }

            if (screenSizeValue >= minValue && screenSizeValue <= maxValue) {
                wait.until(ExpectedConditions.elementToBeClickable(checkBox));
                checkBox.click();
                checkBoxIndex = checkBoxes.indexOf(checkBox);
                wait.until(ExpectedConditions.visibilityOfAllElements(headingText));
                headingText.getText();
                break;
            } else if (screenSizeValue < minValue && checkBoxes.indexOf(checkBox) == 0) {
                wait.until(ExpectedConditions.elementToBeClickable(checkBox));
                checkBox.click();
                checkBoxIndex = checkBoxes.indexOf(checkBox);
                wait.until(ExpectedConditions.visibilityOfAllElements(headingText));
                headingText.getText();
                break;
            } else if (screenSizeValue > maxValue && checkBoxes.indexOf(checkBox) == checkBoxes.size() - 1) {
                wait.until(ExpectedConditions.elementToBeClickable(checkBox));
                checkBox.click();
                checkBoxIndex = checkBoxes.indexOf(checkBox);
                wait.until(ExpectedConditions.visibilityOfAllElements(headingText));
                headingText.getText();
                break;
            }
        }

        switch (checkBoxIndex) {
            case 0 -> setCheckboxIndexText("Мобільні телефони до 4.59 Дюймів");
            case 1 -> setCheckboxIndexText("Смартфони 4.6 - 5 Дюймів");
            case 2 -> setCheckboxIndexText("Смартфони з діагоналлю від 5,1 до 5,5 дюйма");
            case 3 -> setCheckboxIndexText("Мобільні телефони 5.55 - 6 Дюймів");
            case 4 -> setCheckboxIndexText("Мобільні телефони 6.01 - 6.49 Дюймів");
            case 5 -> setCheckboxIndexText("Смартфони з діагоналлю 6 дюймів і більше");
            default -> {
            }
        }
      }
    }


