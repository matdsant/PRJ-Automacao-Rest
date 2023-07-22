package modulos.produto;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@DisplayName("Testes de API Rest do Módulo de Produto")
public class ProdutoTest {

    private String token;

    @Test
    @DisplayName("Validar o Token do Usuário")
    public void testarTokenUsuario(){
        // Configurando os dados da API
        baseURI = "http://165.227.93.41/";
        basePath = "/lojinha";

        // Obter o token do usuário "ADMIN"
        this.token = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"usuarioLogin\": \"matomatt\",\n" +
                        "  \"usuarioSenha\": \"123456789\"\n" +
                        "}")
                .when()
                .post("/v2/login")
                .then()
                .extract()
                .path("data.token");
        System.out.println("Token: " + this.token);
    }
}
