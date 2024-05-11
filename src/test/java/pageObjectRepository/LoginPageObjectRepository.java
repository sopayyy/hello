package pageObjectRepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPageObjectRepository {

    // Add a new MobileElement field for the Login button
    @AndroidFindBy(id = "edts.klik.android:id/btnChange")
    public MobileElement loginButton;
}
