from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/tables")
    title=driver.title
    print("Title of the page is: ",title)

    rows=driver.find_elements(By.XPATH, "//table/tbody/tr")
    print("No. of Rows: ",len(rows))

    columns=driver.find_elements(By.XPATH, "//table/tbody/tr[1]/td")
    print("No. of Columns: ",len(columns))

    value=driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[2]")
    print("Book Name in 5th Row before sorting: ",value.text)

    driver.find_element(By.XPATH,"//table/thead/tr/th[5]").click()

    value1=driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[2]")
    print("Book Name in 5th Row after sorting: ",value1.text)

    
    

