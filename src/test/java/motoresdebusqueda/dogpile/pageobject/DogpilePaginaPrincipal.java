package motoresdebusqueda.dogpile.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.dogpile.com/")
public class DogpilePaginaPrincipal  extends PageObject {

    @FindBy(xpath = "//input[@class='search-form-home__q']")
    WebElementFacade cajadeBusqueda;

    @FindBy(xpath = "//button[@class='search-form-home__button']")
    WebElementFacade buttonSearch;
    public void ingresarPalabraClave(String rock_nacional){
        this.cajadeBusqueda.type(rock_nacional);
    }

    public void realizarBusqueda() {
        this.buttonSearch.click();
    }
}
