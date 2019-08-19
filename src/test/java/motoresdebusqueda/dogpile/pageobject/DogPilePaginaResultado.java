package motoresdebusqueda.dogpile.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class DogPilePaginaResultado extends PageObject {

    public static final String TITULO_RESULTADO = "//*[@class='web-bing__title']";
    public static final String TEXT_CONTENT = "textContent";

    public List<String> obtenerResultados() {
        return findAll(TITULO_RESULTADO)
                .stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
        // a veces existe elementos que no estan visibles y que no tienen texto
        // si colocamos en vez de getText getAttribute, obtenemos un atributo del elemento llamnado textContent
        // que no necesita que este visible en la pantalla
    }


    public List<List<WebElementFacade>> elementos(List<String> elemento){
        List<List<WebElementFacade>> nuevos=null;
        for (String element: elemento) {
            nuevos.add((findBy("",element).then().thenFindAll("")));
        }
        return nuevos;
    }

    public String obtenerTextoDeTituloResultado(String tituloResultado) {
        // encontrar elementos en serenity, permite mandar parametros
        // permite colocar los valores dentro del xpath
        return findBy("//a[contains(@class, 'web-bing__title') and contains(.,'{0}')]",
                tituloResultado).then().findBy("..//span[contains(@class,'web-bing__description')]")
                .getText();

        // resive el valor por la coma , se colcoa los elementos de variable {0}
        // pasando el atributo

        /**
         * concatenar busquedas con then()
         * se le especifica que haga una busqueda luego apartir de esa
         * le decimos que suba al padre ../ con el dos puntos
         * ../
         * El elemento esta parado en lo que localizo, luego le dice suba ../ al padre
         * luego busqueda en ese ese elemento xpath
         * luego obtengo el texto
         *
         *
         * buena pratica constantes
         */
    }
}
