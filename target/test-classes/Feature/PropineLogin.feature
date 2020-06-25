Feature: Date Validation on form

  Scenario Outline:  User wants to enter the delivery date on form.
      Given I am a website user
      When  I enter "<Date>" on the input field and click Submit button
      Then  I should see a date on the form with a "<Value>" for the "<Scenario>"
      
Examples:
|Date          |Scenario|Value|
|17-July-2020  |Positive|NA|
|20-August-20  |Positive|NA|
|17-Aug-2020   |Positive|NA|
|17-Oct-20     |Positive|NA|
|27-06-2020    |Positive|NA|
|17-08-20      |Positive|NA|
|July-20-2020  |Positive|NA|
|July-17-20    |Positive|NA|
|Jul-10-2020   |Positive|NA|
|Jul-09-20     |Positive|NA|
|11-17-2020    |Positive|NA|
|09-17-20      |Positive|NA|
|10/August/2020|Positive|NA|
|17/August/20  |Positive|NA|
|10/Sep/2020   |Positive|NA|
|20/Jul/20     |Positive|NA|
|19/07/2020    |Positive|NA|
|27/08/20      |Positive|NA|
|October/17/2020|Positive|NA|
|August/10/20  |Positive|NA|
|Jul/17/2020   |Positive|NA|
|Sep/17/20     |Positive|NA|
|12/17/2020    |Positive|NA|
|07/11/20      |Positive|NA|
|17 July 2020  |Positive|NA|
|19 July 20    |Positive|NA|
|17 Aug 2020   |Positive|NA|
|15 Sep 20     |Positive|NA|
|12 10 2020    |Positive|NA|
|12 10 20      |Positive|NA|
|Octobor 17 2020 |Positive|NA|
|July 17 20    |Positive|NA|
|Jun 19 2020   |Positive|NA|
|Jul 17 20     |Positive|NA|
|11 17 2020    |Positive|NA|
|07 17 20      |Positive|NA|
|10*10*20      |Negative|Invalid date|
|10.12.2020    |Negative|Invalid date|
|10&11&2020    |Negative|Invalid date|
|11@10#2020    |Negative|Invalid date|
|10$12%2020    |Negative|Invalid date|
|2009(10%10    |Negative|Invalid date|
|20221010      |Negative|Invalid date|
|10-09-2019    |Negative|Invalid date|
|10/09/2001    |Negative|Invalid date|
|10 09 2019    |Negative|Invalid date|
|10-ju-2020    |Negative|Invalid date|
|10/Au/2020    |Negative|Invalid date|
|10102020      |Negative|Invalid date|
|17:10:2020    |Negative|Invalid date|
|17-10-2020 12:30:00|Negative|Invalid date| 
|10-2020-10    |Negative|Invalid date|
|10/2020/10    |Negative|Invalid date|
|10 2020 10    |Negative|Invalid date|
|2020-10-10    |Negative|Invalid date|
|2020/10/11    |Negative|Invalid date|
|2020 10 12    |Negative|Invalid date|








