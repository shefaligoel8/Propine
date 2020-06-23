Feature: Date Validation on form

  Scenario Outline:  User wants to enter the delivery date on form.
      Given I am a website user
      When  I enter "<Date>" on the input field and click Submit button
      Then  I should see a date on the form with a "<Value>" for the "<Scenario>"
      
Examples:
|Date          |Scenario|Value|
#|17-Aug-2020   |Positive|NA|
|17-Oct-20     |Positive|NA|
#|27-06-2020    |Positive|NA|
#|17-08-20      |Positive|NA|
#|July-20-2020  |Positive|NA|
|July-17-20    |Positive|NA|
#|Jul-10-2020   |Positive|NA|
|Jul-09-20     |Positive|NA|
|11-17-2020    |Positive|NA|
|09-17-20      |Positive|NA|









