package br.com.alura.leilao.login;

import br.com.alura.leilao.leiloes.LeiloesPage;
import br.com.alura.leilao.leiloes.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {

    private static final String LOGIN = "http://localhost:8080/login";

    public LoginPage () {
        super(null);
        this.browser.navigate().to(LOGIN);
    }

    public void preencherFormularioDeLogin(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage efetuarLogin() {

        browser.findElement(By.id("login-form")).submit();
        return new LeiloesPage(browser);
    }

    public boolean isPaginaLogin() {
        return browser.getCurrentUrl().equals(LOGIN);
    }

    public String getNomeUsuarioLogado() {
        try{
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public void navegaNaPaginaDeLances() {
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }

    public boolean isPaginaLoginComDadosInvalidos() {
        return browser.getCurrentUrl().equals(LOGIN + "?error");
    }
}
