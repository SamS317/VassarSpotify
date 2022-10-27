# Test Report

## How prototype was tested

- User was created with Username as Connor and password as Genius
- User is originally asked to login (l) or create account (c)
- If login
  - It asks user for username then password
  - Then asks whether the user wants to search for a song (s) or play a song (p) or logout (l)
    - If user searches then user is asked to search for a song by either title (s) or artist (a)
      - if search for s then asks for song name and then filters all the songs from SongDatabase.java by artist and prints out
        - Then asks user again if they want to search play or logout
        - ![](/Users/samshurin/Desktop/VassarSpotify/cmpu203-team-d/doc/markdown-images/test-report-pic1.png)
      - if search for artist then asks for artist name and then filters all the songs from SongDatabase.java by artist and prints out
        - Then asks user again if they want to search play or logout
        - ![](../../../../../../var/folders/83/06c534fn271_8fgls3h66p5h0000gn/T/TemporaryItems/NSIRD_screencaptureui_WfaRg7/Screen Shot 2022-10-14 at 11.24.21 PM.png)
    - If user chooses p or play (Capitalization doesn't matter)
      - If no song is in search queue then it tells user to search for a song first
        - ![](../../../../../../var/folders/83/06c534fn271_8fgls3h66p5h0000gn/T/TemporaryItems/NSIRD_screencaptureui_ZZJL9B/Screen Shot 2022-10-14 at 11.28.47 PM.png)
      - If there is at least 1 one song it asks which song it wants to play from the list and when the user chooses by typing the number of the list it prints playing the song
        - ![](../../../../../../var/folders/83/06c534fn271_8fgls3h66p5h0000gn/T/TemporaryItems/NSIRD_screencaptureui_I56rlW/Screen Shot 2022-10-14 at 11.31.56 PM.png)
    - If user chooses l or logout (Capitalization doesn't matter)
      - User is asked if they want to sign in to another account (y) or (n)
        - Yes would bring up original screen and no would quit the program
        - ![](../../../../../../var/folders/83/06c534fn271_8fgls3h66p5h0000gn/T/TemporaryItems/NSIRD_screencaptureui_UTU0Qd/Screen Shot 2022-10-14 at 11.33.42 PM.png)
-If create:
  - It asks for Username and password and retype password
  - If no username not taken and password match it will login automatically and ask user what they want to do
    - ![](../../../../../../var/folders/83/06c534fn271_8fgls3h66p5h0000gn/T/TemporaryItems/NSIRD_screencaptureui_JYzVKx/Screen Shot 2022-10-14 at 11.37.12 PM.png)
  - If passwords dont match it tells them and asks to login or create account again
    - ![](../../../../../../var/folders/83/06c534fn271_8fgls3h66p5h0000gn/T/TemporaryItems/NSIRD_screencaptureui_lYNTkN/Screen Shot 2022-10-14 at 11.42.17 PM.png)