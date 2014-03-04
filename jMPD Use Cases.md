jMPD/C Use Cases
==============

**Use Case 1: UserClicksTogglePlaybackButton**

**Overview:**

Allows user to pause or play music playback.

**Preconditions:**

1. The jMPD is listening on the configured port.
2. The database is accessible.
3. The jMPC is running.

**Scenario:**
|:               Action               :|:                 Software Reaction                :|
|--------------------------------------|----------------------------------------------------|
|1. User clicks playback toggle button | 1. Client sends "toggle" command to jMPD over port.|
|                                      | 2. Server recieves command packet.                 |
|                                      | 3. Server parses command.                          |
|                                      | 4. Server executes command.                        |
