package pageObjectRepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePageObjectRepository {

    @AndroidFindBy(id = "clSearch")
    public MobileElement searchBar;

    public String searchBarText = "Cari di Klik Indomaret";

    public MobileElement getSearchBar() {
        return searchBar;
    }

    public void setSearchBar(MobileElement searchBar) {
        this.searchBar = searchBar;
    }

    public String getSearchBarText() {
        return searchBarText;
    }
    public void setSearchBarText(String searchBarText) {
        this.searchBarText = searchBarText;
//        return searchBarText;
    }

    @AndroidFindBy(id = "chrome_action_bar_cart")
    public MobileElement cartIcon;
    public MobileElement getCartIcon() {
        return cartIcon;
    }

    public void setCartIcon(MobileElement cartIcon) {
        this.cartIcon = cartIcon;
    }


    @AndroidFindBy(id = "edts.klik.android:id/clAccount")
    public MobileElement akunButton;
}
