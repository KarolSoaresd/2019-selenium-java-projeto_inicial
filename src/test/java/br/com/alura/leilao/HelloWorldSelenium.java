package br.com.alura.leilao;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

    @Test
    public void hello (){

        System.setProperty("webdriver.chrome.driver", "C:/Users/karoline.santos/IdeaProjects/2019-selenium-java-projeto_inicial/drivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/leiloes");
        browser.quit();
    }
}



//chamamos a interface WebDriver e colocamos a variável, após criamos um objeto que é instanciado pelo que browser que vamos usar, o Chrome
//        código serve para conectar os drivers do chrome com selenium
//        Opção de sair do navegador após fazer o que foi solcitado, no momento, foi abertura do Menu

