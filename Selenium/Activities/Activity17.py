from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/selects")
    title=driver.title
    print("Title of the page is: ",title)

    dropdown=driver.find_element(By.CSS_SELECTOR,"select.h-80")
    select= Select(dropdown)

    select.select_by_visible_text("HTML")
    for i in range(3,5):
        select.select_by_index(i)

    select.select_by_value("nodejs")

    selectedOptions=select.all_selected_options
    print("Selected Options are")
    for option in selectedOptions:
        print(option.text)

    select.deselect_by_index(4)
    selectedOptions=select.all_selected_options
    print("Selected Options are")
    for option in selectedOptions:
        print(option.text)