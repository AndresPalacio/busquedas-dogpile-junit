package motoresdebusqueda.dogpile.steps;

import motoresdebusqueda.dogpile.pageobject.DogPilePaginaResultado;
import motoresdebusqueda.dogpile.pageobject.DogpilePaginaPrincipal;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class UsuarioDogPile {
    DogpilePaginaPrincipal paginaPrincipal;
    DogPilePaginaResultado paginaResultado;

    @Step
    public void ingresaADogPile() {
    paginaPrincipal.open();
    }

    @Step
    public void buscaPorPalabraClave(String rock_nacional) {
        paginaPrincipal.ingresarPalabraClave(rock_nacional);
        paginaPrincipal.realizarBusqueda();

    }
    @Step
    public void deberiaVerResultadosConPalabra(String rock) {
        List<String> resultados = paginaResultado.obtenerResultados();
        resultados.replaceAll(String::toLowerCase);
        // convertir todos los elementos a miniscula
        resultados.stream().forEach(el -> System.out.println(el));
        assertThat(resultados, Matchers.everyItem(containsString(rock)));
    }
    @Step("#actor debera ver el texto esperado: {1} en el resultado del titulo : {0}")
    public void deberiaVerResultadoDeTituloiaConTextoCorrecto(String tituloResultado, String textoResultado) {
        String texto = paginaResultado.obtenerTextoDeTituloResultado(tituloResultado);
        System.out.println(texto);
        System.out.println(textoResultado);
        assertThat(texto,containsString(textoResultado));

    }
}
