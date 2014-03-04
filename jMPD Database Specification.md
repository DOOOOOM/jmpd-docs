Database Specification
======================


**Introduction**
The database is a flat file, stored in a filename as defined in the configuration properties file with the key "database-location"

Each file in the database will have a certain number of key-value pairs as defined further in this document. Each audio file in the database ("track") has these keys:

REQUIRED:

  id                      a unique ID used to identify the track to the daemon and client.
  filename                the relative path to the file

OPTIONAL:

  title                   
  artist                  
  album                   
  year of publication     
  track number            
  total tracks on album   
  album art filename      
