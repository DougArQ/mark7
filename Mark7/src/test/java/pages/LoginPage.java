package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login_email")
	WebElement txtEmail;

	@FindBy(id = "login_password")
	WebElement txtSenha;

	@FindBy(xpath = "//button[@class='btn btn-accent loginButton']")
	WebElement btnLogin;

	@FindBy(linkText = "Clique aqui")
	WebElement btnCliqueAqui;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement msgErro;

	public String validarMensagemUsuarioNaoEncontrado() {
		String mensagem = msgErro.getText();

		return mensagem;
	}
	
	public LoginPage clicarCadastro() {
		btnCliqueAqui.click();
		
		return this;
	}
	
	public LoginPage realizarLogin(String email, String senha) {
		txtEmail.sendKeys(email);
		txtSenha.sendKeys(senha);
		btnLogin.click();
		
		return this;		
	}

}
