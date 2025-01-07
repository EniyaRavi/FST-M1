from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/keyboard-events")
    title=driver.title
    print("Title of the page is: ",title)

    actions=webdriver.ActionChains(driver)

    actions.send_keys("This is coming from Selenium").perform()
    pageTitle=driver.find_element(By.CSS_SELECTOR,"h1.mt-3").text
    print("Text is: ",pageTitle)