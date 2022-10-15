# Vassar Spotify

## Project Description
>Vassar Spotify is a music platform in which you can play top songs from hit artists. Our implementation will allow the user to become the artist they always wanted to be.  
>
>Uploading a song, creating your own album, and viewing statistics about your song are just some of the things our app can do.



## Functionality
>Current functionality includes logging in, creating account, searching for a song or artist, and playing a song.

### Creating an account
>Creating an account will need a username and a password, and each are stored in the profile class.

### Logging in
>Logging in will require a matching username and password, currently each are stored in raw code with pre-populated users, but later we will use a profileDatabase not stored locally

### Searching for song/artist
>Searching for a song or artist requires the user to input the song they want, and the Controller will return a list of closely resembled songs

### Playing a song
>Playing a song requires the user to first search for a song, then they can choose from a list of songs that our program chose to best fit the query



## Limitations with IntelliJ:

>Playing an audio file was found to be a redundant implementation because it would require a separate implementation in Android Studio.

>Right now we allow the user to search for a song, but without a database to store song data we have to manually create the song classes.
>Android Studio will allow us to implement a database and search songs in that database. Some method calls will change, and possibly the addition of another class to handle the back and forth between the model and the database.



## How to run
> The class that contains the main method is View.
> 
> There are no special commands to run the program, everything you need to know is printed to the standard output in the form of directions and allowed actions
>
> Uppercase or lowercase can be submitted into the standard input 


