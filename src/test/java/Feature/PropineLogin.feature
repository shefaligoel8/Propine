Feature: Date Validation on form

  Scenario Outline:  User wants to enter the delivery date on form and validate for <Scenario>
    Given I am a website user
    When  I enter "<Date>" on the input field and click Submit button
    Then  I should see a date on the form with a "<Value>" for the "<Scenario>"

    Examples:
      | Date            | Scenario | Value |
      | 11-17-2020      | Positive |       |
      | 09-17-20        | Positive |       |
      | 17-July-2020    | Positive |       |
      | 20-August-20    | Positive |       |
      | 17-Aug-2020     | Positive |       |
      | 17-Oct-20       | Positive |       |
      | 27-06-2020      | Positive |       |
      | 17-08-20        | Positive |       |
      | July-20-2020    | Positive |       |
      | July-17-20      | Positive |       |
      | Jul-10-2020     | Positive |       |
      | Jul-09-20       | Positive |       |
      | 12/17/2020      | Positive |       |
      | 07/11/20        | Positive |       |
      | 10/August/2020  | Positive |       |
      | 17/August/20    | Positive |       |
      | 10/Sep/2020     | Positive |       |
      | 20/Jul/20       | Positive |       |
      | 19/07/2020      | Positive |       |
      | 27/08/20        | Positive |       |
      | October/17/2020 | Positive |       |
      | August/10/20    | Positive |       |
      | Jul/17/2020     | Positive |       |
      | Sep/17/20       | Positive |       |
      | 12 10 2020      | Positive |       |
      | 12 10 20        | Positive |       |
      | 11 17 2020      | Positive |       |
      | 07 17 20        | Positive |       |
      | 17 July 2020    | Positive |       |
      | 19 July 20      | Positive |       |
      | 17 Aug 2020     | Positive |       |
      | 15 Sep 20       | Positive |       |
      | October 17 2020 | Positive |       |
      | July 17 20      | Positive |       |
      | Jun 19 2020     | Positive |       |
      | Jul 17 20       | Positive |       |
      | 10*10*2020      | Negative | Invalid date |
      | 10.12.2020      | Negative | Invalid date |
      | 10&11&2020      | Negative | Invalid date |
      | 11@10#2020      | Negative | Invalid date |
      | 10$12%2020      | Negative | Invalid date |
      | 2009(10%10      | Negative | Invalid date |
      | 20221010        | Negative | Invalid date |
      | 10-09-2019      | Negative | Invalid date |
      | 10/09/2001      | Negative | Invalid date |
      | 10 09 2019      | Negative | Invalid date |
      | 10-ju-2020      | Negative | Invalid date |
      | 10/Au/2020      | Negative | Invalid date |
      | 10102020        | Negative | Invalid date |
      | 17:10:2020      | Negative | Invalid date |
      | 17-10-2020 12:30:00 | Negative | Invalid date |
      | 10-2020-10      | Negative | Invalid date |
      | 10/2020/10      | Negative | Invalid date |
      | 10 2020 10      | Negative | Invalid date |
      | 2020-10-10      | Negative | Invalid date |
      | 2020/10/11      | Negative | Invalid date |
      | 2020 10 12      | Negative | Invalid date |





