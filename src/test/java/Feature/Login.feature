Feature: Date Validation on form

  Scenario Outline:  User wants to enter the delivery date on form.
      Given I am a website user
      When  I enter "<Date>" on the input field and click Submit button
      Then  I should see a date on the form with a "<Value>" for the "<Scenario>"

Examples:
|Date          |Scenario|Value|
|17-March-2020 |Positive|NA|
|17-March-20   |Positive|NA|
|17-Mar-2020   |Positive|NA|
|17-Mar-20     |Positive|NA|
|17-03-2020    |Positive|NA|
|17-03-20      |Positive|NA|
|March-17-2020 |Positive|NA|
|March-17-20   |Positive|NA|
|Mar-17-2020   |Positive|NA|
|Mar-17-20     |Positive|NA|
|03-17-2020    |Positive|NA|
|03-17-20      |Positive|NA|
|17/March/2020 |Positive|NA|
|17/March/20   |Positive|NA|
|17/Mar/2020   |Positive|NA|
|17/Mar/20     |Positive|NA|
|17/03/2020    |Positive|NA|
|17/03/20      |Positive|NA|
|March/17/2020 |Positive|NA|
|March/17/20   |Positive|NA|
|Mar/17/2020   |Positive|NA|
|Mar/17/20     |Positive|NA|
|03/17/2020    |Positive|NA|
|03/17/20      |Positive|NA|
|17 March 2020 |Positive|NA|
|17 March 20   |Positive|NA|
|17 Mar 2020   |Positive|NA|
|17 Mar 20     |Positive|NA|
|17 03 2020    |Positive|NA|
|17 03 20      |Positive|NA|
|March 17 2020 |Positive|NA|
|March 17 20   |Positive|NA|
|Mar 17 2020   |Positive|NA|
|Mar 17 20     |Positive|NA|
|03 17 2020    |Positive|NA|
|03 17 20      |Positive|NA|
|10*10*21      |Negative|Invalid date|
|10.11.2020    |Negative|Invalid date|
|10&11&2020    |Negative|Invalid date|
|11@10#2020    |Negative|Invalid date|
|10$12%2020    |Negative|Invalid date|
|2009(10%10    |Negative|Invalid date|
|10*10*21      |Negative|Invalid date|
|20221010      |Negative|Invalid date|
|10-09-1995    |Negative|Invalid date|
|10/09/2001    |Negative|Invalid date|
|10 09 1998    |Negative|Invalid date|
|10-ju-2020    |Negative|Invalid date|
|10/Au/2020    |Negative|Invalid date|
|10102020      |Negative|Invalid date|
|00000000      |Negative|Invalid date|
|99999999      |Negative|Invalid date|
|17:10:2020    |Negative|Invalid date|
|17-10-2020 12:30:00|Negative|Invalid date|
|10-2020-10    |Negative|Invalid date|
|10/2020/10    |Negative|Invalid date|
|10 2020 10    |Negative|Invalid date|
|2020-10-10    |Negative|Invalid date|
|2020/10/11    |Negative|Invalid date|
|2020 10 12    |Negative|Invalid date|








