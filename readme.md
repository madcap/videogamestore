
## demo project

video game rental back end server

uses giant bomb api to power search, api key required: https://www.giantbomb.com/api/

## usage

set environment variable containing Giant Bomb api key
```
export GB_API_KEY=a26f1d0ef291fa740a5ad....
```

build with gradle (requires valid api key):
```
./gralde build
```

run server:
```
java -jar build/libs/videogamestore-0.0.1-SNAPSHOT.jar
```

search for a video game:
```
http://localhost:8080/search?phrase=darktide
```

check out a video game:
```
TODO
```