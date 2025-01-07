from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/mouse-events")
    title=driver.title
    print("Title of the page is: ",title)

    actions=webdriver.ActionChains(driver)
    cargoLock=driver.find_element(By.XPATH, "//h1[text()='Cargo.lock']")
    cargoToml=driver.find_element(By.XPATH, "//h1[text()='Cargo.toml']")
    src=driver.find_element(By.XPATH, "//h1[text()='src']")
    target=driver.find_element(By.XPATH, "//h1[text()='target']")

    actions.click(cargoLock).move_to_element(cargoToml).click().perform()
    message=driver.find_element(By.ID,"result").text
    print("Message is: ",message)
    actions.double_click(src).context_click(target).perform()
    actions.click(driver.find_element(By.XPATH, "//div[@id='menu']/div/ul/li[1]")).perform()
    message1=driver.find_element(By.ID, "result").text
    print("Message is: ",message1)