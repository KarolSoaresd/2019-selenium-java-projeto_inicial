package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;
    private CadastroDeLeilaoPage paginaDeCadastro;

    @BeforeEach
    public void beforeEach() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
        this.paginaDeLeiloes = paginaDeLogin.efetuarLogin();
        this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
    }

    @AfterEach
    public void afterEach(){
        this.paginaDeLeiloes.fechar();
    }

    @Test
    public void deveriaCadastrarLeilao(){
        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia " + hoje;
        String valor = "500.00";

        this.paginaDeCadastro.cadastrarLeiloes(nome, valor, hoje);
        Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
    }

    @Test
    public void deveriaValidarCadastroDeLeilao(){
        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeiloes("", "", "");

        Assert.assertFalse(this.paginaDeCadastro.isPaginaAtual());
        Assert.assertTrue(this.paginaDeLeiloes.isPaginaAtual());
        Assert.assertTrue(this.paginaDeCadastro.isMensagensDeValidacaoVisiveis());

    }
}


//        ao invés de criar um objeto de página de login, fazer a atribuição do resultado que teremos por ao logar no sistema.
//        como não queremos abrir um nova página, precisamos na aba de LeiloesPage chamar direto o browser com os drivers
//        return new LeiloesPage(browser);