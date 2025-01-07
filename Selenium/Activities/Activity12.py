from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

with webdriver.Firefox() as driver:
    wait = WebDriverWait(driver, timeout=10)
    driver.get("https://training-support.net/webelements/dynamic-content")
    title=driver.title
    print("Title of the page is: ",title)

    driver.find_element(By.XPATH,"//button[text()='Click me!']").click()
    if(wait.until(EC.text_to_be_present_in_element((By.ID,"word"),"release"))):
        print("Word is: ", driver.find_element(By.ID,"word").text)

    
