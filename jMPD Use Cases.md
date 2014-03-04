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