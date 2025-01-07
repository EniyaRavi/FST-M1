from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/drag-drop")
    title=driver.title
    print("Title of the page is: ",title)

    actions=webdriver.ActionChains(driver)

    ball=driver.find_element(By.ID, "ball")
    dropZone1=driver.find_element(By.ID, "dropzone1")
    dropZone2=driver.find_element(By.ID, "dropzone2")

    actions.drag_and_drop(ball, dropZone1).perform()
    if(driver.find_element(By.CLASS_NAME, "dropzone-text").text=="Dropped!"):
        print("Ball is dropped in DropZone 1!!")
              
    actions.drag_and_drop(dropZone1, dropZone2).perform()
    if(driver.find_element(By.CLASS_NAME, "dropzone-text").text=="Dropped!"):
        print("Ball is dropped in DropZone 2!!")

    