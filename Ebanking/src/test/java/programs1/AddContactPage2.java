package programs1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


    public class AddContactPage2 
    {

     //Element Locators
	@FindBy(partialLinkText="Contacts")
	public WebElement plink;

	@FindBy(xpath="//button[@id='action-ActionButton']//span[contains(text(),'Actions')]")
	public WebElement actionbtn;
	
	@FindBy(partialLinkText="Add Individual")
	public WebElement addindividual;
	
	@FindBy(xpath=("//input[@name='Prefix_']"))
	public WebElement prefix;

	@FindBy(xpath=(("//input[@name='FirstName_']")))
	public WebElement fname;
	
	@FindBy(xpath="//input[@name='MiddleName_']")
	public WebElement mname;
	
	@FindBy(xpath="//input[@name='LastName_']")
	public WebElement lname;
	
	
	@FindBy(xpath="//input[@name='Suffix_']")
	public WebElement suffix;
	
	
	@FindBy(xpath=("//input[@name='CommonName_']"))
	public WebElement cname;
	
	
	
	@FindBy(xpath="//input[@name='ContactListValue_0']")
	public WebElement phone;
	
	
	
	@FindBy(xpath="//div[@class='col-sm-3']//select[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-required']")
	public WebElement type1;
	
	@FindBy(name="AddressesAddress1_0")
	public WebElement add1;
	
	
	@FindBy(name="AddressesAddress2_0")
	public WebElement add2;
	
	@FindBy(name="AddressesCity_0")
	public WebElement city;
	
	
	@FindBy(name="AddressesPostalCode_0")
	public WebElement postalcode;
	
	
	@FindBy(xpath="//div[6]//div[1]//select[1]")
	public WebElement country;
	
	
	@FindBy(xpath="(//*[@required='required'])[6]")
	public WebElement type2;
	
	@FindBy(xpath="//div[8]//div[1]//select[1]")
	public WebElement usage;
	
	@FindBy(xpath="//input[@name='OrganizationsAndRolesName_0']")
	public WebElement mybusiness;
	
	
	@FindBy(xpath="//input[@name='OrganizationsAndRolesTitle_0']")
	public WebElement title; 
	

	@FindBy(xpath="//*[text()='Done']")
	public WebElement done;
	
	
	@FindBy(xpath="//*[@class='contactName']/span[2]")
	public WebElement text;
	
	
	//Element methods
	public void contactsClick()
	{
		plink.click();
	}
	
	public void clickActions() throws Exception
	{
		Thread.sleep(3000);
		actionbtn.click();
		Thread.sleep(3000);
		addindividual.click();
	}
	
	
	public void addIndividual(String prefix1,String fname1,String mname1,String lname1,String suffix1,String cname1,String phnum,String type11,String add11,String add22,String city1,String pcode,String ctry,String type22,String usage1,String business,String title1 )
	{
		prefix.sendKeys(prefix1);
		fname.sendKeys(fname1);
		mname.sendKeys(mname1);
		lname.sendKeys(lname1);
		suffix.sendKeys(suffix1);
		cname.sendKeys(cname1);
		phone.sendKeys(phnum);
		
		Select s1=new Select(type1);
		s1.selectByVisibleText(type11);
		
		add1.sendKeys(add11);
		add2.sendKeys(add22);
		city.sendKeys(city1);
		postalcode.sendKeys(pcode);
		
		Select s2=new Select(country);
		s2.selectByVisibleText(ctry);
		
		
		Select s3=new Select(type2);
		s3.selectByVisibleText(type22);
		
		
		Select s4=new Select(usage);
		s4.selectByVisibleText(usage1);
		
		mybusiness.sendKeys(business);
		
		title.sendKeys(title1);
		
		done.click();
	
	}
	public void validation() throws Exception
	{
	
		String Expected="Dr John Danny Danny Boyic Jr ";
		Thread.sleep(6000);
		String Actual=text.getText();
		
		if(Expected.equals(Actual))
		{
			System.out.println("Test case passed");
		}
	}

}
