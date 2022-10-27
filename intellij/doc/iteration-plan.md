# Iteration Plan 1

### Things we need to accomplish in order
- Search song
  - Why: In order to find what song you want to play
  - How: Type in search box or input text (for text iteration) that returns a list of songs/playlists/profiles that closely resemble the search query
  

- Add/remove song to playlist
  - Why: To better personalize what you want to listen to
  - How: Adds song to a list of pointers that point to the song ID's


- Like song
  - Why: In order to make a list of songs that you love the most
  - How: Adds song to a pre-made playlist titled "Liked songs"
  - Other: "Liked songs" cannot be deleted


- Database
  - Figure out how we are going to store song data


## Note on limitations for iteration one
Being as it is a song playing application, the first iteration of playing the song will just be a text output of "Song playing"

The first iteration will focus more on communicating with the database. Being able to search a song id and songs close the search query will be our main focus.

We will also be setting up the database to be able to hold user playlists, liked songs, preferences, and profile components. 

Therefore, the first iteration of this project will be focused more on the backend of the project, instead of the main goal of our app.

Once we move over to Android Studio we will be able to play songs and make the various viewing panes. This will need to rely on the first iteration heavily though, in order to give us more time to make the app better looking and more usable. 