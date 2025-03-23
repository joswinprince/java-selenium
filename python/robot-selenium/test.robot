*** Settings ***
Library  SeleniumLibrary

*** Test Cases ***
Open Browser Test
    Open Browser    https://www.google.com    Chrome
    
    Sleep  3s
    Close Browser
