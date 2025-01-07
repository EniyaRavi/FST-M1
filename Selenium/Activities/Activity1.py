from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/")

    title=driver.title
    print("Title of the page is: ",title)

    driver.find_element(By.LINK_TEXT, "About Us").click()
    newTitle=driver.title
    print("Title of the page is: ",newTitle)

