jMPD/C Use Cases
==============

**Use Case 1: UserClicksTogglePlaybackButton**

**Overview:**

Allows user to pause or play music playback.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks playback toggle button | 1. Client sends "toggle" command to jMPD over port.
2. | 2. Client toggles button icon.
3. | 3. Server recieves command message.
4. | 4. Server parses command message, extracts "toggle" command.
5. | 5. Server executes command.

**Scenario Notes:**

If the jMPD detects that there are no tracks in the play queue, the toggle command has no effect. The client's toggle playback button icon shall always display the opposite of the player state. 

**Post Conditions:**

1. If the client was displaying the "play" icon (daemon paused), then it is now displaying the "pause" icon.
2. If the client was displaying the "pause" icon (daemon playing), then it is now displaying the "play" icon.
3. If the daemon was playing audio, it has now paused playback.
4. If the daemon was in the paused state, it is now playing audio starting from the same position where it was paused.

**Exceptions:**

1. The database cannot be accessed
2. The daemon is not running
3. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 2: UserClicksNextTrackButton**

**Overview:**

Allows user to skip forward to the next track in the play queue.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks next button | 1. Client sends "next" command to jMPD over port.
2. | 2. Server recieves command message.
3. | 3. Server parses command message, extracts "next" command.
4. | 4. Server executes command.
5. | 5. Client sends "info" command to jMPD.
6. | 6. Server recieves command message.
7. | 7. Server parses command message, extracts "info" command.
8. | 8. Server sends song info to client.
9. | 9. Client displays the new song information.

**Scenario Notes:**

If the jMPD detects that there are no tracks in the play queue, the next command has no effect. If there is no next track, jMPD will wrap the queue and play the first song.

**Post Conditions:**

1. The daemon is now playing the next song in the queue.
2. The client is now displaying the new song information.

**Exceptions:**

1. The database cannot be accessed
2. The daemon is not running
3. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 3: UserClicksPreviousTrackButton**

**Overview:**

Allows user to skip back to the previous track in the play queue.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks previous button | 1. Client sends "prev" command to jMPD over port.
2. | 2. Server recieves command message.
3. | 3. Server parses command message, extracts "prev" command.
4. | 4. Server executes command.
5. | 5. Client sends "info" command to jMPD.
6. | 6. Server recieves command message.
7. | 7. Server parses command message, extracts "info" command.
8. | 8. Server sends song info to client.
9. | 9. Client displays the new song information.

**Scenario Notes:**

If the jMPD detects that there are no tracks in the play queue, the prev command has no effect. If there is no previous track, jMPD will wrap the queue and play the last song.

**Post Conditions:**

1. The daemon is now playing the previous song in the queue.
2. The client is now displaying the new song information.

**Exceptions:**

1. The database cannot be accessed
2. The daemon is not running
3. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 4: UserClicksStopButton**

**Overview:**

Allows user to end playback and leave the daemon paused at the beginning of the current song.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks stop button | 1. Client sends "stop" command to jMPD over port.
2. | 2. Server recieves command message.
3. | 3. Server parses command message, extracts "stop" command.
4. | 4. Server executes command.

**Scenario Notes:**

If the jMPD detects that there are no tracks in the play queue, the stop command has no effect. 

**Post Conditions:**

1. The daemon is now paused at the beginning of the current track in the queue.

**Exceptions:**

1. The database cannot be accessed
2. The daemon is not running
3. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 5: UserUpdatesDatabase**

**Overview:**

Allows user to manually trigger an update of the jMPD database through the client GUI. Effectively lets the user add new songs to the library without restarting the client.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks "daemon" menu bar entry | 1. Client populates and expands the daemon menu.
2. User points cursor to the "update" item | 2. Client highlights the item with a contrasting background color.
3. User clicks "update" item | 3. Client sends "update" command to jMPD over port.
4. | 4. Server recieves command message.
5. | 5. Server parses command message, extracts "update" command.
6. | 6. Server rescans the configured music directory, returns the new/removed database entries to the client.
7. | 7. Client updates the library view to reflect the database changes.

**Scenario Notes:**

