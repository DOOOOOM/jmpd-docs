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
3. | 3. Server recieves command packet.
4. | 4. Server parses command packet, extracts "toggle" command.
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
2. | 2. Server recieves command packet.
3. | 3. Server parses command packet, extracts "next" command.
4. | 4. Server executes command.
5. | 5. Client sends "info" command to jMPD.
6. | 6. Server recieves command packet.
7. | 7. Server parses command packet, extracts "info" command.
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
2. | 2. Server recieves command packet.
3. | 3. Server parses command packet, extracts "prev" command.
4. | 4. Server executes command.
5. | 5. Client sends "info" command to jMPD.
6. | 6. Server recieves command packet.
7. | 7. Server parses command packet, extracts "info" command.
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
2. | 2. Server recieves command packet.
3. | 3. Server parses command packet, extracts "stop" command.
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
4. | 4. Server recieves command packet.
5. | 5. Server parses command packet, extracts "update" command.
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