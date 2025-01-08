from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-attributes")
    title=driver.title
    print("Title of the page is: ",title)

    driver.find_element(By.XPATH,"//input[starts-with(@id,'full-name-')]").send_keys("Nethra S")
    driver.find_element(By.XPATH,"//input[contains(@id,'-email')]").send_keys("nethras@abc.com")
    driver.find_element(By.XPATH,"//input[contains(@name,'-event-date-')]").send_keys("2025-01-08")
    driver.find_element(By.XPATH,"//textarea[contains(@id,'-additional-details-')]").send_keys("Selenium Training")
    driver.find_element(By.XPATH,"//button[text()='Submit']").click()
    message=driver.find_element(By.ID,"action-confirmation").text
    print("Message is: ", message)

