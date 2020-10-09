# Instagram Connections Service

instagram-connections is a bare bones java service to work with Instagram data. This service works only with data download functionality of Instagram. This service has no working integration with any Instagram APIs nor do we ask you to login to Instagram here.

## Installation

```bash
mvn clean install package
```
## How to use
* Get a copy of your data from Instagram. This is there in settings.
* Simple copy and paste the  connections.json from this data download to resources folder in this service and we are good to go.
* Start the Main class and access below Apis as required.

## Apis
* http://localhost:7070/api/instagram/whonotfollowme
* http://localhost:7070/api/instagram/followrequestssent
* http://localhost:7070/api/instagram/followingme


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
