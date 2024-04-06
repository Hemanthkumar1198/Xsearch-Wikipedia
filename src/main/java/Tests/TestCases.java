package Tests;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {
	WebDriver driver;

	public TestCases() throws MalformedURLException {
		System.out.println("Constructor: TestCases");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	public void endTest() {
		System.out.println("End Test: TestCases");
		driver.close();
		driver.quit();

	}

	public void testCase01() {
		System.out.println("Start Test case: testCase01");
		driver.get("https://www.wikipedia.org/");
		WebElement verifytext = driver.findElement(By.xpath("(//h1[@class='central-textlogo-wrapper']/span)[1]"));
		String actualtext = verifytext.getText();
		System.out.println(actualtext);

		if (actualtext.equals("Wikipedia")) {
			System.out.println("testCase01: passed");
			System.out.println("end Test case: testCase01");

		}

	}

	public Boolean testCase02() throws InterruptedException {
		Boolean status = false;

		System.out.println("Start Test case: testCase02");
		driver.get("https://www.wikipedia.org/");

		WebElement wikipedia = driver
				.findElement(By.xpath("//span[@class='central-textlogo__image sprite svg-Wikipedia_wordmark']"));
		String text1 = wikipedia.getText();
		if (wikipedia.isDisplayed() || text1.equals("Wikipedia")) {
			System.out.println(text1);
			status = true;
		}

		List<WebElement> text = driver.findElements(By.xpath("(//small[@class='jsl10n'])"));

		List<String> expected = Arrays.asList("Terms of Use", "Privacy Policy");

		for (int i = 0; i < text.size(); i++) {
			if (i == 0) {
				continue;
			}
			String checktext = text.get(i).getText();
			if (expected.contains(checktext)) {
				System.out.println(checktext);
				status = true;

			}
		}

		if (status) {
			System.out.println("testCase02: passed");
			System.out.println("end Test case: testCase02");

		} else {
			System.out.println("testCase02: Failed");
			System.out.println("end Test case: testCase02");
		}

		return status;

	}

	public void testCase03() throws InterruptedException {

		System.out.println("Start Test case: testCase03");
		driver.get("https://www.wikipedia.org/");

		WebElement searchbox = driver.findElement(By.id("searchInput"));
		searchbox.sendKeys("apple");

		driver.findElement(By.xpath("(//h3[@class='suggestion-title']/em)[2]")).click();

		WebElement text = driver.findElement(By.xpath("(//div[@class='plainlist']//a[text()='Steve Jobs'])"));
		String actualtext = text.getText();
		if (actualtext.equals("Steve Jobs")) {
			System.out.println("testCase03: passed");
			System.out.println("end Test case: testCase03");
		} else {
			System.out.println("testCase03: Failed");
			System.out.println("end Test case: testCase03");
		}
	}

	public void testCase04() {
		System.out.println("Start Test case: testCase04");
		driver.get("https://www.wikipedia.org/");

		WebElement searchbox = driver.findElement(By.id("searchInput"));
		searchbox.sendKeys("microsoft");

		driver.findElement(By.xpath("(//em[text()='Microsoft'])[1]")).click();

		WebElement text = driver.findElement(By.xpath("(//div[@class='plainlist']//a[text()='Bill Gates'])"));
		String actualtext = text.getText();
		if (actualtext.equals("Bill Gates")) {
			text.click();
		}
		if (driver.getCurrentUrl().contains("Bill_Gates")) {
			System.out.println("testCase04: passed");
			System.out.println("end Test case: testCase04");
		}

	}

	public void testCase05() {
		System.out.println("Start Test case: testCase05");
		driver.get("https://en.wikipedia.org/");

		driver.findElement(By.id("vector-main-menu-dropdown-checkbox")).click();

		driver.findElement(By.xpath("//a[text()='About Wikipedia']")).click();
		if (driver.getCurrentUrl().contains("About")) {
			System.out.println("testCase05: passed");
			System.out.println("end Test case: testCase05");
		}

	}

}
