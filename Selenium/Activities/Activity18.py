from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/alerts")
    title=driver.title
    print("Title of the page is: ",title)

    wait = WebDriverWait(driver, timeout=10)

    driver.find_element(By.ID,"simple").click()

    alert=wait.until(EC.alert_is_present())

    print("Text in Alert is: "+alert.text)

    alert.accept()
    print("Message is: ",driver.find_element(By.ID,"result").text)

    

