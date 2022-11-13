@startuml
'''Domain Model
hide circle
hide empty methods
hide empty attributes

class User{
name
bio
}

class ProfileDatabase{
}

class Profile{
email
password
dateCreated
}

class SongDatabase{
}


class Song{
id
name
artist
fileLocation
}

class Playlist{
duration
name
}

User "1" -down- "*" Playlist : \t created \t
User "1" -left- "*" Song : \t uploads \t\t
User "1" - "*" User : follows \t

ProfileDatabase "1" -down- "*" User : \t stores \t
ProfileDatabase "1" -left- "*" Profile : \t stores \t

Playlist "1" -up- "*" Song : contains \t

SongDatabase "1" - "*" Song : \t contains \t\t
@enduml

@startuml
'''Play a song
actor User
participant View
control Controller
entity SongDatabase


User -> View: Inputs Song Title
User -> View: Inputs Artist Name
View -> Controller: SearchSongName
View -> Controller: SearchArtistName
Controller -> SongDatabase: SearchSongName
Controller -> SongDatabase: SearchArtistName
SongDatabase -> Controller: songList
SongDatabase -> Controller: songList
Controller -> View: songList
Controller -> View: songList
View -> User: Choose song from list
View -> User: Choose artist from list
User -> View: Chooses song from list
View -> Controller: playSong
Controller -> SongDatabase: playSong
SongDatabase -> Controller: returns True
Controller -> View: returns True
View -> User: Plays song

@enduml

@startuml
'''Class diagram
hide empty methods
hide empty attributes

class MainActivity{
{method} onCreate
{method} searchAdded
{method} Login
{method} CreateUser
{field} currentSearch
{field} mainView
}

class ProfileDatabase{
{method} addProfile
{method} getProfiles
{field} profiles
}

class SearchFragment{
{method} onCreateView
{method} onViewCreated
{method} getRootView
{method} updateSearchDisplay
}

class Profile{
{method} getUsername
{method} checkLogin
{field} username
{field} password
}

class Song{
{field} songName
{field} artist
{method} getSongName
{method} getArtist
{method} toString
}

class SongDatabase{
{field} songListReturn
{field} songList
{method} searchSong
{method} searchArtist
{method} searchSongandArtist
{method} play
}

class LoginFragment{
{method} onCreateView
{method} onViewCreated
{method} successfullyLoggedIn
{method} getRootView
{field} binding
{field} listener
}

class MainView{
{field} fmanager
{field} binding
{method} getRootView
{method} displayFragment
}


MainActivity --> ProfileDatabase
MainActivity --> SongDatabase

SearchFragment -->  MainActivity

LoginFragment -->  MainActivity

MainView --> MainActivity


ProfileDatabase --> Profile
SongDatabase --> Song

@enduml