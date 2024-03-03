# MavenProject_Ebay
# selenium-webdriver-java with TestNG Framework and POM Designpattern
#Framework implemented considering the below:

->Used WebDriver API to launch and interact with websites
->Used various techniques to find elements such as buttons, links, text, dropdowns, and more within a web application
->Used WebDriver API calls to interact with those elements such as clicking, entering and reading text, selecting options, handling popups and more
->Integrated the WebDriver API  - TestNG
->Organized test code using the Page Object Model
->Used various wait strategies to control the timing of scripts and avoid flaky tests
->Took screenshots during test executions
->Tested code listen for specific WebDriver events and perform additional actions, like logging test activity
->Customized the browser used in test execution
->Navigating multiple open tabs within a browser
->Used Custom actions using JavaScript for Ex - Taking screenshots and scroll to the webelement


# Page Object Model

#Some Advantages of Using POM
->Code maintenance becomes whole lot easier!!!
->Code becomes easier to be understood.
->Increase Code Reusability
->Decrease Code Duplication
->Decrease the amount of the code.
->Improves Code Readability.
#Implementation
->Create a class for each web page in a web application.
->Each page has identified WebEelments and page specific methods.
->Create PageBase class and put all the common elements and methods so that these elements and methods can be used across the framework.
->Make each page inherits PageBase class.


