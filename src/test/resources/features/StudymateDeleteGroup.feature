@regression,@ainura
  Feature:
    @ainura
    Scenario: Verifying the Admin deletes group from group page
      Given user is on studyMate application
      When user enters valid admin credentials "studymate@gmail.com" and "123123" and clicks login
      Then user should successfully login to studyMate application
      When user navigates and clicks on three dots on the Group page
      Then user should be able to see the delete button is displayed  and enabled
      When Delete confirmation popped up and user sees cancel and delete buttons are displayed and enabled
      Then user clicks on Delete confirmation and should be able sees that group was successfully deleted
