# Use Case Name: Play

### Scope
> Vassar Spotify Android Based Application

### Level
> User goal
>> Users goal is to play or pause a song

### Primary Actor
> User
>> The user will be pressing the button

### Stakeholders and interests
> User
>> Wants a song to be played/paused on demand when the play button is clicked
>>
>> Wants the screen to show what song is playing
>>
>> Wants the system to give more options such as skip, like, or add to playlist
>
> System
>> Wants the user to play/pause a song

### Preconditions
> A song must be on the screen with a play/pause button visible
>> i.e. the use case "search" should have been fulfilled to completion with output shown under search tab
>
> Song must be in the database

### Postconditions (Success variation)
> Song is playing/paused
>
> Play button changes to a pause button and vise versa (If current screen is play screen)
>
> Play screen pops open (If first time playing song)
>> Play screen has other buttons such as skip, like, or add to playlist

### Postconditions (Non-success scenario)
> Song can't be played for any number of reasons
>
> The screen should show the error that caused the song not to play

### Main success scenario (User is in search screen)
> Pre-condition
>> User has a song with actions (buttons) available on screen
>>
>> This case assumes the search use case has been fulfilled to completion
>
> (1) User presses button marked "play" next to a song in the list of songs
>
> (2) System plays songs audio
>
> (3) System opens up "play" screen
>> Play screen will have other features such as skip, like, or add to playlist
>
> (4) User enjoys the music/silence and has a pleasant day (hopefully)

### Main success scenario (User is in play screen)
> (1) User presses button marked "play" (or "pause") located near the bottom of the screen
>
> (2) System plays/pauses songs audio respectively
>
> (3) User enjoys the music and has a pleasant day


### Extensions
> 2.a => System can't find song in audio database
>> System outputs an error message to the screen

### Special requirements
> Application must be used on an android device
>
> Song plays with adjustable audio on "play" screen