If the server returns and empty list in step 6, the client does nothing.

**Post Conditions:**

1. The daemon's database has been changed to reflect the changes to the music directory.
2. The client's GUI reflects the changes in the database.

**Exceptions:**

1. The database cannot be accessed
2. The music directory cannot be accessed
3. The daemon is not running
4. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View
2. jMPC_Menu_Bar
3. jMPC_Menu_Daemon_Entry
4. jMPC_Library_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 6: UserAddsTrackToPlayQueue**

**Overview:**

Allows user to append new tracks to the end of the play queue.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.
4. User is looking at jMPC_Library_View.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks on a track in the library. | 1. Client highlights the track entry with a contrasting background color.
2. User presses the 'a' key. | 2. Client sends the "add" command and the track id in an array to the daemon.
3. | 3. Server recieves command message.
4. | 4. Server parses command message, extracts "add" command and song id array.
5. | 5. Server adds specified track to play queue, returns the updated play queue information.
6. | 6. Client updates the jMPC_Play_Queue_View to reflect the changes.

**Scenario Notes:**

The user is allowed to multi-select tracks in the library. They will be placed into the queue in ascending id order.

**Post Conditions:**

1. The daemon's play queue now contains the user selected tracks.
2. The client's GUI reflects the changes in the play queue.

**Exceptions:**

1. The database cannot be accessed
2. The music directory cannot be accessed
3. The daemon is not running
4. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View
2. jMPC_Library_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 7: UserRemovesTrackFromPlayQueue**

**Overview:**

Allows user to remove tracks from the play queue.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.
4. User is looking at jMPC_Play_Queue_View.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks on a track in the play queue. | 1. Client highlights the track entry with a contrasting background color.
2. User presses the 'r' key. | 2. Client sends the "remove" command and the track id in an array to the daemon.
3. | 3. Server recieves command message.
4. | 4. Server parses command message, extracts "remove" command and song id array.
5. | 5. Server removes specified track from the play queue, returns the updated play queue information.
6. | 6. Client updates the jMPC_Play_Queue_View to reflect the changes.

**Scenario Notes:**

The user is allowed to multi-select tracks in the library. They will all be removed from the play queue.

**Post Conditions:**

1. The daemon's play queue no longer contains the user selected tracks.
2. The client's GUI reflects the changes in the play queue.

**Exceptions:**

1. The database cannot be accessed
2. The music directory cannot be accessed
3. The daemon is not running
4. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View
2. jMPC_Play_Queue_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 8: UserClearsPlayQueue**

**Overview:**

Allows user to remove all tracks from the play queue.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks on a track in the play queue. | 1. Client highlights the track entry with a contrasting background color.
2. User presses the 'c' key. | 2. Client sends the "clear" command to the daemon.
3. | 3. Server recieves command message.
4. | 4. Server parses command message, extracts "clear" command.
5. | 5. Server removes removes all tracks from the play queue, returns the updated play queue information.
6. | 6. Client updates the jMPC_Play_Queue_View to reflect the changes.

**Scenario Notes:**

If the play queue is empty, the client does not send the clear command.

**Post Conditions:**

1. The daemon's play queue no longer contains any tracks.
2. The client's GUI reflects the changes in the play queue.

**Exceptions:**

1. The daemon is not running
2. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 9: UserRaisesVolume**

**Overview:**

Allows user to raise the the volume.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The jMPC is connected to jMPD on the same configured port.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User presses the '+' key | 1. Client sends the "raise" command to the daemon.
2. | 2. Server recieves command message.
3. | 3. Server parses command message, extracts "raise" command.
4. | 4. Server raises its output volume.
5. | 5. The client updates the displayed volume in the jMPC_Main_View

**Scenario Notes:**

If the volume is currently at 100%, the client will not send the message.

**Post Conditions:**

1. The daemon's volume level is raised.
2. The client's GUI reflects the changes to the volume level.

**Exceptions:**

1. The daemon is not running
2. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 10: UserLowersVolume**

**Overview:**

