from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/tabs")
    title=driver.title
    print("Title of the page is: ",title)
    print("Current Tab is: "+driver.current_window_handle)

    wait = WebDriverWait(driver, timeout=10)

    driver.find_element(By.XPATH,"//button[text()='Open A New Tab']").click()

    wait.until(EC.number_of_windows_to_be(2))

    handles=driver.window_handles
    for handle in handles:
        driver.switch_to.window(handle)

    wait.until(EC.element_to_be_clickable(driver.find_element(By.XPATH,"//button[text()='Open Another One']")))
    print("Newly Opened tab is: ",driver.current_window_handle)
    print("New Page Title is:",driver.title)
    print("Message in Newly Opened tab is: ",driver.find_element(By.CSS_SELECTOR, "h2.mt-5").text)
    
    driver.find_element(By.XPATH, "//button[text()='Open Another One']").click()

    wait.until(EC.number_of_windows_to_be(3))

    for handle in handles:
        driver.switch_to.window(handle)

    print("2nd Newly Opened tab is: ",driver.current_window_handle)
    print("2nd New Page Title is:",driver.title)
    print("Message in 2nd Newly Opened tab is: ",driver.find_element(By.CSS_SELECTOR, "h2.mt-5").text)






