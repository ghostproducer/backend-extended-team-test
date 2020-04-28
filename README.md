# Extended Team Test

This is my purposed solution for the Extended Team technical test. 

## The Task

Desired features, in order of priority:

- A user can come to the webpage and create a new poll. [x]

- The user should be able to specify a title for the poll, a brief description, and a list of options.

- After the poll is created, the user should be able to edit the poll, and modify anything they specified originally.

- After the poll is created, the user should be able to share their poll with their friends. This can be as simple as generating a link that they can have other people go to to respond to the poll.

- The user should be able to view a graph of the responses to their poll.

- A user responding to a poll should be able to edit their response. (You do not need to authenticate users attempting to edit responses)
- A user should be able to create an account that they can authenticate to with a username and password.

- The only information you need is a username and password. If email addresses are usernames, you do not need to validate the email address.

- Passwords must be securely stored.

- Rate-limiting of authentication requests and account lockout do not need to be implemented.

- A user should be able to associate all of their previously created polls with that account.

- The user, when authenticated, should be able to view all of the polls associated with their account.

- The user should be able to require all respondents to their polls authenticate before being able to respond to the poll.

### Tech Stack

For solving this test, the front end is treated as a separated part from backend. The front end was built using Angular 9, the back end was built using Java 8 + SpringBoot, and the database is being hosted in my private AWS RDS, in a MySQL database.

For quick testing the app in a ambient similar to a production environment, it was deployed in a CI/CD pipeline service known as heroku. The deployed version can be accessed in [this link](https://extended-team-test.herokuapp.com/). Everytime a new code was pushed to the master branch, the heroku pipeline automatically detects the changes, and built it in a certain url.

