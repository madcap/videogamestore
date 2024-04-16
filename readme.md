
## demo project

video game rental back end server

supports searching by phrase for video games and checking out video games by game id

uses giant bomb api to power search, api key required: https://www.giantbomb.com/api/

## usage

set environment variable containing Giant Bomb api key
```
export GB_API_KEY=a26f1d0ef291fa740a5ad....
```

build with gradle (requires valid api key):
```
./graldew build
```

run server:
```
java -jar build/libs/videogamestore-0.0.1-SNAPSHOT.jar
```

search for a video game:
```
GET http://localhost:8080/search?phrase=helldivers
```

check out a video game:
```
GET http://localhost:8080/checkout/3030-89235
```