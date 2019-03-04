package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PerfilPage {

	WebDriver driver;

	public PerfilPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//ul[@class='nav luna-nav']//a[contains(text(),'Perfil')]")
	WebElement linkPerfil;
	
	@FindBy(id= "profile-name")
	WebElement campoNome;

	@FindBy(id = "profile-email")
	WebElement campoEmail;

	@FindBy(id = "profile-company")
	WebElement campoEmpresa;

	@FindBy(id = "//*[@id=\"user-settings-profile-edit-form\"]/div/form/div[4]/div/select/option[3]")
	WebElement campoCargo;

	@FindBy(xpath = "//*[@id=\"form-submit-button\"]")
	WebElement btnSalvar;
	
	@FindBy(xpath = "//div[contains(text(),'Perfil atualizado com sucesso.')]")
	WebElement msgPerfilAtualizado;

	public PerfilPage  clicaLinkPerfil() {
		linkPerfil.click();
		return this;
		
	}
	
	public PerfilPage atualizaPerfil(String nome, String email, String empresa) {
		campoNome.sendKeys(nome);
		campoEmail.sendKeys(email);
		campoEmpresa.sendKeys(empresa);
		campoCargo.click();
		btnSalvar.click();
		return this;

	}
	
public String validaMsgPerfilAtualizado() {
		String msg = msgPerfilAtualizado.getText();
		return msg;
		
	}
}
