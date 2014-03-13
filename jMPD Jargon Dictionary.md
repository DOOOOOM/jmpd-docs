jMPD Jargon Dictionary
======================


**client**: A third party application that communicates with a server or daemon. They are generally used to retrieve information from the daemon, but they can also send requests to control or modify the behavior of it.

**configuration file**: A .properties file used to store key-value pairs for the daemon to use for configuration.

**daemon**: A program that operates in the background, outside of user control. Daemons are usually initialized after the operating system (Windows/Mac OSX/Linux) boots, and provide some kind of service.

**database**: A file or group of files used to efficiently store data on a computer. In the case of this application, the database stores information on each audio file that the daemon has access to. See also _library_

**filesystem path**: The information an operating system uses to locate a folder on the computer. Typical music folder paths would be "C:\Users\Owner\Music" for Windows, or "/home/user/music" for Unix-like operating systems.

**IP address**: The information a program uses to locate a website, another program, or computer on a network. IP stands for "Internet Protocol". For our purposes, the most common IP address will be 127.0.0.1, also called "localhost".

**library**: The collection of audio files and information stored in the database by the daemon. See also _database_

**multi-select**: The ability to select and perform actions on more than one track at once in the client GUI

**playlist**: A named, ordered list of audio files stored by the daemon.

**play queue**: The ordered list of audio files that are in queue to be played. Under the hood it is a special type of playlist. See also _playlist_

**port**: A software data connection that allows for information to be shared via a network. All information retrieved from the internet must first pass through a port.

**scrobbling**: Users of Last.fm, a music website, can have a record of the music they listen to stored to their online profile. This process is called "scrobbling". Last.fm uses this information to suggest similar artists that may interest the user, notify them of new releases, and nearby concerts.

**track**: A single audio file in the library; it could also refer to one element to an ordered list of songs

**lyrics**: a transcript of the words used in a song
