Command Protocol
================

**Requests**

Command		Arguments				Return

TOGGLE		""					
PLAY		""					
PAUSE		""					
STOP		""					
NEXT		""					
PREV		""					
SEEK		"time":"123.456"			
DATABASE	""					
ADD		"ids":["1",...]				
UPDATE		""					
REMOVE		"ids":["1",...]				
INFO		""					trackinfo
QUEUE		""					
PLADD		"playlist_name":"...","ids":["1",...]	
PLDEL		"playlist_name":"...","ids":["1",...]	

All commands return at least the following:

"status_code":"..."
"status_message":"..."

Additionally, anything marked with trackinfo will return the following:

track id			"track_id":"1"
elapsed time in seconds 	"time":"123.456"
playback state	(boolean)	"state":"true"


**Status Codes**
These status codes are sent to the client in response to a request

2xx Success
200 OK
201 Created
204 No Content

4xx Client Error
400 Bad Request
404 Not Found
415 Unsupported Media Type
416 Requested Range not Satisfiable
418 I'm a teapot

5xx Server Error
500 Internal Server Error
