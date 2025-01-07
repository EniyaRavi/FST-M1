from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/login-form")
    title=driver.title
    print("Title of the page is: ",title)

    driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")
    driver.find_element(By.XPATH, "//input[@id='password']").send_keys("password")
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

    message=driver.find_element(By.XPATH,"//h1[contains(text(),'Success!')]").text
    print("Message after login is: ",message)

    # driver.get("https://training-support.net/")

    # title=driver.title
    # print("Title of the page is: ",title)

    # driver.find_element(By.XPATH, "//a[text()='About Us']").click()
    # newTitle=driver.title
    # print("New Title of the page is: "+newTitle)
