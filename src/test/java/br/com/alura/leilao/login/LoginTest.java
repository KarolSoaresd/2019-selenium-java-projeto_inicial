package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        this.paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos (){

        paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
        paginaDeLogin.efetuarLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaLogin());
        Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());

    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos(){

        this.paginaDeLogin.preencherFormularioDeLogin("invalido", "12323");
        this.paginaDeLogin.efetuarLogin();

        Assert.assertTrue(paginaDeLogin.isPaginaLoginComDadosInvalidos());
        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos"));

    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado(){
        paginaDeLogin.navegaNaPaginaDeLances();

        Assert.assertTrue(paginaDeLogin.isPaginaLogin());
        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
    }
}
//        Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error")); a URL importamos com uma constante.
//        agora é assert true pois é para continuar na mesma url, agora se fosse para trocar, usariamos a outra
//    usamos o throws para bater as exceptions que é retornando quando o findelement não é encontrado
//        () -> é um lambda e é necessário nessa função
//        getPageSource verifica o código fonte da página procurando algo que iremos usar
//        find serve para encontrar os elementos da tela, sendKeys serve para enviar o que precisamos para o campo
//        submit serve para encaminhar o form que seria os campos de login
//        assert serve para fazer os acertos, confirmar se está da forma esperada.