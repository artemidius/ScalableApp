## DESCRIPTION

Sample app. Was done as a test assignment for a company after job interview.

## ASSIGNMENT

The aim of this test assignment is to build an App that connects to the Github API, shows the
public repositories of a particular user and then retrieves their respective last commits.
Prerequisites

The Project needs to compile and be executable on a state of the art Android
Phone. Use SDK Level 17 and above.

Do not use any 3rd party Library, except for the data persistency layer.

#### Task 1 - Connect to the Github API
Connect to the Github API to retrieve the list of public repositories in your Github Account. Alternatively,
use this account: ​ https://api.github.com/users/mralexgray/repos
This results in a list of public Repositories. Visualize the results in a Table. You are free to choose any
meaningful subset of data to show in each row.

#### Task 2 - Asynchronously load the last commit
Once the list has been populated, start retrieving information about the last commit for each repository.
This can be done with the following call:
https://api.github.com/repos/mralexgray/ACEView/commits
Where “​ mralexgray​ ” (see Task 1) is the user and “​ ACEView​ ” the repository under consideration. Again,
feel free to choose any meaningful subset of data to add to the row upon a successful response. Make
sure that the list is scrollable while data is loading.

#### Task 3 - Add a Data Persistency Layer (eg., Realm.io, SQLITE)
Add a Data Persistency Layer to store the Repository Information. Do not store the commit information.
Once this layer is there, change the app behavior in a way that the app first shows the content stored on
the phone and then requests Github for new data. Subsequently, that data is updated in the persistency
layer.
