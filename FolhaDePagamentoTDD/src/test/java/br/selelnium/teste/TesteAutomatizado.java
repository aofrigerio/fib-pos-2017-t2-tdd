package br.selelnium.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteAutomatizado {
	
	
	@Before
	public void init() {
		


	}

	
	@Test
	public void TesteSelenium() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/fibbauru/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.4.103:8080/correntista/lista");
		
		//
		Boolean nome = false;
		Boolean email = false;


			if(!driver.getPageSource().contains("aofrigerio@gmail.com")) {
				WebElement campoTexto = driver.findElement(By.linkText("Add Correntista"));
				campoTexto.click();
				
				
				WebElement campoInput = driver.findElement(By.name("nome"));
			campoInput.sendKeys("Alan");
			
			campoInput = driver.findElement(By.name("email"));
			campoInput.sendKeys("aofrigerio@gmail.com");
			
			campoInput.submit();
			


			}
			
			nome = driver.getPageSource().contains("Alan");
			email = driver.getPageSource().contains("aofrigerio@gmail.com");
			
			assertTrue(nome);
			assertTrue(email);
			
			driver.close();
	}
	
	@After
	public void encerrar() {

	}

}
