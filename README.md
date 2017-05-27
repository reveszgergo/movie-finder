# Movie Finder

##Leírás:
Az alkalmazásban filmekre kereshetsz rá, valamint megoldhatsz egy kvíz kérdéssort, ahol pont jár minden egyes jó válaszért, és akár felkerülhetsz a Top 10-es táblára is.

##Követelmény:
A program fordításához és működéséhez az alábbiak szükségesek:
* JDK 1.8
* Apache Maven

##Használat:
A következő parancsot add ki a projekt mappájában:
```
mvn package
```
Ha ez sikerrel járt, akkor a `target` mappán belül létrejövő `movie-finder-1.0-jar-with-dependencies` fájlt futtatva használhatod a programot.

##Oldal generálása:
Használd a következő parancsot a projekt mappájában a projekt oldalának legenerálásához és az ehhez tartozó jelentések megtekintéséhez:
```
mvn site
```
Az oldal a `target` mappán belül a `site` mappában lesz elérhető.