Allows user to lower the the volume.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The jMPC is connected to jMPD on the same configured port.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User presses the '-' key | 1. Client sends the "lower" command to the daemon.
2. | 2. Server recieves command message.
3. | 3. Server parses command message, extracts "lower" command.
4. | 4. Server lowers its output volume.
5. | 5. The client updates the displayed volume in the jMPC_Main_View

**Scenario Notes:**

If the volume is currently at 0%, the client will not send the message.

**Post Conditions:**

1. The daemon's volume level is lowered.
2. The client's GUI reflects the changes to the volume level.

**Exceptions:**

1. The daemon is not running
2. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 11: UserBrowsesLibrary**

**Overview:**

Allows user to browse the library.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks on an artist name in the library view. | 1. Client highlights the artist entry with a contrasting background color, and loads that artist's albums in the album pane.
2. User clicks on an album name in the library pane. | 2. Client highlights the album entry with a contrasting background color, and loads that album's list of tracks in the song pane.

**Scenario Notes:**

None

**Post Conditions:**

1. The client GUI displays the information requested by the user.

**Exceptions:**

1. The daemon is not running.
2. The client is not connected to the same port as jMPD. 

**Required GUI:**

1. jMPC_Main_View
2. jMPC_Library_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 12: UserCreatesNewPlaylist**

**Overview:**

Allows user to create a playlist.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.
4. The playlist directory is writable.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks on the Add New Playlist button in the left pane. | 1. Client opens a text entry view
2. User types in a string of characters for the name of the playlist. | 2. Client echos their input in the text entry box.
3. User presses enter, or clicks the "Done" button | 3. Client sends the "new" command to the daemon along with the user string.
4. | 4. Server recieves command message.
5. | 5. Server parses command message, extracts "new" command and the playlist name string.
6. | 6. Server creates an empty playlist in the predefined playlist directory with the given name, returns "done" message to the client. 
7. | 7. Client displays the new entry in the left pane, under the Playlist header.

**Scenario Notes:**

Until the user enters text, the "Done" button will be greyed out.

**Post Conditions:**

1. The client GUI displays the information requested by the user.

**Exceptions:**

1. The daemon is not running.
2. The client is not connected to the same port as jMPD.
3. The user string matches a playlist that already exists. Displays error message, allows the user to retry.

**Required GUI:**

1. jMPC_Text_Entry_View
2. jMPC_Library_View or jMPC_Play_Queue_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 13: UserDeletesPlaylist**

**Overview:**

Allows user to delete a playlist.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.
4. The playlist directory is writable.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User right clicks on a playlist entry in the left pane. | 1. Client opens a context menu for playlist.
2. User clicks "Delete" context menu item. | 2. Client sends the "delete" command to the daemon, along with the playlist name.
3. | 3. Server recieves command message.
4. | 4. Server parses command message, extracts "delete" command and the playlist name string.
5. | 5. Server finds the playlist with the given name, deletes it, and returns "done" message to the client. 
6. | 6. Client removes the corresponding playlist entry from the left pane.

**Scenario Notes:**

None

**Post Conditions:**

1. The client GUI displays the information requested by the user.

**Exceptions:**

1. The daemon is not running.
2. The client is not connected to the same port as jMPD.
3. The playlist directory is not writable.

**Required GUI:**

1. jMPC_Main_View
2. jMPC_Playlist_Context_Menu

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 14: UserAddsToPlaylist**

**Overview:**

Allows user to add tracks to a playlist.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.
4. The playlist directory is writable.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks on a track entry in the library view. | 1. Client highlights the track entry with a contrasting background color.
2. User presses the 'p' key. | 2. Client opens a list view that displays the existing playlists.
3. User clicks the desired playlist entry. | 2. highlights the playlist entry with a contrasting background color.
4. User presses enter, or clicks the "Done" button | 3. Client sends the "addp" command, the playlist name and the track id in an array to the daemon.
5. | 3. Server recieves command message.
6. | 4. Server parses command message, extracts "addp" command, the playlist name and song id array.
7. | 5. Server adds specified track to the specified playlist, returns the updated playlist information.
8. | 6. Client updates the GUI representation of the playlist to reflect the changes.

**Scenario Notes:**

