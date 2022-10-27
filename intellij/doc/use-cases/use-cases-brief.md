# Use Case List

### Search
>Search for an SPP using the search input box
>
>Happy Path: 
> 
>> (1) User types in song name, artist, or playlist
>>
>> (2) System filters the results to have the most optimal result at the top

## Manage playback
### Play/Pause
> Play or pause the song in the play tab/pane 
> 
> Happy Path:
>> (1) User presses the button
>>
>> (2) System stops playing music if music was playing or plays music if no music has been playing 

### Like/unlike song/playlist
> Add/unadd song to "Liked Songs" playlist
> 
> Happy path: 
>> (1) User presses the like button
>>
>> (2) System adds the song/playlist to a list of liked songs/playlists if song/playlist is not already liked and removes if it is already in the list


### Replay song
>Restart song (if song has been playing for longer than 1 second) or play previously played song
>
>Happy path:  
>> (1) User presses the replay button
>>
>> (2) System replays the same song from the beginning if song was playing or plays the previous song played if applicable


### Skip song
> Play the next song in the queue
> 
>Happy path:
>> (1) User presses the skip song
>>
>> (2) System goes to the next song in the queue if applicable if not replays the current song played


### Add song/playlist to queue
> Adds a song/playlist to the queue of songs to be played
> 
> Happy path: 
>> (1) User searches for song/playlist
>> 
>> (2) System populates most optimal song based on search\
>> 
>> (3) User clicks on button to add song/playlist to queue
>> 
>> (4) System adds the song/playlist to next songs to be played 

### Add/remove song to playlist
> Add/removes a song in a playlist
> 
> Happy path:  
>> (1) User clicks on a playlist
>>
>> (2) System opens the playlist
>>
>> (3) User presses edit button
>>
>> (4) System allows changes to the playlist
>>
>> (5) User either presses delete button next to the song or searches for song to add
>>
>> (6) System gets rid of the song from playlist list or adds the new song to the playlist

### Share song
> Makes a link to a song that can be shared with others
> 
> Happy path: 
>> (1) User searches up a song either using search option or in playlist
>>
>> (2) System opens up the song
>>
>> (3) User clicks the share button
>>
>> (4) System gives user options of methods of sharing
>>
>> (5) User clicks on method they want to share
>>
>> (6) System shares the song with the preferred method


### Upload so
> Upload your personal song to your profile 
> 
> Happy path:
>> (1) User goes to profile and presses upload button 
>> 
>> (2) System opens page which gives options of which method of upload the user wants to use
>> 
>> (3) User chooses option and chooses file
>> 
>> (4) System uploads song to database and displays it in users profile under updated songs


### View Profile
> Open up your profile in the viewing pane
> 
> Happy path: 
>> (1) User presses profile icon
>> 
>> (2) System gets profile data from database
>>
>> (3) User can scroll and change their profile
>>
>> (4) System updates data in database if any changes


### Follow/unfollow profile
> Adds/unadds friend from following list
> 
> Happy path: 
>> (1) User searches for a user
>> 
>> (2) System displays the searched user profile
>> 
>> (3) User presses the heart to follow/unfollow
>> 
>> (4) System updates the info in database


### Create playlist
> Creates a new empty list
> 
> Happy path: 
>> (1) User presses new playlist button
>> 
>> (2) System creates a new list in database


### Remove playlist
> Deletes list of songs associated with this playlist
> 
> Happy path: 
>> (1) User presses the delete button in a playlist
>>  
>> (2) System gets rid of the list in the database


### Shuffle playlist
> Puts order of songs in playlist into a random order
> 
> Happy path: 
>> (1) User presses the shuffle button
>>
>> (2) System randomly shuffles the list and displays the songs in the random order in the playlist 


### View Artist
> Artist profile is shown in the viewing pane 
> 
>Happy path: 
>> (1) User searches for artist 
>> 
>> (2) System displays searched artist
>>
>> (3) User can look through artists songs and info


### Sort playlist
> Sorts playlist by artist
>
> Happy path:  
>> (1) User presses sort button
>>
>> (2) System sorts the list alphabetically and displays the songs alphabetically