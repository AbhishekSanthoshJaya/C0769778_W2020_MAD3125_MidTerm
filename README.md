
# C0769778_W2020_MAD3125_MidTerm

## CANADA TAX CALCULATOR

## PROJECT CONTRIBUTORS

Abhishek Santhosh Jaya

## PROJECT REQUIREMENTS

1. Create three screens to perform given task
    a. Splash Screen with your Image, Name and Student ID (5 sec)
    b. Person Information entry screen
    c. Data display after tax calculation
2. Create all required file in appropriate packages.
3. Make user of appropriate views (Material Components) to design UI
4. User appropriate naming conventions.
5. Apply validation wherever applicable.
6. Use Number formatting and Currency Symbol (left drawable image)
7. Disable submit button if person age is < 18 and display message “Not
eligible to file tax for current year 2019” in RED Bold color
8. Upload ZIP file after deleting build folder and paste GitHub link in comments
9. Passing Data to next screen as an Object (Implement Parcelable)
10. Appropriate screen design and icons

## PROJECT OUTPUT
Screenshot | Description
--- | ---
<img src="https://i93.servimg.com/u/f93/18/45/29/87/splash10.jpg" alt="splash"/> | Splash screen that lasts 5 seconds. Used gif handling.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/dataen10.png" alt="DataEntry"/> | Data entry screen for the app. An audio hint plays that asks users to fill the form. Has checks on each field to see if it is empty. Date of filing is set to currentdate. Touching date of filing field will bring up a material alert dialog warning the user.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/datepi10.png" alt="datepicker"/> | On touching the birthdate field, a date picker pops up.
<img src="https://i.servimg.com/u/f93/18/45/29/87/screen12.png" alt="alert"/> | Alert box shows up on clicking the tax filing date field.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/age_an10.png" alt="errors"/> | Validations for SIN number using regex and age. Buttons disappear if the applicant is not over 18.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/detail10.png" alt="details1"/> | Details for the customer including all the tax information.
<img src="https://i93.servimg.com/u/f93/18/45/29/87/detail10.jpg" alt="details2"/> | Second page of details.



## REFERENCES
* [Youtube.com](https://www.youtube.com/watch?v=hwe1abDO2Ag) - Creating a datePicker
* [Android.jlelse.eu](https://android.jlelse.eu/the-complete-android-splash-screen-guide-c7db82bce565) - Creating a splashscreen
* [Stackoverflow.com](https://stackoverflow.com/questions/3646415/how-to-create-edittext-with-rounded-corners) - Creating custom textboxes
* [Joda.org](https://www.joda.org/joda-time/index.html) - Working with Joda-Time
* [Howtodoinjava.org](https://howtodoinjava.com/java/calculate-age-from-date-of-birth/) - Calculating age using Joda
* [Stackoverflow.com](https://stackoverflow.com/questions/20082855/regular-expression-for-canadian-sin-social-insurance-number) - SIN validation regex
* [Sitepoint.com](https://www.sitepoint.com/transfer-data-between-activities-with-android-parcelable/) - Data transfer between activities using parcelable
* [Journaldev.com](https://www.journaldev.com/14748/android-textinputlayout-example) - Working with textfields using Material Design
