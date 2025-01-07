from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    title=driver.title
    print("Title of the page is: ",title)

    checkbox=driver.find_element(By.ID,"checkbox")

    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    print("Is Checkbox displayed: ", checkbox.is_displayed())

    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    print("Is Checkbox displayed: ", checkbox.is_displayed())

