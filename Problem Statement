jMPD Problem Statement
======================


**1.0 Introduction**

The Java Music Player Daemon (hereafter referred to as jMPD or “the daemon”) is going to be a music player platform that services requests from clients. A client called Java Music Player Client (jMPC or “the client”) is going to be included in this implementation for the purpose of demonstration.

**2.0 Playback**

The jMPD shall handle all music playback by performing the standard music player control functions: pausing, playing, stopping, and skipping to the previous or next track. The user shall not interact with or control the daemon directly. If the user has integrated their Last.fm account into the daemon, each track played will be “scrobbled” (recorded) to Last.fm’s servers.

**2.1 Database**

A database shall be implemented to store information about the user’s library. For each audio file the database shall store:
* The filesystem path to the file
* A unique ID number assigned on import to the database
* Track name
* Artist name
* Album name
* Year of publication
* Track number
* Total tracks on the album
* The filesystem path to the file’s album art

It should be noted that all of these fields except for the path to the file shall be optional. There shall be a command to trigger an update of the database. This command will rescan the user’s defined music library folder and add new audio files to the database.

**2.2 Configuration**

Once initialized, jMPD shall attempt to load a configuration file from a predefined location. This configuration file shall contain:
* The IP and port number to listen for client connections
* The password to be used for authentication (optional)
* The path to the user’s music folder
* The path to the database file
* The path to the user’s playlist folder
* The user’s Last.fm account information

**2.3 Client Connections**

The daemon shall listen on a predefined port for commands from any connected clients. These connections shall be the only method of manipulating jMPD. Information requested by a client shall be sent back through this port. Clients will be optionally authenticated with a password to prevent unauthorized use of the music player.

**2.4 Play Queue**

Internally, jMPD shall implement a playlist workspace called the Play Queue. This play queue will allow the user to quickly construct playlists. All music playback shall happen from this play queue.

**2.5 Playlists**

jMPD shall read user created playlists from files stored in the playlist folder. Playlists shall still be accessed (played) from the play queue.

**3.0 Client**

The client, jMPC, shall be a user controlled application that connects to a jMPD server and makes use of its exposed features while giving high level control to the user.

**3.1 Controls**

The interface shall allow for controls as follows:
* playback controls, all only affecting the music in the current play queue
    * play
    * pause
    * stop
    * previous track
    * next track
    * volume control

The interface will combine the pause and play buttons into a single toggle button; displaying the opposite symbol or text of the current play state.

**3.2 Displayed Information**

The client shall show the user information on the track currently playing, pulled from the server’s database, including:
* Track name
* Artist name
* Album name
* Year of publication
* Track number
* Total tracks on the album
* Album art

If any of these are unavailable, the client shall not display the information, or display text to indicate that the data is unavailable.

The client shall show the user a list of tracks available on the server, and allow the user to browse server’s music database.  The list shall include details about each track that user chooses, including anything listed at the beginning of this section.  The client shall allow the user to filter the list of music by artist, then by album. Albums will be ordered alphabetically by default, or by any other detail if the user changes a configuration option.

**3.3 Playlists**

A playlist shall consist of a name and a list of songs, stored by ID.  The client shall have the ability to edit playlists with the following functions:
* Create playlist
* Delete playlist
* Insert song into playlist (at any position)
* Remove song from playlist
It shall also send and receive playlists with the daemon.

**3.4 Web Retrieved Data**

The client shall fetch album art from Last.fm if no art is found in the audio file itself. This retrieved album art will be saved into the audio file if the user enables it in the client configuration.

Lyrics for the currently playing track will be fetched from a variety of lyrics websites, based on their availability, and displayed in a side pane. If no lyrics are found a “No lyrics found.” message will be displayed.

**3.5 Visualizer**

jMPC will implement a simple visualizer for the user to gaze at listlessly while they enjoy their music. It will display a live waveform or spectrum of the current audio.
