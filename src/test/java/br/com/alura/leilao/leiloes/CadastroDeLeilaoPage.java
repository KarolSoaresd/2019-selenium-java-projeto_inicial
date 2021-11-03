package br.com.alura.leilao.leiloes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroDeLeilaoPage extends PageObject{

    private static final String URL_CADASTRO_LEILAO= "http://localhost:8080/leiloes/new";

    public CadastroDeLeilaoPage(WebDriver browser) {
        super(browser);
    }

    public LeiloesPage cadastrarLeiloes(String nome, String valorInicial, String dataAbertura) {
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.browser.findElement(By.id("button-submit")).submit();

        return new LeiloesPage(browser);
    }

    public boolean isMensagensDeValidacaoVisiveis() {
        String pageSource = this.browser.getPageSource();
        return pageSource.contains("não deve estar em branco")
                && pageSource.contains("minimo 3 caracteres")
                && pageSource.contains("deve ser um valor maior de 0.1")
                && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().contentEquals(URL_CADASTRO_LEILAO);
    }
}

//sendKeys não aceita nulo, para enviar um valor vazio, precisa mandar em formato de String " "