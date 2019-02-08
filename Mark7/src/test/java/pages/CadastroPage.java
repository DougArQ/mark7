package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroPage {
	
	 public CadastroPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		 }

	WebDriver driver;

	@FindBy(id = "register_name")
	WebElement regNome;

	@FindBy(id = "register_email")
	WebElement regEmail;

	@FindBy(id = "register_password")
	WebElement regSenha;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnCadastrar;

	public WebElement regNome() {
		return regNome;
	}

	public WebElement regEmail() {
		return regEmail;
	}

	public WebElement regSenha() {
		return regSenha;
	}

	public WebElement btnCadastrar() {
		return btnCadastrar;
	}

}
