from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/selects")
    title=driver.title
    print("Title of the page is: ",title)

    dropdown=driver.find_element(By.CSS_SELECTOR,"select.h-10")
    select= Select(dropdown)

    select.select_by_visible_text("Two")
    print("Second option is: ", select.first_selected_option.text)

    select.select_by_index(3)
    print("Third Option is: ",select.first_selected_option.text)

    select.select_by_value("four")
    print("Fourth Option is: ",select.first_selected_option.text)

    options=select.options
    print("Options in dropdown:")
    for option in options:
        print(option.text)