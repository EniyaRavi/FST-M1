from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/login-form")
    title=driver.title
    print("Title of the page is: ",title)

    driver.find_element(By.ID, "username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

    message=driver.find_element(By.TAG_NAME,"h1").text
    print("Message after login is: ",message)
