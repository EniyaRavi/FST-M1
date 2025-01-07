from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    title=driver.title
    print("Title of the page is: ",title)

    inputField=driver.find_element(By.ID, "textInput")
    print("Is Input field enabled: ",inputField.is_enabled())

    driver.find_element(By.ID, "textInputButton").click()
    print("Is Input field enabled: ",inputField.is_enabled())