The user is allowed to multi-select tracks in the library. They will be placed into the playlist in ascending id order.

**Post Conditions:**

1. The client GUI displays the information requested by the user.

**Exceptions:**

1. The daemon is not running.
2. The client is not connected to the same port as jMPD.
3. The playlist directory is not writable.

**Required GUI:**

1. jMPC_Library_View
2. jMPC_Playlist_Select_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 15: UserRemovesFromPlaylist**

**Overview:**

Allows user to remove tracks from a playlist.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.
4. The playlist directory is writable.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks on a playlist in the left pane. | 1. Client highlights the playlist entry with a contrasting background color and opens the playlist in a jMPC_Play_Queue_View.
2. User clicks the desired track entry. | 2. highlights the track entry with a contrasting background color.
3. User presses the 'd' key. | 3. Client sends the "removep" command, the playlist name and the track id in an array to the daemon.
3. | 3. Server recieves command message.
4. | 4. Server parses command message, extracts "removep" command, the playlist name and song id array.
5. | 5. Server removes the specified track from the specified playlist, returns the updated playlist information.
6. | 6. Client updates the GUI representation of the playlist to reflect the changes.

**Scenario Notes:**

The user is allowed to multi-select tracks in the playlist. They will all be removed from the playlist.

**Post Conditions:**

1. The client GUI displays the updated playlist information.
2. The playlist file no longer contains the deleted entries.

**Exceptions:**

1. The daemon is not running.
2. The client is not connected to the same port as jMPD.
3. The playlist directory is not writable.

**Required GUI:**

1. jMPC_Main_View
2. jMPC_Play_Queue_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 16: UserSavesPlayQueueToPlaylist**

**Overview:**

Allows user to save the current play queue as a playlist.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is connected to jMPD on the same configured port.
4. The playlist directory is writable.
5. The play queue is not empty

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User presses the 's' key. | 1. Client opens a text entry view
2. User types in a string of characters for the name of the playlist. | 2. Client echos their input in the text entry box.
3. User presses enter, or clicks the "Done" button | 3. Client sends the "save" command to the daemon along with the user string.
4. | 4. Server recieves command message.
5. | 5. Server parses command message, extracts "save" command, and the playlist name string.
6. | 6. Server creates a new playlist with the current play queue as its track listing.
7. | 7. Client updates the list of playlists to show the new playlist.

**Scenario Notes:**

The user is allowed to multi-select tracks in the playlist. They will all be removed from the playlist.

**Post Conditions:**

1. The client GUI displays the updated playlist information.
2. The playlist file no longer contains the deleted entries.

**Exceptions:**

1. The daemon is not running.
2. The client is not connected to the same port as jMPD.
3. The playlist directory is not writable.

**Required GUI:**

1. jMPC_Main_View
2. jMPC_Play_Queue_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---

**Use Case 17: UserConfiguresDaemonSettings**

**Overview:**

Allows user to configure the jMPD settings.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The config file is writable.
3. The jMPC is connected to jMPD on the same configured port.

**Scenario:**

Action | Software Reaction 
------ | -----------------
1. User clicks "daemon" menu bar entry | 1. Client populates and expands the daemon menu.
2. User points cursor to the "settings" item | 2. Client highlights the item with a contrasting background color.
3. User clicks "settings" item | 3. Client opens and populates the jMPC_Daemon_Config_View
4. User clicks one of the textboxes in the config view. | 4. A text cursor begins blinking in the clicked textbox.
5. User edits the text in the textbox | 5. The client echos the user's edits.
6. User clicks the "Save" button in the jMPC_Daemon_Config_View | 6. Client writes the changes to the config file.

**Scenario Notes:**

If the "Cancel" button is instead pressed, the config file is left unchanged.

**Post Conditions:**

1. The daemon's configuration file now contains the updated information.

**Exceptions:**

1. The config file is writable.

**Required GUI:**

1. jMPC_Main_View
2. jMPC_Menu_Bar
3. jMPC_Menu_Daemon_Entry
4. jMPC_Daemon_Config_View

**Use Cases Utilized:**

None

**Timing Constraints:**

None

---