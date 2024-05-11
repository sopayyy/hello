package pageObjectRepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPageObjectRepository {
    @AndroidFindBy(xpath = ".//android.view.View[@text = 'Your Amazon Basket is empty']")
    public MobileElement title;
    public String titleText = "Your Amazon Basket is empty";

    @AndroidFindBy(xpath = ".//android.widget.TextView[@text = 'Shop today’s deals']")
    public MobileElement description;
    public String descriptionText = "Shop today’s deals";

    public MobileElement getTitle() {
        return title;
    }

    public void setTitle(MobileElement title) {
        this.title = title;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public MobileElement getDescription() {
        return description;
    }

    public void setDescription(MobileElement description) {
        this.description = description;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }
}
