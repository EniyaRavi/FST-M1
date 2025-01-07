from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

with webdriver.Firefox() as driver:
    wait = WebDriverWait(driver, timeout=10)
    driver.get("https://training-support.net/webelements/dynamic-controls")
    title=driver.title
    print("Title of the page is: ",title)

    checkbox=driver.find_element(By.ID,"checkbox")
    print("Is Checkbox visible: ",checkbox.is_displayed())

    driver.find_element(By.XPATH,"//button[text()='Toggle Checkbox']").click()
    wait.until(EC.invisibility_of_element(checkbox))

    driver.find_element(By.XPATH,"//button[text()='Toggle Checkbox']").click()
    wait.until(EC.element_to_be_clickable(checkbox)).click()

    print("Is Checkbox selected: ",checkbox.is_selected())

    