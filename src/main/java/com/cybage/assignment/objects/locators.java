package com.cybage.assignment.objects;

public class locators
{
    /*---------------------------------------------Home Page locators ------------------------------*/
    public static final String  pageTitleText="ToolsQA";
    public static final String  HOME_PAGE_LOGO="//header//img[@src='/images/Toolsqa.jpg']";
    public static final String  homePageBanner="//div[@class='home-banner']//img";
    public static final String  elementTab="//div//div[@class='card mt-4 top-card'][1]";
    public static final String  formsTab="//div//div[@class='card mt-4 top-card'][2]";
    public static final String  alertFrameWindowTab="//div//div[@class='card mt-4 top-card'][3]";
    public static final String  widgetTab="//div//div[@class='card mt-4 top-card'][4]";
    public static final String  interactionsTab="//div//div[@class='card mt-4 top-card'][5]";
    public static final String  bookStoreApplicationTab="//div//div[@class='card mt-4 top-card'][6]";

    /*-----------------------------------------------Element Page locators-------------------------- */
    public static final String  elementPageHeaderText="Elements";
    public static final String  instruction="Please select an item from left to start practice";

    /*TextBox option locators */
    public static final String  textBoxPageHeaderText="Text Box";
    public static final String  textbox="//div[@class='element-list collapse show']//ul//li[1]";
    public static final String  mainHeader="//div[@class='main-header']";
    public static final String  fullNameLabel="//div//label[@id='userName-label']";
    public static final String  fullNameInput="//div//input[@id='userName']";
    public static final String  emailLabel="//div//label[@id='userEmail-label']";
    public static final String  emailInput="//div//input[@id='userEmail']";
    public static final String  currentAddressLabel="//div//label[@id='currentAddress-label']";
    public static final String  currentAddressInput="//div//textarea[@id='currentAddress']";
    public static final String  permanentAddressLabel="//div//label[@id='permanentAddress-label']";
    public static final String  permanentAddressInput="//div//textarea[@id='permanentAddress']";
    public static final String  submitButton="//button[@id='submit' and text()='Submit']";
    public static final String outputList="//div[@id='output']//p";

    /* CheckBox option locators */
    public static final String  checkBoxPageHeaderText="Check Box";
    public static final String  checkbox="//div[@class='element-list collapse show']//ul//li[2]";
    public static final String  toggle="//li//button[@title='Toggle']";
    public static final String  tickbox="//span[@class='rct-checkbox']";
    public static final String  expandButton="//div//button[@title='Expand all']";
    public static final String  collapseButton="//div//button[@title='Collapse all']";

    /* Radio option locators */
    public static final String  radiobutton="//div[@class='element-list collapse show']//ul//li[3]";
    public static final String  yesRadio="//div//input[@id='yesRadio']";
    public static final String  impressiveRadio="//div//input[@id='impressiveRadio']";
    public static final String  noRadio="//div//input[@id='noRadio']";
    public static final String  successText="//span[@class='text-success']";

    /* WebTable option locators */
    public static final String  webtables="//div[@class='element-list collapse show']//ul//li[4]";
    public static final String  addButton="//button[@id='addNewRecordButton']";
    public static final String  searchBox="//input[@id='searchBox']";
    public static final String  registrationForm="//div[@id='registration-form-modal']";
    public static final String  closeFormButton="//div[@class='modal-content']//button[@class='close']";
    public static final String  oddRowList="//div[@class='rt-tr -odd']";
    public static final String  cellData="//div[@class='rt-td']";
    public static final String  evenRowList="//div[@class='rt-tr -even']";

    /* Buttons option locators */
    public static final String  buttons="//div[@class='element-list collapse show']//ul//li[5]";
    public static final String  doubleClickButton="//div//button[@id='doubleClickBtn']";
    public static final String  rightClickButton="//div//button[@id='rightClickBtn']";
    public static final String  dynamicClickButton="//button[text()='Click Me']";
    public static final String  doubleClickMessage="//div//p[@id='doubleClickMessage']";
    public static final String  rightClickMessage="//div//p[@id='rightClickMessage']";
    public static final String  dynamicClickMessage="//div//p[@id='dynamicClickMessage']";

