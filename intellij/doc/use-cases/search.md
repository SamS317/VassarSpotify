# Use Case Name: Search

### Scope
> Vassar Spotify Android Based Application

### Level
> User goal
>> Users goal is to search for a song or artist

### Primary Actor
> User
>> The user will be inputting the text into the search field

### Stakeholders and interests
> User
>> Wants to be able to look up a song or artist
>>
>> Wants the system to give more options such as play, add to queue, or add to playlist
>>
>> Wants the system to show up with either
>>> (1) What the user was looking up
>>>
>>> (2) A song or artist that best matches the search field


>
> System
>> Wants the user to input a song that is in the database or a reasonable search query

### Preconditions
> None

### Postconditions (Success variation)
> Table-layout is filled with dynamically generated rows
>> Each row contains the song, the artists name, and three buttons to play, add to queue, and add to playlist

### Postconditions (Non-success scenario)
> A song can't be found in the database
>
> Songs that partially match will show up in the dynamically created table

### Main success scenario
> (1.a) User inputs text into the search box
>
> (1.b) User selects button marked "song" and/or "artist"
>
> (1.c) User clicks search button
>
> (2.a) System gathers boolean values associated with the "song" and "artist" buttons
>
> (2.b) System gathers input text from the search input box
>
> (2.c) System looks up song in database and gathers all songs that match search key and boolean values
>
> (2.d) System dynamically creates table with the list of songs
>
> (3) User can now select a song that they want


### Extensions
> 2.c.a => System can't find any song in audio database with given search query and boolean values
>> 2.c.a.a System tries to take a partial string from given input text and retries song database search
>>
>> 2.c.a.b System has list of recently played songs and will fill table with those songs
>>
>> 2.c.a.c System has list of songs (sort of an "if all else fails" list) that will dynamically fill
>>> System then outputs message (somewhere on screen) that the song couldn't be found and list was filled with top hits

### Special requirements
> Application must be used on an android device