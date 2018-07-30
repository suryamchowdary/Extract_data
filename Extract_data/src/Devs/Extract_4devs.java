package Devs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Extract_4devs {
	
public static WebDriver Driver;
public static String name,cpf,dob,mothername,cep,height,weight,Numero,email;

	public static void main(String[] args) throws IOException, InterruptedException   {
		// TODO Auto-generated method stub
		Extract_4devs E1  = new Extract_4devs();
		E1.browser();
		E1.loaddata();
		E1.getdata();
	}
public static void browser()
{
	/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\ksuryam1\\Desktop\\JAVA_SELENIUM\\chromedriver_win32\\chromedriver.exe");
	Driver = new ChromeDriver();*/
	Driver = new FirefoxDriver();
	Driver.get("https://4devs.com.br/");
	Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	/*WebDriverWait wait = new WebDriverWait(Driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div/div[1]/div/nav/section/ul/li[19]/a")));*/
	Driver.findElement(By.xpath("/html/body/main/div/div[1]/div/nav/div/ul/li[19]/a")).click();
}
public static void loaddata() throws IOException, InterruptedException
{	
	Driver.findElement(By.xpath("//*[@id='bt_gerar_pessoa']")).click();
	File data1 = new File("C:\\Users\\ksuryam1\\Desktop\\JAVA_SELENIUM\\data5.xlsx");
	FileInputStream fis = new FileInputStream(data1);
    XSSFWorkbook workbook1 = new XSSFWorkbook(fis);
    XSSFSheet Sheet1 = workbook1.getSheetAt(0);
  	XSSFRow row;
  	
  	for(int i=1;i<18;i++)
  	{
  		Thread.sleep(40000);	
	Driver.findElement(By.xpath("//*[@id='bt_gerar_pessoa']")).click();
	
	//String name,cpf,dob,mothername,cep,height,weight,Numero;
	name = Driver.findElement(By.xpath("//*[@id='nome']/span[1]")).getAttribute("innerHTML");
	
	cpf = Driver.findElement(By.xpath("//*[@id='cpf']/span[1]")).getAttribute("innerHTML");
	
	dob = Driver.findElement(By.xpath("//*[@id='data_nasc']/span[1]")).getAttribute("innerHTML");
		
	mothername = Driver.findElement(By.xpath("//*[@id='mae']/span[1]")).getAttribute("innerHTML");
	
	cep = Driver.findElement(By.xpath("//*[@id='cep']/span[1]")).getAttribute("innerHTML");
	
	height = Driver.findElement(By.xpath("//*[@id='altura']/span[1]")).getAttribute("innerHTML");
	
	weight = Driver.findElement(By.xpath("//*[@id='peso']/span[1]")).getAttribute("innerHTML");
	
	Numero = Driver.findElement(By.xpath("//*[@id='numero']/span[1]")).getAttribute("innerHTML");
	
	email = Driver.findElement(By.xpath("//*[@id='email']/span[1]")).getAttribute("innerHTML");
	
	System.out.println("name of the person in "+ name + cpf);
	System.out.println(dob + mothername + cep );
	System.out.println(height + weight + Numero );
	System.out.println(email);
	   /*File data1 = new File("C:\\Users\\ksuryam1\\Desktop\\JAVA_SELENIUM\\data5.xlsx");
	  	XSSFWorkbook workbook1 = new XSSFWorkbook(data1);
	  	XSSFSheet Sheet1 = workbook1.getSheetAt(0);
	  	XSSFRow row;*/
	  	 //XSSFSheet Sheet1 = workbook1.getSheetAt(0);
	 row = Sheet1.getRow(i);
	 XSSFCell c1,c2,c3,c4,c5,c6,c7,c8,c9;
	  	
	  	/* ArrayList<String> readdata = new ArrayList<String>();*/
	  	
	  row.createCell(0).setCellValue(name);
	  //row.createCell(0).setCellValue(name)
	  row.createCell(1).setCellValue(cpf);
	  row.createCell(2).setCellValue(dob);
	  row.createCell(3).setCellValue(mothername);
	  row.createCell(4).setCellValue(cep);
	  row.createCell(5).setCellValue(height);
	  row.createCell(6).setCellValue(weight);
	  row.createCell(7).setCellValue(Numero);
	  row.createCell(8).setCellValue(email);
	  
	  c1 = Sheet1.getRow(i).getCell(0);
      c2 = Sheet1.getRow(i).getCell(1);
      c3 = Sheet1.getRow(i).getCell(2);
      c4 = Sheet1.getRow(i).getCell(3);
      c5 = Sheet1.getRow(i).getCell(4);
      c6 = Sheet1.getRow(i).getCell(5);
      c7 = Sheet1.getRow(i).getCell(6);
      c8 = Sheet1.getRow(i).getCell(7);
      c9 = Sheet1.getRow(i).getCell(8);
      
  /*  LinkedList<String> r = new LinkedList<>();
    r.add(c1.getRawValue());
    r.add(c2.getRawValue());
    r.add(c3.getRawValue());
    r.add(c4.getRawValue());
    r.add(c5.getRawValue());
    r.add(c6.getRawValue());
    r.add(c7.getRawValue());
    r.add(c8.getRawValue());
    r.add(c9.getRawValue());
    Iterator<String> itr=r.iterator();
	  while(itr.hasNext()){
	   System.out.println(itr.next());
	  }*/
      System.out.println(c1);
      System.out.println(c2);
      System.out.println(c3);
      FileOutputStream fout = new FileOutputStream(data1);
      workbook1.write(fout);
  	}
	  
}
public static void getdata()
{
Driver.close();	
/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\ksuryam1\\Desktop\\JAVA_SELENIUM\\chromedriver_win32\\chromedriver.exe");
Driver = new ChromeDriver();
Driver.navigate().to("http://sisamil9.qa.amil.com.br");
WebDriverWait wait = new WebDriverWait(Driver, 1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='divLoginForm']/div[2]/div/input")));
System.out.println("found element");
//Driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement name1 = Driver.findElement(By.xpath("//*[@id='divLoginForm']/div[2]/div/input"));
System.out.println("Element Found");*/

/*name.sendKeys(a);
Driver.findElement(By.xpath("//*[@id='divLoginForm']/div[2]/div/input")).sendKeys("sukode");
Driver.findElement(By.name("Senha")).sendKeys("Aug@2017");
Driver.findElement(By.id("Submit1")).click();
Driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);*/


/* Driver.findElement(By.linkText("Ok, entendi")).click();
 //Driver.findElement(By.xpath("//a[Contains(text(),'Ok,entendi')")).click();
 Driver.findElement(By.id("mostraMenu")).click();
 Driver.switchTo().frame(Driver.findElement(By.name("menu")));
 Driver.findElement(By.linkText("Contratos e Beneficiarios")).click();
 Driver.findElement(By.linkText("Movimentação Operadora")).click();
 Driver.findElement(By.linkText("Cadastro")).click();
 Driver.findElement(By.linkText("Inclusão de Titular")).click();
 Driver.switchTo().defaultContent();
 Driver.switchTo().frame(Driver.findElement(By.xpath("//*[@id='principal']")));
 WebElement Contract = Driver.findElement(By.name("num_contrato"));
 Contract.sendKeys("832918000");
 Contract.submit();
 Driver.switchTo().defaultContent();
 System.out.println();
 
 Driver.findElement(By.id("num_cpf")).sendKeys("565.452.039-32");*/
}
}