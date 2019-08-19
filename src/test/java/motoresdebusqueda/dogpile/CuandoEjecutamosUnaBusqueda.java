package motoresdebusqueda.dogpile;

import motoresdebusqueda.dogpile.steps.UsuarioDogPile;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(SerenityRunner.class)
public class CuandoEjecutamosUnaBusqueda {

    @Managed
    WebDriver driver;

    @Steps
    UsuarioDogPile andres;
    @Test
    public void deberiamosVerResultadosRelevantes(){
        // BDD <-  primero escribimos como se va ejecutar es bdd
        // primero los pasos que se van a llevar a cabo
        andres.ingresaADogPile();
        andres.buscaPorPalabraClave("rock nacional");
        andres.deberiaVerResultadosConPalabra("rock");
    }
     @Test
    public void resultaadoDeWikipediaContineTextoCorrecto(){
        andres.ingresaADogPile();
        andres.buscaPorPalabraClave("rock nacional");
        andres.deberiaVerResultadoDeTituloiaConTextoCorrecto("Rock de Argentina",
                "El rock and roll surgió como género musical en los Estados Unidos en los años 50");
     }

     @Test
    public void resultadoDos(){

        driver.get("http://automationpractice.com/index.php");
        WebElement elemento =  driver.findElement(By.className("search_query form-control "));
        elemento.sendKeys("hola");
    }
}
