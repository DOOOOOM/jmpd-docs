Server begins execution

Reads a configuration file
  Gets listening port number
  Gets the address
  Gets the default music directory
  Gets the path to the database
  Gets the path to the play queue file
  (Possibly get the path the playlist directory)

Update the database, looking for changed/new files

Initialize the play queue file

Begin listening on the port for client side commands
(Possibly require authetication for connections)

HTTP style commands?

Player controls:
Play, Pause, Previous, Next, Toggle, Jump to time, 

Monitoring:
Get
	return				given
	Song info			{song id}
	playlist info		{playlist id}
	playlist list 		{}


Play Queue controls:
Insert track
Remove track


DICTIONARY
	daemon
	playlist