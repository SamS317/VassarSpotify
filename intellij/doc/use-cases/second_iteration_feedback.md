Team D - Vassar "Spotify" - Sam & Connor M

1. Requirements analysis update
    - Brief use cases are a big improvement. Still, comments:
      - For searching, optimal should be defined: when multiple items match the search criteria, what is displayed at the top? 
      - Comment from prior iteration that still applies: play/pause/skip are so simple that they could be part of a single use case, "manage playback". 
      - Upload song should ask for song metadata such as title and such, no?
      - A "View dashboard"-type use case is still missing.

    - Fully dressed use cases were not updated in any meaningful way. Progress on use case analysis should be made every iteration, so we're never in a position where we're designing and implementing something we haven't analyzed before.


2. Design

    2a. Domain model
      - Good overall. Minor note: it's unclear to me why Profile and User are separate classes. 
      - In the future you may want to add additional concepts such as as Genre, or Album.


    2b. Class diagram
      - Attribute data types and visibility are missing.
      - Method visibility, parameter list, and return value types are missing.
      - Song, Controller, and View methods are listed as attributes: methods need to be in its own segment within the class rectangle. Three segments total. From the top: class name, attributes, methods.
      - SongDatabase is missing a collection of Song objects as an attribute, which is the main purpose of the class?
      - You're showing general associations between classes, but in some classes that are more meaningful specific associations you can show. For example, composite aggregation between SongDatabase and Song, annotated with a name for the collection of songs stored on the song database.
      - Class names should follow UpperCamelCase convention, to make them easier to identify (profileDatabase -> ProfileDatabase).

 
    2c. Sequence diagrams
      - The two diagrams represent the same use case combination, with the second being an improvement of the first that shows the data being passed around between objects. Therefore the first diagram should be removed. 
     - Usually there is one diagram per use case - I.e., searching and playing would be separated.
     - Alternatives, e.g., searching by title vs searching by artist, should be shown using alt frames (see lecture notes). In order to make your search function more general and easily extensible, I encourage you to consider the use of a filter hierarchy. Filter would be an interface that can be implemented in different ways to match songs by different characteristics.



3. Prototype

    3a. Coding
      - Good MVC implementation, with clear separation between view, controller, and model.
      - To make searching more efficient, you may want to consider having maps to efficiently look songs up by title, artist, or some other characteristic.
      - Unused field "a" should be removed from Controller.
      - Unused field "is_logged_in" should be removed from View class. 
      - View's main method could be decomposed into smaller helper methods, for readability. A main loop with a switch-case for commands and helper methods to run each command would make a lot of sense. I suggested this in lab. 



    3b. Functionality
      - Amount of functionality is good for a first prototype.
      - It'd be nice to be able to partially match song titles or artists, instead of having to match them exactly.
  

    3c. Testing
      - Testing report seems reasonable. However, it refers to images that are not part of the git repo, so I can't see them.


4. Iteration 2 plan
    - Unclear what "Get selection of a song through a button in multiple forms" means.
    - Agree that song upload would be a good use case to tackle.

5. General feedback
   - The readme is great.
   - Your submission is missing the iteration1-submission tag.
   - A good improvement over the prior submission, but I know you can do better still.