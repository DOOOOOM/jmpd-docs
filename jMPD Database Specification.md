Database Specification
======================


**Introduction**

The database is a flat file, stored in a filename as defined in the configuration properties file with the key "database-location"


**Track Info**

Each file in the database will have a certain number of key-value pairs as defined further in this document. Each audio file in the database ("track") has these keys:

REQUIRED:

* id: a unique ID used to identify the track to the daemon and client.
* filename: the relative path to the file

OPTIONAL:

* title
* artist
* album
* year: year of publication
* track: track number
* total-tracks: total tracks on album
* length: length of song in seconds
* album-art: filepath to album art (relative)

They will be stored in a JSON format. There should also be a field in the JSON object that specifies the possible fields.  Here is an example of a complete, although small, database file:

    {
      "FIELDS" : { "id" : "filename" : "title" : "artist" }
      "SONGS" : [
        { "id" : "414e395c639c173d" , "filename" : "path/to/file.mp3" , "title" : "SONG!" , "artist" : "MUSIC!" },
        { "id" : "bc9c4520e8c8e3f9" , "filename" : "path/to/other_file.mp3" , "title" : "OTHER SONG!" , "artist" : "NOT MUSIC!" }
      ]
    }
    
Note that now we have defined the fields available, and all are being used by both of our tracks.