    /* Links option locators */
    public static final String  links="//div[@class='element-list collapse show']//ul//li[6]";
    public static final String  simpleLink="//div//a[@id='simpleLink']";
    public static final String  apiLink="//p//a[@id='created']";
    public static final String  apiResponse="//div//p[@id='linkResponse']//b";

    /* Broken Links-Images locators */
    public static final String  brokenLinksImages="//div[@class='element-list collapse show']//ul//li[7]";
    public static final String  validImage="(//div//img[@src='/images/Toolsqa.jpg'])[2]";
    public static final String  brokenImage="//div//img[@src='/images/Toolsqa_1.jpg']";
    public static final String  validLink="//a[contains(text(),'Valid Link')]";
    public static final String  brokenLink="//a[contains(text(),'Broken Link')]";

    /* Upload and Download locators */
    public static final String  uploadAndDownload="//div[@class='element-list collapse show']//ul//li[8]";
    public static final String  downloadButton="//div//a[@id='downloadButton']";
    public static final String  chooseFileButton="//input[@id='uploadFile']";
    public static final String  uploadFFilePath="//p[@id='uploadedFilePath']";

    /* Dynamic Properties locators */
    public static final String  dynamicProperties="//div[@class='element-list collapse show']//ul//li[9]";
    public static final String  enableAfterButton="//div//button[@id='enableAfter']";
    public static final String  beforeColorChangeButton="//div//button[@id='colorChange']";
    public static final String  afterColorChangeButton="//button[@class='mt-4 text-danger btn btn-primary']";
    public static final String  visibleAfterButton="//div//button[@id='visibleAfter']";

    /*-----------------------------------------------Form Page locators-------------------------- */
    public static final String  practiceForm="//div//li//span[contains(text(),'Practice Form')]";
    public static final String  firstName="//div//input[@id='firstName']";
    public static final String  lastName="//div//input[@id='lastName']";
    public static final String  userEmail="//div//input[@id='userEmail']";
    public static final String  genderList="//input[@name='gender']";
    public static final String  mobileNumber="//input[@id='userNumber']";
    public static final String  birthDayBox="//input[@id='dateOfBirthInput']";
    public static final String  monthPicker="//select[@class='react-datepicker__month-select']";
    public static final String  yearPicker="//select[@class='react-datepicker__year-select']";
    public static final String  datePicker="//div[@class='react-datepicker__week']//div[@role='option']";
    public static final String  selectSubject="//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']";
    public static final String  selectedSubjects="//div[@class='css-12jo7m5 subjects-auto-complete__multi-value__label']";
    public static final String  selectFromInput="//input[@id='subjectsInput']";
    public static final String  listOfChckbox="//input[@type='checkbox']";
    public static final String  uploadPicture="//input[@id='uploadPicture']";
    public static final String  currentAddress="//div//textarea[@id='currentAddress']";
    public static final String  selectState="//div[text()='Select State']";
    public static final String  selectCity="//div[text()='Select City']";
    public static final String  submit="//button[@id='submit']";
    public static final String  tableTitle="//div[@class='modal-title h4']";
    public static final String  tableHeader="//table//th";
    public static final String  tableRow="//table//tbody//tr";
    public static final String  closeForm="//button[@id='closeLargeModal']";

    /*-----------------------------------------------Alert,Frame,Wondows Page locators-------------------------- */
    public static final String  browserWindowOption="//div//li//span[text()='Browser Windows']";
    public static final String  alertsOption="//div//li//span[text()='Alerts']";
    public static final String  framesOption="//div//li//span[text()='Frames']";
    public static final String  nestedFramesOption="//div//li//span[text()='Nested Frames']";
    public static final String  modalDialogsOption="//div//li//span[text()='Modal Dialogs']";

    /* Browser Window Options */
    public static final String  newTabButton="//button[@id='tabButton']";
    public static final String  newWindowButton="//button[@id='windowButton']";
    public static final String  newWindowMessageButton="//button[@id='messageWindowButton']";

    /* Alert Options */
    public static final String  simpelAlert="//button[@id='alertButton']";
    public static final String  timerAlert="//button[@id='timerAlertButton']";
    public static final String  confirmationAlert="//button[@id='confirmButton']";
    public static final String  confirmResult="//span[contains(text(),'You selected')]";
    public static final String  sendMessagePromptAlert="//button[@id='promtButton']";
    public static final String  promptResult="//div[@class='mt-4 row']//span[@id='promptResult']";

