package com.inetbanking.tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pages.HomePage;
import com.inetbanking.pages.LoginPage;
import com.inetbanking.utils.ExcelUtils;

public class LoginDdtTest extends BaseTest {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException {
		logger.info("Inside LoginDDT");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("Entered Username");
		lp.setPassword(pwd);
		logger.info("Entered Password");
		HomePage hp = lp.clickSubmit();
		logger.info("Clicked Submit");

		if (isAlerPresent()) {

			Thread.sleep(3000);

			driver.switchTo().alert().accept(); // close invalid credentials alert
			driver.switchTo().defaultContent();
			logger.warn("Login failed.");
			logger.info("------------");
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			logger.info("------------");

			Thread.sleep(3000);

			((JavascriptExecutor) driver).executeScript("scroll(0, 500)");
			hp.clickLogout();

			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlerPresent() { // user defined method created to check alert is present or not
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getLoginData() throws IOException {
		String loginDataFilePath = "./src/test/java/com/inetBanking/testData/loginData.xlsx";
		int rowCount = ExcelUtils.getRowCount(loginDataFilePath, "Sheet1");
		int colCount = ExcelUtils.getCellCount(loginDataFilePath, "Sheet1", 0);
		String loginData[][] = new String[rowCount][colCount - 1];
		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < colCount - 1; c++) {
				loginData[r - 1][c] = ExcelUtils.getCellData(loginDataFilePath, "Sheet1", r, c);
			}
		}
		return loginData;
	}

}