    /* iFrame Options */
    public static final String  simpleFrameID="frame1";
    public static final String  scollableFrameID="frame2";
    public static final String  headerOfSimpleFrame="(//h1[@id='sampleHeading'])[1]";
    public static final String  headerOfScrollableFrame="(//h1[@id='sampleHeading'])[2]";

    /* Nested iFrame Options */
    public static final String  parentFrameID="frame1";
    public static final String  frameText="//body";

    /* Modal dialogs Options */
    public static final String smallModelButton="//button[@id='showSmallModal']";
    public static final String largeModelButton="//button[@id='showLargeModal']";
    public static final String smallModelHeader="//div[@class='modal-title h4']";
    public static final String smallModelText="//div[@class='modal-body']";
    public static final String smallModelCloseButton="//button[@id='closeSmallModal']";
    public static final String largeModelHeader="//div[@class='modal-title h4']";
    public static final String largeModelText="//div[@class='modal-body']//p";
    public static final String largeModelCloseButton="//button[@id='closeLargeModal']";

    /*-----------------------------------------------Widgtes Page locators-------------------------- */

    public static final String accordianOption="//div[@class='element-list collapse show']//ul//li[1]";
    public static final String autoCompleteOption="//div[@class='element-list collapse show']//ul//li[2]";
    public static final String datePickerOption="//div[@class='element-list collapse show']//ul//li[3]";
    public static final String sliderOption="//div[@class='element-list collapse show']//ul//li[4]";
    public static final String progressBarOption="//div[@class='element-list collapse show']//ul//li[5]";
    public static final String tabsOption="//div[@class='element-list collapse show']//ul//li[6]";
    public static final String tooltipsOption="//div[@class='element-list collapse show']//ul//li[7]";
    public static final String menuOption="//div[@class='element-list collapse show']//ul//li[8]";
    public static final String selectMenuOption="//div[@class='element-list collapse show']//ul//li[9]";

    /* Accordian Options */
    public static final String accordianSimple1="//div[@id='section1Heading']";
    public static final String accSimple1Body="//div[@id='section1Content']//p";
    public static final String accordianSplitted="//div[@id='section2Heading']";
    public static final String accSplittedBody1="(//div[@id='section2Content']/p)[1]";
    public static final String accSplittedBody2="(//div[@id='section2Content']/p)[2]";
    public static final String accordianSimple2="//div[@id='section3Heading']";
    public static final String accSimple2Body="//div[@id='section3Content']//p";

    /* AutoComplete Options */
    public static final String autoCompleteTextBox1="//input[@id='autoCompleteMultipleInput']";
    public static final String autoCompleteTextBox2="//input[@id='autoCompleteSingleInput']";
    public static final String multipleSelectionList="//div[@class='css-12jo7m5 auto-complete__multi-value__label']";
    public static final String singleSelectedValue="//div[@class='auto-complete__single-value css-1uccc91-singleValue']";

    /*Date Picker Options */
    public static final String datePickerBox1="//input[@id='datePickerMonthYearInput']";
    public static final String datePickerMonth="//select[@class='react-datepicker__month-select']";
    public static final String datePickerYear="//select[@class='react-datepicker__year-select']";
    public static final String datePickerWeeks="//div[@class='react-datepicker__week']";
    public static final String datePickerDates="//div[@class='react-datepicker__week']//div";

    public static final String datePickerBox2="//input[@id='dateAndTimePickerInput']";
    public static final String dateTimePickerMonthView="//div[@class='react-datepicker__month-read-view']";
    public static final String dateTimePickerMonth="//div[@class='react-datepicker__month-dropdown']//div";
    public static final String dateTimePickerYearView="//span[@class='react-datepicker__year-read-view--down-arrow']";
    public static final String dateTimePickerYear="//div[@class='react-datepicker__year-dropdown']//div";
    public static final String dateTimePickerDates="//div[@class='react-datepicker__week']//div";
    public static final String datePickerTime="//div[@class='react-datepicker__time']//li";





}
